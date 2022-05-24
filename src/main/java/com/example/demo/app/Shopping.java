package com.example.demo.app;

import java.util.Date;

public class Shopping {
	private int id;
	private String name;
	private Integer count;
	private Integer price;
	private Integer priceadd;
	private String location;
	private Date date;
	
	public Shopping() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPriceadd() {
		return priceadd;
	}

	public void setPriceadd(Integer priceadd) {
		this.priceadd = priceadd;
	}
	

}
