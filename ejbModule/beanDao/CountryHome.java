package beanDao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import model.Country;

/**
 * Session Bean implementation class CountryHome
 */
@Stateless
@LocalBean
public class CountryHome {

    /**
     * Default constructor. 
     */
	
	private static final Log log = LogFactory.getLog(CountryHome.class);
	
    @PersistenceContext
	private EntityManager entityManager ;
	
	public void persist(Country transientInstance) {
		log.debug("persisting Country instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			System.out.println("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Country persistentInstance) {
		log.debug("removing Country instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Country merge(Country detachedInstance) {
		log.debug("merging Country instance");
		try {
			Country result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Country findById(Integer id) {
		log.debug("getting Country instance with id: " + id);
		try {
			Country instance = entityManager.find(Country.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	

}
