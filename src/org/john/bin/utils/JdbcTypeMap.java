package org.john.bin.utils;

import java.util.HashMap;
import java.util.Map;

public class JdbcTypeMap {
	private Map<String, String> map;
	
	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public JdbcTypeMap () {
		map = new HashMap<String, String>();
		initMapping();
	}
	
	public void initMapping () {
		// create jdbcType 2 javaType mapping
		map.put("VARCHAR", "String");
		map.put("TIMESTAMP", "Timestamp");
		map.put("BIT", "Boolean");
		map.put("BIGINT", "long");
		//map.put("BINARY", "byte[]");
		map.put("BLOB", "byte[]");
		//map.put("CHAR", "String");
		//map.put("CLOB", "String");
		map.put("DATE", "Date");
		map.put("DECIMAL", "BigDecimal");
		map.put("DOUBLE", "Double");
		map.put("FLOAT", "Float");
		map.put("INTEGER", "Integer");
		map.put("JAVA_OBJECT", "Object");
		//map.put("LONGVARCHAR", "String");
		map.put("NUMERIC", "BigDecimal");
		map.put("REAL", "Float");
		map.put("SMALLINT", "Integer");
	}
}
