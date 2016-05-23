package org.john.bin.parser;


import java.util.Map;
import java.util.Set;

import org.john.bin.utils.PathManager;

public class ControllerParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getControllerPackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", generateImports());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", ((this.getModelName().charAt(0)+"").toLowerCase() + this.getModelName().substring(1)));
		
		parsedTemplate = parsedTemplate.replace("{{RequestParams}}", generateRequestParams());
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generateImports () {
		StringBuilder sb = new StringBuilder();
		
		sb.append("import java.util.*;\n");
		sb.append("import "+ this.getPathManager().getEntityPackagePath() + "." + this.getModelName() +";\n");
		sb.append("import "+ this.getPathManager().getServicePackagePath() + "." + this.getModelName() +"Service;\n");
		// spring×¢½â
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Controller;\n");
		return sb.toString();
	}
	
	public String generateRequestParams () {
		StringBuilder sb = new StringBuilder();
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		
		for (String key : keys) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append("@RequestParam " + key);
		}
		
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
