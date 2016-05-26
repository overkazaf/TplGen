package main.java.com.reponame.projname.mapper;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
public interface UserMapper {    public int addUser (User user);	public int addAllUsers (List<User> userList);		public int modifyUser (User user);	public int modifyAllUsers (List<User> userList);		public int removeUserById (Integer userId);	public int removeAllUsers (List<Integer> idList);		public User queryUserById(Integer userId);	public List<User> queryAllUsers();	}