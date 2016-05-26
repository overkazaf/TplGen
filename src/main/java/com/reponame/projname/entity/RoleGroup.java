package main.java.com.reponame.projname.entity;

import java.util.*;

public class RoleGroup {	
private Integer id;
private String roleGroupName;
private String modifiedBy;
private String createBy;
		
public Integer getId () {
  return this.id;
}

public String getRoleGroupName () {
  return this.roleGroupName;
}

public String getModifiedBy () {
  return this.modifiedBy;
}

public String getCreateBy () {
  return this.createBy;
}
		
public void setId (Integer id) {
  this.id = id;
}

public void setRoleGroupName (String rolegroupname) {
  this.roleGroupName = rolegroupname;
}

public void setModifiedBy (String modifiedby) {
  this.modifiedBy = modifiedby;
}

public void setCreateBy (String createby) {
  this.createBy = createby;
}
	}