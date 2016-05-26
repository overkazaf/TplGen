package main.java.com.reponame.projname.mapper;

import java.util.*;
import main.java.com.reponame.projname.entity.Role;
public interface RoleMapper {    public int addRole (Role role);	public int addAllRoles (List<Role> roleList);		public int modifyRole (Role role);	public int modifyAllRoles (List<Role> roleList);		public int removeRoleById (Integer roleId);	public int removeAllRoles (List<Integer> idList);		public Role queryRoleById(Integer roleId);	public List<Role> queryAllRoles();	}