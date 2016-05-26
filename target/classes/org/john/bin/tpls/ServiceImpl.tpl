{{packages}}

{{imports}}

@Service 
public class {{Entity}}ServiceImpl implements {{Entity}}Service {
	@Autowired
	private {{Entity}}Mapper {{entity}}Mapper;

	@Override
	public boolean add{{Entity}} ({{Entity}} {{entity}}) throws Exception {
		return {{entity}}Mapper.add{{Entity}}({{entity}}) != 0;
	}
	
	@Override
	public boolean addAll{{Entity}}s (List<{{Entity}}> {{entity}}List) throws Exception {
		return {{entity}}Mapper.addAll{{Entity}}s({{entity}}List) == {{entity}}List.size();
	}
	
	@Override
	public boolean modify{{Entity}} ({{Entity}} {{entity}}) throws Exception {
		return {{entity}}Mapper.modify{{Entity}}({{entity}}) != 0;
	}
	
	@Override
	public boolean modifyAll{{Entity}}s (List<{{Entity}}> {{entity}}List) throws Exception {
		return {{entity}}Mapper.modifyAll{{Entity}}s({{entity}}List) == {{entity}}List.size();
	}
	
	@Override
	public boolean remove{{Entity}}ById ({{PK}} {{entity}}Id) throws Exception {
		return {{entity}}Mapper.remove{{Entity}}ById({{entity}}Id) != 0;
	}
	
	@Override
	public boolean removeAll{{Entity}}s (List<{{PK}}> idList) throws Exception {
		return {{entity}}Mapper.removeAll{{Entity}}s(idList) == idList.size();
	}

	@Override
	public {{Entity}} query{{Entity}}ById({{PK}} {{entity}}Id) throws Exception {
		return {{entity}}Mapper.query{{Entity}}ById({{entity}}Id);
	}
	
	@Override
	public List<{{Entity}}> queryAll{{Entity}}s() throws Exception {
		return {{entity}}Mapper.queryAll{{Entity}}s();
	}
}
