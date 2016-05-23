package org.john.bin.parser;

import java.util.List;

public class MyBatisConfigParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		
		parsedTemplate = parsedTemplate.replace("{{Aliases}}", this.generateAliases());
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generateAliases () {
		StringBuilder sb = new StringBuilder();
		List<String> list = this.getModelList();
		for (String entity : list) {
			sb.append("<typeAlias alias=\""+ ((entity.charAt(0)+"").toLowerCase() + entity.substring(1)) +"\" type=\""+ this.getPathManager().getEntityPackagePath() + "." + entity +"\" />\n");
		}
		
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
