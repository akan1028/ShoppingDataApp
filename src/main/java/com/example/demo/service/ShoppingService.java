package com.example.demo.service;

import java.util.List;

import com.example.demo.app.Shopping;

public interface ShoppingService {
	
	void save(Shopping shopping);
	
	void delete(int id);
	
	List<Shopping> getAll();

}
