package org.john.bin;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TplGen {
	private String propertiesName;
	private Properties properties;
	private InputStream inputStream;
	private Map<String, String> parsedConfigurationMap;
	private Map<String, String> modelMap;

	public TplGen(String propertiesName) {
		this.propertiesName = propertiesName;
		this.parsedConfigurationMap = new HashMap<String, String>();
		this.modelMap = new HashMap<String, String>();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	};

	/**
	 * step2. ���������ļ�
	 */
	public void parseConfig() {
		try {
			this.properties.load(this.inputStream);
			Enumeration enum1 = this.properties.propertyNames();// �õ������ļ�������
			System.out.println("Start parsing configurations...");
			while (enum1.hasMoreElements()) {
				String key = (String) enum1.nextElement();
				String value = (String)this.properties.getProperty(key);
				System.out.println(key + "  == >  " + value);
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

	/**
	 * @return
	 */
	public String getAppPath () {
		String temp = System.getProperty("user.dir") + File.separator + "src" + File.separator + (String)this.parsedConfigurationMap.get("pkgPrefix") + File.separator +(String)this.parsedConfigurationMap.get("modelFolder");
		String appPath = temp.replace("/", File.separator);
		return appPath;
	}
	
	/**
	 * step3. ��ȡģ�Ͷ���
	 */
	public void initModels() {
		ArrayList<String> modelList = new ArrayList<String>();
		Map<String, String> modelMap = new HashMap<String, String>();
		
		String folderName = this.getAppPath();
		System.out.println("Folder Name " + folderName);
		File dir = new File(folderName);
		String[] list = dir.list();
		for (String pathname : list) {
			File f = new File(pathname);
			
			if (!f.isDirectory()) {
				// parseFile
			}
		}
	}

	/**
	 * step4. ����ģ��
	 * 
	 * @return
	 */
	public Boolean compileTemplate() {

		return true;
	}

	/**
	 * step5. ����mybatis�����ļ�
	 * 
	 * @return
	 */
	public Boolean compileMybatisConfig() {

		return true;
	}

	/**
	 * step6. ����mybatis��mapper�ļ�
	 * 
	 * @return
	 */
	public Boolean compileMybatisMapper() {

		return true;
	}

	/**
	 * step7. д�뱾���ļ�
	 * 
	 * @return
	 */
	public Boolean write2Disk() {

		return true;
	}

	/**
	 * ִ����������
	 */
	public void exec() {
		this.readConfig();
		this.parseConfig();
		this.initModels();
		
		
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
