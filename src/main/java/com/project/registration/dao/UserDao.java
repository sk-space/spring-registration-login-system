package com.project.registration.dao;

import com.project.registration.entity.User;

public interface UserDao {

	public void addUser(User u);

	public boolean isExit(String username);
	
	public User loginUser(String username, String password);
	
}
