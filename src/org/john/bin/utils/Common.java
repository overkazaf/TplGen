package org.john.bin.utils;

import java.util.HashMap;
import java.util.Map;

public class Common {

	public static String toCamelCase (String slashed) {
		String camel = "";
		for (int i = slashed.length() - 1; i >= 0; i--) {
			char ch = slashed.charAt(i);
			if (ch == '_') {
				camel = Character.toUpperCase(camel.charAt(0)) + camel.substring(1);
			} else {
				camel = ch + camel;
			}
		}
		return camel;
	}
	
	public static String toSlashedCase (String camel) {
		String slashed = "";
		String prefix = "";
		for (int i = 0, l = camel.length(); i < l; i++) {
			char ch = camel.charAt(i);
			if (Character.isUpperCase(ch)) {
				if (i > 0) prefix = "_";
				slashed = slashed + prefix + Character.toLowerCase(ch);
			} else {
				slashed = slashed + ch;
			}
		}
		return slashed;
	}
	
	public static String firstCharToLowerCase(String string){
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}
	
	public static String firstCharToUpperCase(String string){
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}
	
	public static Map<String, String> getDBTypeMap () {
		Map<String, String> tempMap = new HashMap<String, String>();
		
		tempMap.put("BIGINT", "long");
		tempMap.put("BINARY", "byte[]");
		tempMap.put("BIT", "Boolean");
		tempMap.put("BLOB", "byte[]");
		tempMap.put("CHAR", "String");
		tempMap.put("DATE", "DATE");
		tempMap.put("DECIMAL", "BigDecimal");
		tempMap.put("DOUBLE", "Double");
		tempMap.put("FLOAT", "Double");
		
		tempMap.put("INTEGER", "Integer");
		tempMap.put("JAVA_OBJECT", "Object");
		tempMap.put("LONGVARBINARY", "byte[]");
		tempMap.put("LONGVARCHAR", "String");
		tempMap.put("NUMERIC", "BigDecimal");
		tempMap.put("OTHER", "Object");
		tempMap.put("REAL", "Float");
		tempMap.put("SMALLINT", "Integer");
		
		tempMap.put("TIME", "Time");
		tempMap.put("TIMESTAMP", "Timestamp");
		tempMap.put("TINYINT", "byte[]");
		tempMap.put("VARCHAR", "String");

		return tempMap;
	}
	
	public static void main (String[] args) {
		
		String test = "register_date";
		String test2 = "UserAdmin";
		System.out.println(toCamelCase(test));
		
		System.out.println(toSlashedCase(toCamelCase(test2)));
	}
}
