package org.john.bin.parser;

import org.john.bin.utils.Common;
import org.john.bin.utils.PathManager;

public class MapperParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getMapperPackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", generateImports());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", Common.firstCharToLowerCase(this.getModelName()));

		parsedTemplate = parsedTemplate.replace("{{PK}}", this.getConfigMap().get("primaryKeyType"));
		
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
