package main.java.com.reponame.projname.entity;

import java.util.*;

public class Role {	
private Integer id;
private String modifiedBy;
private String roleName;
private Integer previligeLevel;
private String createBy;
		
public Integer getId () {
  return this.id;
}

public String getModifiedBy () {
  return this.modifiedBy;
}

public String getRoleName () {
  return this.roleName;
}

public Integer getPreviligeLevel () {
  return this.previligeLevel;
}

public String getCreateBy () {
  return this.createBy;
}
		
public void setId (Integer id) {
  this.id = id;
}

public void setModifiedBy (String modifiedby) {
  this.modifiedBy = modifiedby;
}

public void setRoleName (String rolename) {
  this.roleName = rolename;
}

public void setPreviligeLevel (Integer previligelevel) {
  this.previligeLevel = previligelevel;
}

public void setCreateBy (String createby) {
  this.createBy = createby;
}
	}