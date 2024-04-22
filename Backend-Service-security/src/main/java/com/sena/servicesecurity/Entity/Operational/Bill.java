package com.sena.servicesecurity.Entity.Operational;

import java.time.LocalDateTime;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bill")
public class Bill  extends ABaseEntity{

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
    private Client client;
	
	@Column(name="date", nullable = true)
	private LocalDateTime date;
	
	@Column(name="price", nullable = true)
	private int price;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
