package main.java.com.reponame.projname.service.impl;

import java.util.*;
import main.java.com.reponame.projname.entity.RoleGroup;
import main.java.com.reponame.projname.mapper.RoleGroupMapper;
import main.java.com.reponame.projname.service.RoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service public class RoleGroupServiceImpl implements RoleGroupService {	@Autowired	private RoleGroupMapper roleGroupMapper;	@Override	public boolean addRoleGroup (RoleGroup roleGroup) throws Exception {		return roleGroupMapper.addRoleGroup(roleGroup) != 0;	}		@Override	public boolean addAllRoleGroups (List<RoleGroup> roleGroupList) throws Exception {		return roleGroupMapper.addAllRoleGroups(roleGroupList) == roleGroupList.size();	}		@Override	public boolean modifyRoleGroup (RoleGroup roleGroup) throws Exception {		return roleGroupMapper.modifyRoleGroup(roleGroup) != 0;	}		@Override	public boolean modifyAllRoleGroups (List<RoleGroup> roleGroupList) throws Exception {		return roleGroupMapper.modifyAllRoleGroups(roleGroupList) == roleGroupList.size();	}		@Override	public boolean removeRoleGroupById (Integer roleGroupId) throws Exception {		return roleGroupMapper.removeRoleGroupById(roleGroupId) != 0;	}		@Override	public boolean removeAllRoleGroups (List<Integer> idList) throws Exception {		return roleGroupMapper.removeAllRoleGroups(idList) == idList.size();	}	@Override	public RoleGroup queryRoleGroupById(Integer roleGroupId) throws Exception {		return roleGroupMapper.queryRoleGroupById(roleGroupId);	}		@Override	public List<RoleGroup> queryAllRoleGroups() throws Exception {		return roleGroupMapper.queryAllRoleGroups();	}}