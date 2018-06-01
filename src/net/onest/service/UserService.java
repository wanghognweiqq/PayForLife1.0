package net.onest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.onest.bean.User;
import net.onest.dao.UserDao;

@Service
@Transactional
public class UserService {
@Autowired
private UserDao userDao;
	public User findUser(String username,String password){
		User user=(User) userDao.select(username, password);
		
		return user;
	}
	
	public boolean register(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		boolean result = userDao.selectregistered(username);
		if (result == true) {
			return userDao.insert(user);
		} else {
			return false;
		}
	}
	
	public List<User> find(){
		return userDao.finduser();
		
	}
}
