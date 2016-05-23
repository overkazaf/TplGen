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
      
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update{{Entity}}(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "update{{Entity}}";
    }
    
    @RequestMapping(value = "/updateAll", method = RequestMethod.PUT)
    public String updateAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "updateAll{{Entity}}s";
    }  
    
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find{{Entity}}ById(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "find{{Entity}}ById";
    }
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAll{{Entity}}s(HttpServletRequest request, {{RequestParams}}) {  
    	
    	return "findAll{{Entity}}s";
    }
}  