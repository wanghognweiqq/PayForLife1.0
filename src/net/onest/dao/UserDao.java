package net.onest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.onest.bean.User;
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	public User select(String username,String password){
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.createQuery("from User where user_username=?and user_passwd=?").setParameter(0, username).setParameter(1, password).uniqueResult();				
		return user;
	}
	
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}
	
	public List<User> finduser(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		List<User> list=query.list();
		return list;
	}
	
	
	
	public User getSome(String username) {
		Session session = sessionFactory.getCurrentSession();
		String sql="from User u where u.username = ?";
		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery(sql);
		query.setParameter(0, username);
		List<User> list = query.list();
		User user = null;
		for(User user1 : list) {
			user = user1;
		}
		return user;
	}
}
