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
		return userDao.insert(user);

	}
	
	public List<User> find(){
		return userDao.finduser();
		
	}
}
