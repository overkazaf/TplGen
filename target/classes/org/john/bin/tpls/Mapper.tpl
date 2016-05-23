{{packages}}

{{imports}}

public interface {{Entity}}Mapper {
    public int add{{Entity}} ({{Entity}} entity);
	public int addAll{{Entity}}s (List<{{Entity}}> entityList);
	
	public int update{{Entity}} ({{Entity}} entity);
	public int updateAll{{Entity}}s (List<{{Entity}}> entityList);
	
	public int remove{{Entity}}ById (String id);
	public int removeAll{{Entity}}s (List<String> idList);
	
	public {{Entity}} find{{Entity}}ById(String id);
	public List<{{Entity}}> findAll{{Entity}}s();
}
