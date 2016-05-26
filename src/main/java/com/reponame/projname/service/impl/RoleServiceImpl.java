package main.java.com.reponame.projname.service.impl;

import java.util.*;
import main.java.com.reponame.projname.entity.Role;
import main.java.com.reponame.projname.mapper.RoleMapper;
import main.java.com.reponame.projname.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service public class RoleServiceImpl implements RoleService {	@Autowired	private RoleMapper roleMapper;	@Override	public boolean addRole (Role role) throws Exception {		return roleMapper.addRole(role) != 0;	}		@Override	public boolean addAllRoles (List<Role> roleList) throws Exception {		return roleMapper.addAllRoles(roleList) == roleList.size();	}		@Override	public boolean modifyRole (Role role) throws Exception {		return roleMapper.modifyRole(role) != 0;	}		@Override	public boolean modifyAllRoles (List<Role> roleList) throws Exception {		return roleMapper.modifyAllRoles(roleList) == roleList.size();	}		@Override	public boolean removeRoleById (Integer roleId) throws Exception {		return roleMapper.removeRoleById(roleId) != 0;	}		@Override	public boolean removeAllRoles (List<Integer> idList) throws Exception {		return roleMapper.removeAllRoles(idList) == idList.size();	}	@Override	public Role queryRoleById(Integer roleId) throws Exception {		return roleMapper.queryRoleById(roleId);	}		@Override	public List<Role> queryAllRoles() throws Exception {		return roleMapper.queryAllRoles();	}}