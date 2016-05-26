{{packages}}

{{imports}}

public interface {{Entity}}Mapper {
    public int add{{Entity}} ({{Entity}} {{entity}});
	public int addAll{{Entity}}s (List<{{Entity}}> {{entity}}List);
	
	public int modify{{Entity}} ({{Entity}} {{entity}});
	public int modifyAll{{Entity}}s (List<{{Entity}}> {{entity}}List);
	
	public int remove{{Entity}}ById ({{PK}} {{entity}}Id);
	public int removeAll{{Entity}}s (List<{{PK}}> idList);
	
	public {{Entity}} query{{Entity}}ById({{PK}} {{entity}}Id);
	public List<{{Entity}}> queryAll{{Entity}}s();
	
}
