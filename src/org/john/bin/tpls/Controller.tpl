{{packages}}

{{imports}}

@Controller
@RequestMapping("/{{entity}}")
public class {{Entity}}Controller {  
    
    @Resource
    private {{Entity}}Service {{entity}}Service;
    
    @Autowired  
    public {{Entity}}Controller() {  
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";  
    }  
      
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add{{Entity}}(HttpServletRequest request, {{RequestParams}}) {  
        return "add{{Entity}}";  
    }
    
    @RequestMapping(value = "/addAll", method = RequestMethod.POST)
    public String addAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
        return "addAll{{Entity}}s";  
    }
    
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String remove{{Entity}}ById(HttpServletRequest request, {{RequestParams}}) {  
        return "remove{{Entity}}";  
    }
    
    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public String removeAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
        return "removeAll{{Entity}}s";  
    }
      
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public String modify{{Entity}}(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "modify{{Entity}}";
    }
    
    @RequestMapping(value = "/modifyAll", method = RequestMethod.PUT)
    public String modifyAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "modifyAll{{Entity}}s";
    }  
    
    
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query{{Entity}}ById(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "query{{Entity}}ById";
    }
    
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public String queryAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "queryAll{{Entity}}s";
    }
}  