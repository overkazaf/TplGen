package main.java.com.reponame.projname.service.impl;

import java.util.*;
import main.java.com.reponame.projname.entity.User;
import main.java.com.reponame.projname.mapper.UserMapper;
import main.java.com.reponame.projname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service public class UserServiceImpl implements UserService {	@Autowired	private UserMapper userMapper;	@Override	public boolean addUser (User entity) throws Exception {		return userMapper.addUser(entity) != 0;	};		@Override	public boolean addAllUsers (List<User> entityList) throws Exception {		return userMapper.addAllUsers(entityList) == entityList.size();	};		@Override	public boolean updateUser (User entity) throws Exception {		return userMapper.updateUser(entity) != 0;	};		@Override	public boolean updateAllUsers (List<User> entityList) throws Exception {		return userMapper.updateAllUsers(entityList) == entityList.size();	};		@Override	public boolean removeUserById (String id) throws Exception {		return userMapper.removeUserById(id) != 0;	};		@Override	public boolean removeAllUsers (List<String> idList) throws Exception {		return userMapper.removeAllUsers(idList) == idList.size();	};		@Override	public User findUserById(String id) throws Exception {		return userMapper.findUserById(id);			};		@Override	public List<User> findAllUsers() throws Exception {		return userMapper.findAllUsers();	};}