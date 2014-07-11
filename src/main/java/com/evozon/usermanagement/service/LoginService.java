package com.evozon.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evozon.usermanagement.dao.IDao;
import com.evozon.usermanagement.data.User;

@Service
public class LoginService implements ILoginService {
	
	@Autowired
	IDao dao;
	
	@Override
	public boolean authenticateUser(String username, String password) {
		List<User> listaUseri = new ArrayList<User>();
		listaUseri = dao.readUsersFromFile("C:\\Cristina\\UserManagement\\fisier.csv");
		
		for(User user:listaUseri){
			if (user.getUserName().equals(username) && user.getPassword().equals(password))	{
				return true;		
			}
		}
		return false;
	}

}
