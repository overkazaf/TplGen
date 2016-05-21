package org.john.bin.parser;

import java.util.Map;

import org.john.bin.PathManager;

public class ServiceParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		Map<String, String> modelMap = this.getModelMap();
		Map<String, String> configMap = this.getConfigMap();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getServicePackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", generateImports());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generateImports () {
		StringBuilder sb = new StringBuilder();
		
		sb.append("import java.util.*;\n");
		sb.append("import "+ this.getPathManager().getEntityPackagePath() + "." + this.getModelName() +";\n");
		
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
