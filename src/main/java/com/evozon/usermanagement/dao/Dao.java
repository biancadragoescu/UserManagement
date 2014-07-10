package com.evozon.usermanagement.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.evozon.usermanagement.data.User;

@Component
public class Dao implements IDao{
	List<User> listaUseri = new ArrayList<User>();
	
	public List<User> getListaUseri() {
		return listaUseri;
	}


	@Override
	public List<User> readUsersFromFile(String csvFile) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String[] userInfo = line.split(cvsSplitBy);
				User user = new User(userInfo[0], userInfo[1]);
				listaUseri.add(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaUseri;
	}

}
