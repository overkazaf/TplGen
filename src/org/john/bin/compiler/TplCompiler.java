package org.john.bin.compiler;

import java.util.List;
import java.util.Map;

import org.john.bin.parser.ParserBase;
import org.john.bin.utils.PathManager;

/**
 * 模板代码编译器
 * @author jonong
 *
 */
public class TplCompiler {
	private static Map<String, String> parsedConfigurationMap;

	public TplCompiler(Map<String, String> map) {
		parsedConfigurationMap = map;
	}

	public String compile(String model, Map<String, String> modelMap, String tplName, String tpl, List<String> list, Map<String, String> jdbcTypeMap) {
		
		System.out.println("\n");
		System.out.println("\n===========================================================");
		System.out.println("\nCompile model " + model);
		System.out.println("\nCompile model tpl:" + tplName);
		System.out.println("\n===========================================================");
		System.out.println("\n");
		
		return compileStretagy(tplName, model, modelMap, tpl, list, jdbcTypeMap);
	}
	
	
	public String compileStretagy (String strategy, String model, Map<String, String> modelMap, String tpl, List<String> modelList, Map<String,String> jdbcTypeMap) {
		String compiledTpl = "";
		try {
			// 动态生成解析器实例对象
			// 每个对象都是继承自ParserBaser类的子类实例，需要重写基类的parse和checkTemplate方法
			ParserBase parser = (ParserBase) Class.forName( parsedConfigurationMap.get("pkgPrefix").replace("/", ".") + ".parser."+ strategy + "Parser").newInstance();
			
			// 为解析器准备相应的数据结构
			parser.setTemplate(tpl);
			parser.setModelMap(modelMap);
			parser.setConfigMap(parsedConfigurationMap);
			parser.setJdbcTypeMap(jdbcTypeMap);
			parser.setPathManager(new PathManager(parsedConfigurationMap));
			parser.setTplName(strategy);
			parser.setModelName(model);
			parser.setModelList(modelList);
			
			// 启动解析任务 
			parser.parse();
			
			if (parser.checkTemplate()) {
				// 每一个parser应该复写checkTemplate方法， 以校验是否完成了模板编译工作
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
