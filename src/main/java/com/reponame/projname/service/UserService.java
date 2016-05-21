package main.java.com.reponame.projname.service;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
public interface UserService {	public boolean addUser (User entity) throws Exception;	public boolean addAllUsers (List<User> entityList) throws Exception;		public boolean updateUser (User entity) throws Exception;		public boolean removeUserById (String id) throws Exception;	public boolean removeAllUsers (List<String> idList) throws Exception;		public User findUserById(String id) throws Exception;	public List<User> findAllUsers() throws Exception;}