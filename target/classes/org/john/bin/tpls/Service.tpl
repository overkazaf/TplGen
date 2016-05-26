{{packages}}

{{imports}}

public interface {{Entity}}Service {
	public boolean add{{Entity}} ({{Entity}} {{entity}}) throws Exception;
	public boolean addAll{{Entity}}s (List<{{Entity}}> {{entity}}List) throws Exception;
	
	public boolean modify{{Entity}} ({{Entity}} {{entity}}) throws Exception;
	public boolean modifyAll{{Entity}}s (List<{{Entity}}> {{entity}}List) throws Exception;
	
	public boolean remove{{Entity}}ById ({{PK}} {{entity}}Id) throws Exception;
	public boolean removeAll{{Entity}}s (List<{{PK}}> idList) throws Exception;
	
	public {{Entity}} query{{Entity}}ById ({{PK}} {{entity}}Id) throws Exception;
	public List<{{Entity}}> queryAll{{Entity}}s() throws Exception;
	
}