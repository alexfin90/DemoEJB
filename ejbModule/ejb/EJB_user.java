package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Session Bean implementation class EJB_user
 */
@Named
@Stateless
@LocalBean
public class EJB_user implements EJB_userLocal {

    /**
     * Default constructor. 
     */
    public EJB_user() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void prova() {
		// TODO Auto-generated method stub
		
		System.out.println("PROVA FUNZIONAMENTO");
		
	}

}
