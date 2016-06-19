package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the province database table.
 * 
 */
@Entity
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idprovince;

	private String name;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="iidcountry")
	private Country country;

	public Province() {
	}

	public int getIdprovince() {
		return this.idprovince;
	}

	public void setIdprovince(int idprovince) {
		this.idprovince = idprovince;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}