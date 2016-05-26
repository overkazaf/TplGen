package main.java.com.reponame.projname.entity;

import java.util.*;

public class User {	
private Integer id;
private String phone;
private Integer age;
private String name;
private byte[] gender;
private String password;
		
public Integer getId () {
  return this.id;
}

public String getPhone () {
  return this.phone;
}

public Integer getAge () {
  return this.age;
}

public String getName () {
  return this.name;
}

public byte[] getGender () {
  return this.gender;
}

public String getPassword () {
  return this.password;
}
		
public void setId (Integer id) {
  this.id = id;
}

public void setPhone (String phone) {
  this.phone = phone;
}

public void setAge (Integer age) {
  this.age = age;
}

public void setName (String name) {
  this.name = name;
}

public void setGender (byte[] gender) {
  this.gender = gender;
}

public void setPassword (String password) {
  this.password = password;
}
	}