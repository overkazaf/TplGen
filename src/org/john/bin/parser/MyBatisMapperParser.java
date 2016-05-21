package org.john.bin.parser;


public class MyBatisMapperParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		
		parsedTemplate = parsedTemplate.replace("{{MapperPackage}}", this.getPathManager().getMapperPackagePath());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{EntityKey}}", "id");
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", ((this.getModelName().charAt(0)+"").toLowerCase() + this.getModelName().substring(1)));
		
		this.setParsedTemplate(parsedTemplate);
	}
	public boolean checkTemplate () {
		return true;
	}
}
