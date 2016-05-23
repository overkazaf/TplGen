package org.john.bin.parser;

import org.john.bin.utils.PathManager;

public class ServiceImplParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getServiceImplPackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", generateImports());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", ((this.getModelName().charAt(0)+"").toLowerCase() + this.getModelName().substring(1)));
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generateImports () {
		StringBuilder sb = new StringBuilder();
		
		sb.append("import java.util.*;\n");
		sb.append("import "+ this.getPathManager().getEntityPackagePath() + "." + this.getModelName() +";\n");
		sb.append("import "+ this.getPathManager().getMapperPackagePath() + "." + this.getModelName() +"Mapper;\n");
		sb.append("import "+ this.getPathManager().getServicePackagePath() + "." + this.getModelName() +"Service;\n");
		
		// spring×¢½â
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		sb.append("import org.springframework.stereotype.Resource;\n");
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
