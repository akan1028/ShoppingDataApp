package com.example.demo.app.shopping;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ShoppingForm {
	
	@Size(min = 1, max = 50, message= "品名は1～50文字で入力してください")
	@NotNull(message="文字を入力してください")
	private String name;
	
	//数字は0じゃなくてnullで初期値を出したいからintじゃなくてIntegerで
	@NotNull(message="数値を入力してください")
	@Positive
	private Integer count;
	
	@NotNull(message="数値を入力してください")
	@Positive
	private Integer price;
	
	@Size(min = 1, max = 50, message= "場所は1～50文字で入力してください")
	@NotNull(message="文字を入力してください")
	private String location;
	
	private int id;

	public ShoppingForm() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
