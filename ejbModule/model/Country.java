package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCountry;

	private String name;

	//bi-directional many-to-one association to Province
	@OneToMany(mappedBy="country")
	private List<Province> provinces;

	public Country() {
	}

	public int getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Province> getProvinces() {
		return this.provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public Province addProvince(Province province) {
		getProvinces().add(province);
		province.setCountry(this);

		return province;
	}

	public Province removeProvince(Province province) {
		getProvinces().remove(province);
		province.setCountry(null);

		return province;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCountry;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((provinces == null) ? 0 : provinces.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (idCountry != other.idCountry)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (provinces == null) {
			if (other.provinces != null)
				return false;
		} else if (!provinces.equals(other.provinces))
			return false;
		return true;
	}
	
	

}