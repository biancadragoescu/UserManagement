package com.evozon.usermanagement.dao;

import java.util.List;

import com.evozon.usermanagement.data.User;

public interface IDao {
	
	public List<User> readUsersFromFile(String csvFile);
	
}
