package org.john.bin.parser;

import java.util.Map;
import java.util.Set;

import org.john.bin.utils.JdbcTypeMap;

public class MyBatisMapperParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		
		parsedTemplate = parsedTemplate.replace("{{MapperPackage}}", this.getPathManager().getMapperPackagePath());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{EntityPrimaryKey}}", "id");
		parsedTemplate = parsedTemplate.replace("{{EntityTablePrimaryKey}}", "id");
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", ((this.getModelName().charAt(0)+"").toLowerCase() + this.getModelName().substring(1)));
		
		parsedTemplate = parsedTemplate.replace("{{TablePrefix}}", "");
		
		
		parsedTemplate = parsedTemplate.replace("{{EntityTableKeys}}", generateEntityTableKeys());
		
		parsedTemplate = parsedTemplate.replace("{{EntityKeys}}", generateEntityKeys());

		parsedTemplate = parsedTemplate.replace("{{EntityUpdateArea}}", generateEntityUpdateArea());
		
		this.setParsedTemplate(parsedTemplate);
	}
	public boolean checkTemplate () {
		return true;
	}
	
	
	public String generateEntityKeys () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		JdbcTypeMap jdbcTypeMap = new JdbcTypeMap();
		
		for (String key : keys) {
			String tabKey = Upper2Slashed(key);
			if (sb.length() > 0) {
				sb.append(",");
			}
			String javaType = map.get(key);
			String type = getMapKeyByValue(jdbcTypeMap.getMap(), javaType);
			sb.append("#{" + tabKey + ",jdbcType=" + type +"}");
		}
		
		System.out.println("generateEntityTableKeys  == >  " + sb.toString());
		
		return sb.toString();
	}
	
	
	public String getMapKeyByValue (Map<String, String> map, Object givenValue) {
		String mapKey = "";
		Set<String> keys = map.keySet();
		for (String key: keys) {
			if (map.get(key).equals(givenValue)) {
				mapKey = key;
				break;
			}
		}
		
		return mapKey;
	}
	
	
	public String generateEntityTableKeys () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		
		for (String key : keys) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(Upper2Slashed(key));
		}
		
		System.out.println("generateEntityKeys  == >  " + sb.toString());
		
		return sb.toString();
	}
	
	
	public String Upper2Slashed (String key) {
		String slashed = "";
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			if (Character.isUpperCase(ch)) {
				slashed += "_" + Character.toLowerCase(ch);
			} else {
				slashed += ch;
			}
		}
		
		return slashed;
	}
	
	public String generateEntityUpdateArea () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		JdbcTypeMap jdbcTypeMap = new JdbcTypeMap();
		
		for (String key : keys) {
			if (!key.equals("id")) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				//sb.append("key=#{value,jdbcType=xxx}");
				String updateLine = Upper2Slashed(key) + "=#{" + key + ",jdbcType="+ getMapKeyByValue(jdbcTypeMap.getMap(), map.get(key)) +"}"; 
				sb.append(updateLine);
			}
		}
		
		System.out.println("generateEntityUpdateArea  == >  " + sb.toString());
		
		return sb.toString();
	}
}
