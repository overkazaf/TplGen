package org.john.bin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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

import org.john.bin.compiler.TplCompiler;
import org.john.bin.utils.PathManager;

public class TplGen {
	// �������õ�property�ļ�·��
	private String propertiesName;
	private Properties properties;
	private InputStream inputStream;
	
	// �������property key-value ��ֵ��
	private Map<String, String> parsedConfigurationMap;
	
	// �û������ģ���б�
	private List<String> modelList;
	
	// ģ������б�
	private List<String> tplList;
	
	// ģ������������ģ��������ݵ�ӳ���ֵ�
	private Map<String, String> tplMap;
	
	// ģ���ֵ䣬 ����ÿһ��ģ�͵�����������ֵkey-value��
	private Map<String, Map<String, String>> modelMap;
	
	// ģ�������ʵ������ ���ڱ���ģ��
	private TplCompiler compiler;
	
	// ·�����������󣬸�����·����صĳ�ʼ���ͻ�ȡ����
	private PathManager pathManager;
	
	// ���뻺���ֵ䣬�洢ÿһ��ʵ�������Ŀ���ַ���
	private Map<String, Map<String, String>> compiledCache;

	/**
	 * 
	 * @param propertiesName  ���������ļ���·��
	 */
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
	 * step1. �������ļ�
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
		}
	};

	/**
	 * step2. ����properties�����ļ���k-v�ֵ�
	 */
	public void parseConfig() {
		try {
			this.properties.load(this.inputStream);
			Enumeration enum1 = this.properties.propertyNames();// �õ������ļ�������
			System.out.println("Start parsing configurations...");
			while (enum1.hasMoreElements()) {
				String key = (String) enum1.nextElement();
				String value = (String) this.properties.getProperty(key);
				this.parsedConfigurationMap.put(key, value);
			}
			this.inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Stop parsing configurations...");
		}
	}
	
	/**
	 * step 3  ��ʼ��·������������
	 */
	public void initPathManager () {
		this.pathManager = new PathManager(this.parsedConfigurationMap);
	}
	
	/**
	 * step 4.0 ��ȡÿһ��ģ�͵Ķ��壬 ����modelMap��һ���ݽṹ��
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

					Enumeration enum1 = p.propertyNames();// �õ������ļ�������
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
	 * step 4.1 ��ʼ��ģ����룬�����뻺����
	 * 
	 * @return
	 */
	public void initTemplate() {
		String tplPath = this.pathManager.getTplPath();
		System.out.println("tplPath  " + tplPath);
		File tplDir = new File(tplPath);
		String[] tpls = tplDir.list();
		for (String tplName : tpls) {
			StringBuilder sb = new StringBuilder();
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
	
	/**
	 * step 4.2 ��ʼ������Ŀ���ļ��У���֤�ܽ����ɵ�Ŀ����������ȷд����Ӧ·��
	 * 
	 * @return
	 */
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
			System.out.println("Trying creating folder " + path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
		}
		System.out.println("End creating path list:\n");
	}

	/**
	 * step 4.3 ��ʼ��������ʵ��
	 * 
	 * @return
	 */
	public void initTplCompiler() {
		this.compiler = new TplCompiler(this.parsedConfigurationMap);
	}

	/**
	 * step 5.0 ִ�б������񣬽�������д�뻺��
	 * 
	 * @return
	 */
	public Boolean execCompileTask() {
		List<String> modelList = this.modelList;
		List<String> tplList = this.tplList;
		Map<String, Map<String, String>> modelMap = this.modelMap;
		Map<String, String> tplMap = this.tplMap;
		for (String modelName : modelList) {
			for (String tplName : tplList) {
				String targetTpl = this.compiler.compile(modelName, modelMap.get(modelName), tplName, tplMap.get(tplName), modelList);
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
	 * step 6 д�뱾���ļ�
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
	
	/**
	 * 
	 * @param model         ����ģ������
	 * @param tplName	          ģ������
	 * @param compiledTpl   ������ģ���ַ���
	 */
	public void write2DiskByDetail (String model, String tplName, String compiledTpl) {
		String fileName = "";
		
		System.out.println("Writing "+ model+ " to disk...\n");
		System.out.println(compiledTpl + "\n");
		switch (tplName.toLowerCase()) {
			case "entity":
				fileName = pathManager.getEntityPath() + File.separator + model + ".java";
				break;
			case "mapper":
				fileName = pathManager.getMapperPath() + File.separator + model + "Mapper.java";
				break;
			case "service":
				fileName = pathManager.getServicePath() + File.separator + model + "Service.java";
				break;
			case "serviceimpl":
				fileName = pathManager.getServiceImplPath() + File.separator + model + "ServiceImpl.java";
				break;
			case "mybatismapper":
				fileName = pathManager.getMyBatisMapperPath() + File.separator + model + "Mapper.xml";
				break;
			case "mybatisconfig":
				fileName = pathManager.getMyBatisConfigPath() + File.separator + "mybatis-config.xml";
				break;
			case "controller":
				fileName = pathManager.getControllerPath() + File.separator + model + "Controller.java";
				break;
			default:;
		}
		
		WriteThread thread = new WriteThread(fileName, compiledTpl);
		thread.start();
	}
	
	class WriteThread extends Thread {
		private String taskName;
		private String tpl;
		
		public WriteThread (String taskName, String tpl) {
			this.taskName = taskName;
			this.tpl = tpl;
		}
		public void run () {
			try {
				OutputStream os = new FileOutputStream(this.getTaskName());
				os.write(this.getTpl().getBytes());
				os.close();
				System.out.println(this.getTaskName() + " has been successfully written to target folder");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void setTaskName (String task) {
			this.taskName = task;
		}
		
		public String getTaskName () {
			return taskName;
		}
		
		public void setTpl (String tpl) {
			this.tpl = tpl;
		}
		
		public String getTpl () {
			return tpl;
		}
	}

	/**
	 * TplGenʵ��ִ�д�����������
	 * �����д���̵Ĳ����Զ��̼߳���
	 */
	public void exec() {
		// ���������õ�properties�ļ�
		this.readConfig();
		
		// �����������õ�properties����key-value��ʽ�洢
		this.parseConfig();
		
		// ��ʼ��·��������
		this.initPathManager();
		
		this.initModels();
		this.initTemplate();
		this.initFolders();
		this.initTplCompiler();

		// ��������models����ģ��
		this.execCompileTask();

		// д���ش���
		this.write2Disk();

	};

	public static void main(String[] args) {
		String test = "E:\\Workspace\\Handson\\src\\org\\john\\bin\\test.properties";
		TplGen tplGen = new TplGen(test);
		tplGen.exec();
	}
}
