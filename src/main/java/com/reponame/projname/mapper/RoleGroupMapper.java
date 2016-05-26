package main.java.com.reponame.projname.mapper;

import java.util.*;
import main.java.com.reponame.projname.entity.RoleGroup;
public interface RoleGroupMapper {    public int addRoleGroup (RoleGroup roleGroup);	public int addAllRoleGroups (List<RoleGroup> roleGroupList);		public int modifyRoleGroup (RoleGroup roleGroup);	public int modifyAllRoleGroups (List<RoleGroup> roleGroupList);		public int removeRoleGroupById (Integer roleGroupId);	public int removeAllRoleGroups (List<Integer> idList);		public RoleGroup queryRoleGroupById(Integer roleGroupId);	public List<RoleGroup> queryAllRoleGroups();	}