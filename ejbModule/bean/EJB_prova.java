package bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJB_prova
 */
@Stateless
@LocalBean
public class EJB_prova implements EJB_provaLocal {

    /**
     * Default constructor. 
     */
    public EJB_prova() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ciao() {
		// TODO Auto-generated method stub
		System.out.println("ciao");
		
	}

}
