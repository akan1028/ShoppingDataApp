package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.Shopping;
import com.example.demo.dao.ShoppingDao;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	
	private final ShoppingDao dao;
	
	@Autowired
	public ShoppingServiceImpl(ShoppingDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Shopping shopping) {
		dao.insertShopping(shopping);
		
	}
	
	@Override
	public void delete(int id) {
		dao.deleteShopping(id);
	}

	@Override
	public List<Shopping> getAll() {
		
		
		return dao.getAll();
	}

}
