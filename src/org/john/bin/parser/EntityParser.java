package org.john.bin.parser;

import java.util.Map;
import java.util.Set;

import org.john.bin.utils.PathManager;

public class EntityParser extends ParserBase{
	public void parse () {
		String parsedTemplate = this.getTemplate();
		PathManager pathManager = this.getPathManager();
		
		parsedTemplate = parsedTemplate.replace("{{packages}}", "package " + pathManager.getEntityPackagePath() + ";\n\n");
		
		parsedTemplate = parsedTemplate.replace("{{imports}}", "import java.util.*;\n\n");

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{Properties}}", generatePropertyString());

		parsedTemplate = parsedTemplate.replace("{{Setters}}", generateGetters());
		
		parsedTemplate = parsedTemplate.replace("{{Getters}}", generateSetters());
		
		this.setParsedTemplate(parsedTemplate);
	}
	
	public String generatePropertyString () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuffer sb = new StringBuffer();
		
		for (String key : keys) {
			sb.append("\nprivate");
			sb.append(" ");
			sb.append(map.get(key));
			sb.append(" ");
			sb.append(key);
			sb.append(";");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	
	public String generateGetters () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuffer sb = new StringBuffer();
		
		for (String key : keys) {
			// Getter
			sb.append("\r\npublic");
			sb.append(" ");
			sb.append(map.get(key));
			sb.append(" ");
			sb.append("get" + (key.charAt(0)+"").toUpperCase() + key.substring(1));
			sb.append(" () ");
			sb.append("{\n");
			
			sb.append("  return this." + key + ";\n");
			
			sb.append("}\n");
		}
		
		return sb.toString();
	}
	
	
	public String generateSetters () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuffer sb = new StringBuffer();
		
		for (String key : keys) {
			// Setter
			sb.append("\r\npublic");
			sb.append(" void ");
			sb.append("set" + (key.charAt(0)+"").toUpperCase() + key.substring(1));
			sb.append(" ("+ map.get(key) + " " + key.toLowerCase() +") ");
			sb.append("{\n");
			
			sb.append("  this."+ key + " = "+ key.toLowerCase() +";\n");
			
			sb.append("}\n");
		}
		
		return sb.toString();
	}
	
	public boolean checkTemplate () {
		return true;
	}
}
