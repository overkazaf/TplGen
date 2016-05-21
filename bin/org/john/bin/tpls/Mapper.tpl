{{packages}}

{{imports}}

public interface {{Entity}}Mapper {
    public boolean add{{Entity}} ({{Entity}} entity);
	public boolean addAll{{Entity}}s (List<{{Entity}}> entityList);
	
	public boolean update{{Entity}} ({{Entity}} entity);
	
	public boolean remove{{Entity}}ById (String id);
	public boolean removeAll{{Entity}}s (List<String> idList);
	
	public {{Entity}} find{{Entity}}ById(String id);
	public List<{{Entity}}> findAll{{Entity}}s();
}
