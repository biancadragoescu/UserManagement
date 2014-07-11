package com.evozon.usermanagement.service;

public interface ILoginService {
	
	public boolean authenticateUser(String username, String password);
	
}
