package org.john.bin.parser;

import java.util.Map;

import org.john.bin.PathManager;

public class TplCompiler {
	private static Map<String, String> parsedConfigurationMap;

	public TplCompiler(Map<String, String> map) {
		parsedConfigurationMap = map;
	}

	public static String genPackage(String model, String tplname, Map<String, String> modelMap) {
		String pkgName = model.toLowerCase();
		String tplName = tplname.toLowerCase();
		String prefix = parsedConfigurationMap.get("targetPath");
		String target = prefix.replace("/", ".") + "." + tplName + "." + pkgName;
		return "package " + target;
	}

	public static String genImport(String model, String tplname, Map<String, String> modelMap) {

		return "";
	}

	public static String compile(String model, Map<String, String> modelMap, String tplName, String tpl) {
		
		System.out.println("\n");
		System.out.println("\n===========================================================");
		System.out.println("\nCompile model " + model);
		System.out.println("\nCompile model tpl:" + tplName);
		System.out.println("\n===========================================================");
		System.out.println("\n");
		
		return compileStretagy(tplName, model, modelMap, tpl);
	}
	
	
	public static String compileStretagy (String strategy, String model, Map<String, String> modelMap, String tpl) {
		String compiledTpl = "";
		try {
			ParserBase parser = (ParserBase) Class.forName("org.john.bin.parser."+ strategy + "Parser").newInstance();
			
			parser.setTemplate(tpl);
			parser.setModelMap(modelMap);
			parser.setConfigMap(parsedConfigurationMap);
			parser.setPathManager(new PathManager(parsedConfigurationMap));
			parser.setTplName(strategy);
			parser.setModelName(model);
			parser.parse();
			
			
			if (parser.checkTemplate()) {
				compiledTpl = parser.getParsedTemplate();
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compiledTpl;
	}
}
