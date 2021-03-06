package beanDao;

import javax.ejb.LocalBean;

// default package
// Generated Jun 14, 2016 3:31:40 PM by Hibernate Tools 5.1.0.Alpha1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import model.*;

/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */

@LocalBean
@Stateless
public class UserHome {

	
	
	private static final Log log = LogFactory.getLog(UserHome.class);
	
    @PersistenceContext
	private EntityManager entityManager ;
	
	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		System.out.println("persist");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			System.out.println("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public User findByUsername(String username) {
		log.debug("getting User instance with username: " + username);
		try{
			return    entityManager.createQuery("select u from User u where u.username = :userName",User.class)
					.setParameter("userName", username)
					.getSingleResult();
		}
		catch(javax.persistence.NoResultException e){

			return null;
		}
	}
}
