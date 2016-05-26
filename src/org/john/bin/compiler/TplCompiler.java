package org.john.bin.compiler;

import java.util.List;
import java.util.Map;

import org.john.bin.parser.ParserBase;
import org.john.bin.utils.PathManager;

/**
 * ģ����������
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
			// ��̬���ɽ�����ʵ������
			// ÿ�������Ǽ̳���ParserBaser�������ʵ������Ҫ��д�����parse��checkTemplate����
			ParserBase parser = (ParserBase) Class.forName( parsedConfigurationMap.get("pkgPrefix").replace("/", ".") + ".parser."+ strategy + "Parser").newInstance();
			
			// Ϊ������׼����Ӧ�����ݽṹ
			parser.setTemplate(tpl);
			parser.setModelMap(modelMap);
			parser.setConfigMap(parsedConfigurationMap);
			parser.setJdbcTypeMap(jdbcTypeMap);
			parser.setPathManager(new PathManager(parsedConfigurationMap));
			parser.setTplName(strategy);
			parser.setModelName(model);
			parser.setModelList(modelList);
			
			// ������������ 
			parser.parse();
			
			if (parser.checkTemplate()) {
				// ÿһ��parserӦ�ø�дcheckTemplate������ ��У���Ƿ������ģ����빤��
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
