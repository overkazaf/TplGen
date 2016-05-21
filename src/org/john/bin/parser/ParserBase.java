package org.john.bin.parser;

import java.io.File;
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
}
