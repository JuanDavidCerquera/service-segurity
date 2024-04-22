package com.sena.servicesecurity.Entity.Operational;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product extends ABaseEntity{
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="price",nullable=false)
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	
}
