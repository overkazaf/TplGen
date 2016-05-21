{{packages}}

{{imports}}

public interface {{Entity}}Service {
	public boolean add{{Entity}} ({{Entity}} entity) throws Exception;
	public boolean addAll{{Entity}}s (List<{{Entity}}> entityList) throws Exception;
	
	public boolean update{{Entity}} ({{Entity}} entity) throws Exception;
	
	public boolean remove{{Entity}}ById (String id) throws Exception;
	public boolean removeAll{{Entity}}s (List<String> idList) throws Exception;
	
	public {{Entity}} find{{Entity}}ById(String id) throws Exception;
	public List<{{Entity}}> findAll{{Entity}}s() throws Exception;
}