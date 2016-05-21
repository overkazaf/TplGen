package main.java.com.reponame.projname.entity;

import java.util.*;

public class User {	
private String id;
private String username;
private Date registerDate;
private Integer age;
private Date visitDate;
private String password;
		
public String getId () {
  return this.id;
}

public String getUsername () {
  return this.username;
}

public Date getRegisterDate () {
  return this.registerDate;
}

public Integer getAge () {
  return this.age;
}

public Date getVisitDate () {
  return this.visitDate;
}

public String getPassword () {
  return this.password;
}
		
public void setId (String id) {
  this.id = id;
}

public void setUsername (String username) {
  this.username = username;
}

public void setRegisterDate (Date registerdate) {
  this.registerDate = registerdate;
}

public void setAge (Integer age) {
  this.age = age;
}

public void setVisitDate (Date visitdate) {
  this.visitDate = visitdate;
}

public void setPassword (String password) {
  this.password = password;
}
	}