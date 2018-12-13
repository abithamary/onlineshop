package com.niit.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;



//another annotation...
@Transactional
@Repository("userDAO") // will create instance of UserDAOImpl and the name will userDAO
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	// first - inject hibernate session.
	// @Autowire

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	//
	public boolean save(User user) {
		log.debug("Starting of the save method");
		// store in the database.
		try {
			user.setRole('C');

			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(user);
			log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(" error occured in update method " + e.getMessage());
			return false;
		}

	}

	public User get(String emailID) {
		log.debug("Starting of the get method");
		// it will fetch the record based on emailID and store in User class
		return sessionFactory.getCurrentSession().get(User.class, emailID);

	}

	public boolean delete(String emailID) {
		log.debug("Starting of the delete method");
		try {
			user = get(emailID);
			if (user == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of the delete method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(" error occured in delete method " + e.getMessage());
			return false;
		}

	}

	public List<User> list() {
		log.debug("Starting of the list method");
	return	sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) {
		//select * from usre where emailID = 'jaskaran1@gmail.com' and password = 'jas123'
		log.debug("Starting of the validate method");
		log.info(" user " + emailID + " trying to login");
	user = (User)	sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID", emailID))
		.add(Restrictions.eq("pwd", password)).uniqueResult();
	
	return user;
		
	}

}









