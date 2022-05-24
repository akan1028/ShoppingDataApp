package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.app.Shopping;

@Repository
public class ShoppingDaoImpl implements ShoppingDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ShoppingDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertShopping(Shopping shopping) {
		jdbcTemplate.update("INSERT INTO SHOPPING(name, count, price,priceadd, location, date) VALUES(?, ?, ?, ?, ?, ?)",
				shopping.getName(), shopping.getCount(), shopping.getPrice(),shopping.getPriceadd(), shopping.getLocation(), shopping.getDate());
		
	

	}

	@Override
	public List<Shopping> getAll() {
		String sql = "SELECT id, name, count, price, priceadd, location, date FROM shopping";
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql);
		List<Shopping> list = new ArrayList<Shopping>();
		for(Map<String,Object> result:resultlist) {
			Shopping shopping = new Shopping();
			shopping.setId((int)result.get("id"));
			shopping.setName((String)result.get("name"));
			shopping.setCount((int)result.get("count"));
			shopping.setPrice((int)result.get("price"));
			shopping.setPriceadd((int)result.get("priceadd"));
			shopping.setLocation((String)result.get("location"));
			shopping.setDate((Date)result.get("date"));
			list.add(shopping);
			
		}
		
		return list;
	}
	
	@Override
	public void deleteShopping(int id) {
		jdbcTemplate.update("DELETE FROM SHOPPING WHERE id = ?",id);
				
	}

}
