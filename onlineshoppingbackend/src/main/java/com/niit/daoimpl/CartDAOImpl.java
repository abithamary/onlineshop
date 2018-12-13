package com.niit.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

//another annotation...
@Transactional
@Repository("cartDAO") // will create instance of CartDAOImpl and the name will cartDAO
public class CartDAOImpl implements CartDAO {

	// first - inject hibernate session.
	// @Autowire

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;
	
	Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

	//
	public boolean save(Cart cart) {
		// store in the database.
		try {
			cart.setId();
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Cart get(String id) {
		// it will fetch the record based on id and store in Cart class
		return sessionFactory.getCurrentSession().get(Cart.class, id);

	}

	public boolean delete(String id) {
		try {
			cart = get(id);
			if (cart == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(cart);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Cart> list(String emailID) {
		//select * from cart where emialID = ?
	return	sessionFactory.getCurrentSession().createCriteria(Cart.class)
			.add(Restrictions.eq("emailID", emailID)).list();
		
	}

	public boolean update(String emailID) {
		log.debug("Starting of the method update");
		log.debug("Goiig to place order of "  + emailID);
		String hql = "update Cart set status = 'O' where emailid='" +
				emailID +"'";
		
		log.info("The given query : " + hql);
		
		try
		{
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		log.debug("Ending of the method update");
		return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}



}









