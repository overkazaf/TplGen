package org.john.bin.parser;


import java.util.Map;
import java.util.Set;

import org.john.bin.utils.Common;
import org.john.bin.utils.PathManager;

public class ControllerParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getControllerPackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", generateImports());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", Common.firstCharToLowerCase(this.getModelName()));
		
		parsedTemplate = parsedTemplate.replace("{{RequestParams}}", generateRequestParams());
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generateImports () {
		StringBuilder sb = new StringBuilder();
		
		sb.append("import java.util.*;\n");
		sb.append("import "+ this.getPathManager().getServicePackagePath() + "." + this.getModelName() +"Service;\n");
		// spring×¢½â
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Controller;\n");
		sb.append("import javax.annotation.Resource;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMethod;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestParam;\n");
		sb.append("import javax.servlet.http.HttpServletRequest;\n");
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
			sb.append("@RequestParam " + map.get(key) + " " + key);
		}
		
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
