package main.java.com.reponame.projname.service;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
public interface UserService {	public boolean addUser (User user) throws Exception;	public boolean addAllUsers (List<User> userList) throws Exception;		public boolean modifyUser (User user) throws Exception;	public boolean modifyAllUsers (List<User> userList) throws Exception;		public boolean removeUserById (Integer userId) throws Exception;	public boolean removeAllUsers (List<Integer> idList) throws Exception;		public User queryUserById (Integer userId) throws Exception;	public List<User> queryAllUsers() throws Exception;	}