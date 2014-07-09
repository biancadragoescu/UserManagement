package com.evozon.usermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService{

	@Override
	public boolean authenticateUser(String username, String password) {
		if (username.equals(ILoginService.username) && password.equals(ILoginService.password))
			return true;
		return false;
	}

}
