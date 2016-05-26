package org.john.bin.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class MetaDataFetcher {
	private final static String DB_NAME = "test";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "";
	
	private DatabaseMetaData dbMetaData = null;  
    private Connection con = null;  
    
    public MetaDataFetcher() {
        this.getDatabaseMetaData(DB_NAME, DB_USER, DB_PASS);  
    }
    
    public MetaDataFetcher(String dbName, String dbUser, String dbPass) {
        this.getDatabaseMetaData(dbName, dbUser, dbPass);  
    }
    
    
    public synchronized Map<String, Map<String, String>> mapDBTable2Entity(String schemaName, String tableName) {  
    	Map<String, Map<String, String>> entityMap = new HashMap<String, Map<String, String>>();
        try{     
            ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName, "%");              
            while (rs.next()){  
                    String tableCat = rs.getString("TABLE_CAT");//表目录（可能为空）                  
                    String tableSchemaName = rs.getString("TABLE_SCHEM");//表的架构（可能为空）     
                    String tableName_ = rs.getString("TABLE_NAME");//表名  
                    String columnName = rs.getString("COLUMN_NAME");//列名  
                    int dataType = rs.getInt("DATA_TYPE"); //对应的java.sql.Types类型     
                    String dataTypeName = rs.getString("TYPE_NAME");//java.sql.Types类型   名称  
                    int columnSize = rs.getInt("COLUMN_SIZE");//列大小  
                    int decimalDigits = rs.getInt("DECIMAL_DIGITS");//小数位数  
                    int numPrecRadix = rs.getInt("NUM_PREC_RADIX");//基数（通常是10或2）  
                    int nullAble = rs.getInt("NULLABLE");//是否允许为null  
                    String remarks = rs.getString("REMARKS");//列描述  
                    String columnDef = rs.getString("COLUMN_DEF");//默认值  
                    int sqlDataType = rs.getInt("SQL_DATA_TYPE");//sql数据类型  
                    int sqlDatetimeSub = rs.getInt("SQL_DATETIME_SUB");   //SQL日期时间分?  
                    int charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");   //char类型的列中的最大字节数  
                    int ordinalPosition = rs.getInt("ORDINAL_POSITION");  //表中列的索引（从1开始）  
                    
                    Map<String, String> currentEntityMap = entityMap.get(tableName_);
                    if (currentEntityMap == null) {
                    	currentEntityMap = new HashMap<String, String>();
                    }
                    
                    currentEntityMap.put(columnName, dataTypeName);
                    
                    // 最后会生成entity map, 存放的是实体类表的列字段名及列字段的jdbcType类型
                    entityMap.put(tableName_, currentEntityMap);
                }     
            } catch (SQLException e){  
                e.printStackTrace();     
            }
        
        	return entityMap;
    }
    
    public synchronized Map<String, Map<String, String>> mapDBTable2Entities (String schemaName, List<String> tableNames) {
    	Map<String, Map<String, String>> entityMap = new HashMap<String, Map<String, String>>();
        
    	for (String tableName : tableNames) {
    		try{     
                ResultSet rs = dbMetaData.getColumns(null, schemaName, tableName, "%");              
                while (rs.next()){  
                    String tableName_ = rs.getString("TABLE_NAME");//表名  
                    String columnName = rs.getString("COLUMN_NAME");//列名  
                    String dataTypeName = rs.getString("TYPE_NAME");//java.sql.Types类型   名称  
                    
                    Map<String, String> currentEntityMap = entityMap.get(tableName_);
                    if (currentEntityMap == null) {
                    	currentEntityMap = new HashMap<String, String>();
                    }
                    
                    currentEntityMap.put(columnName, dataTypeName);
                    
                    // 最后会生成entity map, 存放的是实体类表的列字段名及列字段的jdbcType类型
                    entityMap.put(tableName_, currentEntityMap);
                }     
            } catch (SQLException e){  
                e.printStackTrace();     
            }
    	}
        
        return entityMap;
    }
  
  
    private void getDatabaseMetaData(String dbName, String dbUser, String dbPass) {  
        try {  
            if (dbMetaData == null) {  
                Class.forName("com.mysql.jdbc.Driver");  
                String url = "jdbc:mysql://localhost:3306/" + dbName;  
                con = DriverManager.getConnection(url, dbUser, dbPass);  
                dbMetaData = con.getMetaData();  
            }  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
    
	public static void main (String[] args) {
		MetaDataFetcher app = new MetaDataFetcher();
		String schemaName = "test";
		String tableName = "user";
		
		Map<String, Map<String, String>> entityMap = app.mapDBTable2Entity(schemaName, tableName);
		
		Set<String> entityNames = entityMap.keySet();
		for (String entityName : entityNames) {
			Map<String, String> currentEntityMap = entityMap.get(entityName);
			Set<String> currentEntityKeys = currentEntityMap.keySet();
			System.out.println("Entity =======  " + entityName);
			for (String key : currentEntityKeys) {
				System.out.println("key:" + key + " , keyType:" + currentEntityMap.get(key));
			}
			
			System.out.println("=============================================================");
		}
	}
}
