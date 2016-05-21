package org.john.bin.parser;

import java.util.List;
import java.util.Map;

import org.john.bin.PathManager;

public abstract class ParserBase {
	private String template;
	private String parsedTemplate;
	private String tplName;
	private String modelName;
	private Map<String, String> modelMap;
	private Map<String, String> configMap;
	private PathManager pathManager;
	private List<String> modelList;
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Map<String, String> getModelMap() {
		return modelMap;
	}

	public void setModelMap(Map<String, String> modelMap) {
		this.modelMap = modelMap;
	}
	
	public Map<String, String> getConfigMap() {
		return configMap;
	}

	public void setConfigMap(Map<String, String> configMap) {
		this.configMap = configMap;
	}
	
	public void parse() {
		System.out.println("Override the parse function");
	};
	public boolean checkTemplate() {
		System.out.println("Should be override in subclass for compilation checking");
		return false;
	}
	
	public String getParsedTemplate(){
		return this.parsedTemplate;
	};
	
	public void setParsedTemplate (String tpl) {
		this.parsedTemplate = tpl;
	}

	public PathManager getPathManager() {
		return pathManager;
	}

	public void setPathManager(PathManager pathManager) {
		this.pathManager = pathManager;
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<String> getModelList() {
		return modelList;
	}

	public void setModelList(List<String> modelList) {
		this.modelList = modelList;
	}
}
