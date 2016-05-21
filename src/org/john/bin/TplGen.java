package org.john.bin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.john.bin.parser.TplCompiler;

public class TplGen {
	private String propertiesName;
	private Properties properties;
	private InputStream inputStream;
	private Map<String, String> parsedConfigurationMap;
	private List<String> modelList;
	private List<String> tplList;
	private Map<String, String> tplMap;
	private Map<String, Map<String, String>> modelMap;
	private TplCompiler compiler;
	
	private PathManager pathManager;
	
	
	private Map<String, Map<String, String>> compiledCache;

	public TplGen(String propertiesName) {
		this.propertiesName = propertiesName;
		this.parsedConfigurationMap = new HashMap<String, String>();
		this.modelList = new ArrayList<String>();
		this.tplList = new ArrayList<String>();
		this.modelMap = new HashMap<String, Map<String, String>>();
		this.tplMap = new HashMap<String, String>();
		this.compiledCache = new HashMap<String, Map<String, String>>();
	};

	/**
	 * step1. 读配置文件
	 */
	public void readConfig() {
		this.properties = new Properties();
		InputStream is;
		try {
			is = new FileInputStream(this.propertiesName);
			this.inputStream = is;

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};

	/**
	 * step2. 解析配置文件
	 */
	public void parseConfig() {
		try {
			this.properties.load(this.inputStream);
			Enumeration enum1 = this.properties.propertyNames();// 得到配置文件的名字
			System.out.println("Start parsing configurations...");
			while (enum1.hasMoreElements()) {
				String key = (String) enum1.nextElement();
				String value = (String) this.properties.getProperty(key);
				this.parsedConfigurationMap.put(key, value);
			}
			this.inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Stop parsing configurations...");
		}
	}
	
	public void initPathManager () {
		this.pathManager = new PathManager(this.parsedConfigurationMap);
	}

	/**
	 * step3. 获取模型定义
	 */
	public void initModels() {
		ArrayList<String> modelList = new ArrayList<String>();
		Map<String, Map<String, String>> modelMap = new HashMap<String, Map<String, String>>();

		String folderName = this.pathManager.getAppPath() + File.separator
				+ (String) this.parsedConfigurationMap.get("modelFolder");
		File dir = new File(folderName);
		String[] list = dir.list();
		for (String pathname : list) {
			File f = new File(pathname);

			if (!f.isDirectory()) {
				// parseFile
				String modelName = pathname.split("\\.")[0];
				try {
					Properties p = new Properties();
					InputStream is = new FileInputStream(new File(folderName + File.separator + pathname));
					p.load(is);

					Map<String, String> propMap = new HashMap<String, String>();

					Enumeration enum1 = p.propertyNames();// 得到配置文件的名字
					System.out.println("======================Start parsing model::" + modelName+"======================");
					while (enum1.hasMoreElements()) {
						String key = (String) enum1.nextElement();
						String value = (String) p.getProperty(key);
						propMap.put(key, value);
					}
					modelList.add(modelName);
					modelMap.put(modelName, propMap);
					System.out.println("======================End parsing model::" + modelName+"======================");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		this.modelList = modelList;
		this.modelMap = modelMap;
	}

	/**
	 * step 4.1 初始化模板
	 * 
	 * @return
	 */
	public void initTemplate() {
		String tplPath = this.pathManager.getTplPath();
		System.out.println("tplPath  " + tplPath);
		File tplDir = new File(tplPath);
		String[] tpls = tplDir.list();
		for (String tplName : tpls) {
			StringBuffer sb = new StringBuffer();
			try {
				File tempFile = new File(tplDir + File.separator + tplName);
				FileReader isr = new FileReader(tempFile);
				BufferedReader br = new BufferedReader(isr);
				String line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

				String tpl = tplName.split("\\.")[0];
				System.out.println(tpl + "   " + sb.toString());
				this.tplList.add(tpl);
				this.tplMap.put(tpl, sb.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void initFolders() {
		String[] paths = {
				pathManager.getControllerPath(),
				pathManager.getEntityPath(),
				pathManager.getServicePath(),
				pathManager.getServiceImplPath(),
				pathManager.getMapperPath(),
				pathManager.getMyBatisMapperPath(),
				pathManager.getMyBatisConfigPath()
		};
		
		System.out.println("Initializign path list:\n");
		for (String path : paths) {
			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
		}
		System.out.println("End creating path list:\n");
	}

	/**
	 * 初始化编译器实例
	 */
	public void initTplCompiler() {
		this.compiler = new TplCompiler(this.parsedConfigurationMap);
	}

	/**
	 * step 4.2 编译模板
	 * 
	 * @return
	 */
	public Boolean compileTemplate() {
		List<String> modelList = this.modelList;
		List<String> tplList = this.tplList;
		Map<String, Map<String, String>> modelMap = this.modelMap;
		Map<String, String> tplMap = this.tplMap;
		List<String> resultList = new ArrayList<String>();
		for (String modelName : modelList) {
			for (String tplName : tplList) {
				String targetTpl = this.compiler.compile(modelName, modelMap.get(modelName), tplName, tplMap.get(tplName));
				Map<String, String> map = compiledCache.get(modelName);
				if (map == null) {
					map = new HashMap<String, String>();
				}
				map.put(tplName, targetTpl);
				compiledCache.put(modelName, map);
			}
		}
		return true;
	}

	/**
	 * step5. 编译mybatis配置文件
	 * 
	 * @return
	 */
	public Boolean compileMybatisConfig() {

		return true;
	}

	/**
	 * step6. 编译mybatis的mapper文件
	 * 
	 * @return
	 */
	public Boolean compileMybatisMapper() {

		return true;
	}

	/**
	 * step7. 写入本地文件
	 * 
	 * @return
	 */
	public Boolean write2Disk() {
		Set<String> models = compiledCache.keySet();
		for (String model : models) {
			Map<String, String> modelTplMap = compiledCache.get(model);
			Set<String> tplNames = modelTplMap.keySet();
			
			for (String tplName : tplNames) {
				write2DiskByDetail(model, tplName, modelTplMap.get(tplName));
			}
		}
		return true;
	}
	public void write2DiskByDetail (String model, String tplName, String compiledTpl) {
		String fileName = "";
		switch (tplName.toLowerCase()) {
			case "entity":
				System.out.println("Writing "+ model+ " to disk...\n");
				System.out.println(compiledTpl + "\n");
				fileName = pathManager.getEntityPath() + File.separator + model + ".java";
				
			break;
			default:;
		}
		
		File file = new File(fileName);
		try {
			OutputStream os = new FileOutputStream(file);
			os.write(compiledTpl.getBytes());
			os.close();
			System.out.println(fileName + " has been successfully written");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 执行代码生成任务
	 * 编译和写磁盘的步骤以多线程加速
	 */
	public void exec() {
		this.readConfig();
		this.parseConfig();
		this.initPathManager();
		
		// 初始化models和template
		this.initModels();
		this.initTemplate();
		this.initFolders();
		this.initTplCompiler();

		// 根据数据models编译模板
		this.compileTemplate();
		this.compileMybatisConfig();
		this.compileMybatisMapper();

		// 写本地磁盘
		this.write2Disk();

	};

	public Boolean GenTemplates() {

		return true;
	};

	public static void main(String[] args) {
		String test = "E:\\Workspace\\Handson\\src\\org\\john\\bin\\test.properties";
		TplGen tplGen = new TplGen(test);
		tplGen.exec();
	}
}
