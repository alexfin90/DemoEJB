package beanDao;

import java.util.List;

// default package
// Generated Jun 14, 2016 3:31:40 PM by Hibernate Tools 5.1.0.Alpha1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import model.*;

/**
 * Home object for domain model class Item.
 * @see .Item
 * @author Hibernate Tools
 */
@Stateless
public class ItemHome {

	private static final Log log = LogFactory.getLog(ItemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Item transientInstance) {
		log.debug("persisting Item instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Item persistentInstance) {
		log.debug("removing Item instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Item merge(Item detachedInstance) {
		log.debug("merging Item instance");
		try {
			Item result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Item findById(Integer id) {
		log.debug("getting Item instance with id: " + id);
		try {
			Item instance = entityManager.find(Item.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Item> findAlItems(){
		log.debug("getting all Items ");
		try{
			return entityManager.createQuery("select i from Item i ",Item.class)
					.getResultList();
		}catch(javax.persistence.NoResultException e){
			return null;
		}
	}

	

}
