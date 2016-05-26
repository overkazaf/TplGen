package org.john.bin.parser;

import java.util.Map;
import java.util.Set;

import org.john.bin.utils.Common;

public class MyBatisMapperParser extends ParserBase{
	public void parse() {
		String parsedTemplate = this.getTemplate();
		
		parsedTemplate = parsedTemplate.replace("{{MapperPackage}}", this.getPathManager().getMapperPackagePath());

		parsedTemplate = parsedTemplate.replace("{{Entity}}", this.getModelName());
		
		parsedTemplate = parsedTemplate.replace("{{EntityPrimaryKey}}", "id");
		parsedTemplate = parsedTemplate.replace("{{EntityTablePrimaryKey}}", "id");
		
		parsedTemplate = parsedTemplate.replace("{{entity}}", Common.firstCharToLowerCase(this.getModelName()));
		
		parsedTemplate = parsedTemplate.replace("{{TablePrefix}}", "");
		
		
		parsedTemplate = parsedTemplate.replace("{{EntityTableKeys}}", generateEntityTableKeys());
		
		parsedTemplate = parsedTemplate.replace("{{EntityKeys}}", generateEntityKeys());

		parsedTemplate = parsedTemplate.replace("{{EntityUpdateArea}}", generateEntityUpdateArea());
		
		System.out.println("getJdbcTypeMap   " + this.getJdbcTypeMap());
		this.setParsedTemplate(parsedTemplate);
	}
	public boolean checkTemplate () {
		return true;
	}
	
	
	public String generateEntityKeys () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		Map<String, String> jdbcTypeMap = this.getJdbcTypeMap();
		
		for (String key : keys) {
			String tabKey = Common.toSlashedCase(key);
			if (sb.length() > 0) {
				sb.append(",");
			}
			String type = jdbcTypeMap.get(key);
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
			sb.append(Common.toSlashedCase(key));
		}
		
		System.out.println("generateEntityKeys  == >  " + sb.toString());
		
		return sb.toString();
	}
	
	
	public String generateEntityUpdateArea () {
		Map<String, String> map = this.getModelMap();
		Set<String> keys = map.keySet();
		StringBuilder sb = new StringBuilder();
		Map<String, String> jdbcTypeMap = this.getJdbcTypeMap();
		
		for (String key : keys) {
			if (!key.equals("id")) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				//sb.append("key=#{value,jdbcType=xxx}");
				String updateLine = Common.toSlashedCase(key) + "=#{" + key + ",jdbcType="+ jdbcTypeMap.get(key) +"}"; 
				sb.append(updateLine);
			}
		}
		
		System.out.println("generateEntityUpdateArea  == >  " + sb.toString());
		
		return sb.toString();
	}
}
