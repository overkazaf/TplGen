package main.java.com.reponame.projname.service.impl;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
import main.java.com.reponame.projname.mapper.UserMapper;
import main.java.com.reponame.projname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service public class UserServiceImpl implements UserService {	@Autowired	private UserMapper userMapper;	@Override	public boolean addUser (User user) throws Exception {		return userMapper.addUser(user) != 0;	}		@Override	public boolean addAllUsers (List<User> userList) throws Exception {		return userMapper.addAllUsers(userList) == userList.size();	}		@Override	public boolean modifyUser (User user) throws Exception {		return userMapper.modifyUser(user) != 0;	}		@Override	public boolean modifyAllUsers (List<User> userList) throws Exception {		return userMapper.modifyAllUsers(userList) == userList.size();	}		@Override	public boolean removeUserById (Integer userId) throws Exception {		return userMapper.removeUserById(userId) != 0;	}		@Override	public boolean removeAllUsers (List<Integer> idList) throws Exception {		return userMapper.removeAllUsers(idList) == idList.size();	}	@Override	public User queryUserById(Integer userId) throws Exception {		return userMapper.queryUserById(userId);	}		@Override	public List<User> queryAllUsers() throws Exception {		return userMapper.queryAllUsers();	}}