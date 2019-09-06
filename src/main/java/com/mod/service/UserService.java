package com.mod.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mod.model.User;


public interface UserService {
	 public void insertUser(User user) throws SQLException;

	public List<User> findByemail(String email);

	public List<User> getuserList();

}
