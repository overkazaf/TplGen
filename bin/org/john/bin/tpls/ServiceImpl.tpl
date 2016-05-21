{{packages}}

{{imports}}

@Service 
public class {{Entity}}ServiceImpl implements {{Entity}}Service {
	@Autowired
	private {{Entity}}Mapper {{entity}}Mapper;

	@Override
	public boolean add{{Entity}} ({{Entity}} entity) throws Exception {
		return {{entity}}Mapper.add{{Entity}}(entity) != 0;
	};
	
	@Override
	public boolean addAll{{Entity}}s (List<{{Entity}}> entityList) throws Exception {
		return {{entity}}Mapper.addAll{{Entity}}s(entityList) == entityList.size();
	};
	
	@Override
	public boolean update{{Entity}} ({{Entity}} entity) throws Exception {
		return {{entity}}Mapper.update{{Entity}}(entity) != 0;
	};
	
	@Override
	public boolean remove{{Entity}}ById (String id) throws Exception {
		return {{entity}}Mapper.remove{{Entity}}ById(id) != 0;
	};
	
	@Override
	public boolean removeAll{{Entity}}s (List<String> idList) throws Exception {
		return {{entity}}Mapper.removeAll{{Entity}}s(idList) == idList.size();
	};
	
	@Override
	public {{Entity}} find{{Entity}}ById(String id) throws Exception {
		return {{entity}}Mapper.find{{Entity}}ById(id);
		
	};
	
	@Override
	public List<{{Entity}}> findAll{{Entity}}s() throws Exception {
		return {{entity}}Mapper.findAll{{Entity}}s();
	};
}
