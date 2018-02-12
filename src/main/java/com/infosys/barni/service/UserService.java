package com.infosys.barni.service;

import java.util.List;

import com.infosys.barni.entity.User;

public interface UserService {
	public List<User> getAllUser();
	public User getUserById(long id);
	public User saveUser(User user);
	public void removeUser(User user);
}