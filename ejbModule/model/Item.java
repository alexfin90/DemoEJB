package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idItem;

	private int available;

	private String desciption;

	private String name;

	private float price;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="item")
	private List<Order> orders;

	public Item() {
	}
	
	public Item(Integer id , String desc, String name, float price){
		this.idItem=id;
		this.desciption=desc;
		this.name=name;
		this.price=price;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getAvailable() {
		return this.available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setItem(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setItem(null);

		return order;
	}

}