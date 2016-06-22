package beanUtils;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Country;
import model.Province;
import model.User;

/**
 * Session Bean implementation class BeanProvince
 */
@Singleton
@Startup
@LocalBean
public class BeanStartup {

	List<Country> coutries;
	List<Province> provinces;
	
	@PersistenceContext
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public BeanStartup() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void init(){
    	System.out.println("Init Countries and Service-EJB Startup Singleton");
    	coutries = entityManager.createQuery("select c from Country c",Country.class)
		.getResultList();
    	System.out.println(coutries.get(0).getProvinces().get(0).getName());
    	provinces = entityManager.createQuery("select p from Province p", Province.class)
    	.getResultList();
    }
    
    public List<Country> getCoutries() {
		return coutries;
	}
    
    public List<Province> getProvinces() {
		return provinces;
	}

}
