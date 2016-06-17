package beanUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;


import model.User;

/**
 * Session Bean implementation class BeanLogin
 */
@Stateless
@LocalBean
public class BeanLogin {

	
	@Inject
	private beanDao.UserHome userHome;
	private User user;
    /**
     * Default constructor. 
     */
    public BeanLogin() {
        // TODO Auto-generated constructor stub
    }
    
    
    public boolean login(String username,String password){
    	 System.out.println("login Bean EJB");
    	 user = userHome.findByUsername(username);
    	 if(user == null) return false;
    	 else if (user.getPassword().compareTo(password)==0 ) return true;
    	 else return  false;
    }
}
