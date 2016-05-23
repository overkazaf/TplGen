package main.java.com.reponame.projname.mapper;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
public interface UserMapper {    public boolean addUser (User entity);	public boolean addAllUsers (List<User> entityList);		public boolean updateUser (User entity);	public boolean updateAllUsers (List<User> entityList);		public boolean removeUserById (String id);	public boolean removeAllUsers (List<String> idList);		public User findUserById(String id);	public List<User> findAllUsers();}