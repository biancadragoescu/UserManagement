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
		BufferedReader bufferedReader = null;
		String line = "";
		String csvSplitBy = ",";
	 
		try {
			bufferedReader = new BufferedReader(new FileReader(csvFile));
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.equals("")){
					String[] userInfo = line.split(csvSplitBy);
					User user = new User(userInfo[0], userInfo[1]);
					listaUseri.add(user);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaUseri;
	}

}
