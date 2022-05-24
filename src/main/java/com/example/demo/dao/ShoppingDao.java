package com.example.demo.dao;

import java.util.List;

import com.example.demo.app.Shopping;

public interface ShoppingDao {
	
	void insertShopping(Shopping shopping);
	
	void deleteShopping(int id);
	
	List<Shopping> getAll();
	
	

}
