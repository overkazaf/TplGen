package main.java.com.reponame.projname.service;

import java.util.*;
import main.java.com.reponame.projname.entity.Role;
public interface RoleService {	public boolean addRole (Role role) throws Exception;	public boolean addAllRoles (List<Role> roleList) throws Exception;		public boolean modifyRole (Role role) throws Exception;	public boolean modifyAllRoles (List<Role> roleList) throws Exception;		public boolean removeRoleById (Integer roleId) throws Exception;	public boolean removeAllRoles (List<Integer> idList) throws Exception;		public Role queryRoleById (Integer roleId) throws Exception;	public List<Role> queryAllRoles() throws Exception;	}