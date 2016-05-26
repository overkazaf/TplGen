package main.java.com.reponame.projname.service;

import java.util.*;
import main.java.com.reponame.projname.entity.RoleGroup;
public interface RoleGroupService {	public boolean addRoleGroup (RoleGroup roleGroup) throws Exception;	public boolean addAllRoleGroups (List<RoleGroup> roleGroupList) throws Exception;		public boolean modifyRoleGroup (RoleGroup roleGroup) throws Exception;	public boolean modifyAllRoleGroups (List<RoleGroup> roleGroupList) throws Exception;		public boolean removeRoleGroupById (Integer roleGroupId) throws Exception;	public boolean removeAllRoleGroups (List<Integer> idList) throws Exception;		public RoleGroup queryRoleGroupById (Integer roleGroupId) throws Exception;	public List<RoleGroup> queryAllRoleGroups() throws Exception;	}