package com.evozon.usermanagement.service;

public interface ILoginService {
	public final static String username = "AAA";
	public final static String password = "aaa";
	
	public boolean authenticateUser(String username, String password);
}
