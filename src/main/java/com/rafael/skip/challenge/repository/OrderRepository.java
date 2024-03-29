package com.rafael.skip.challenge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rafael.skip.challenge.model.Order;
import com.rafael.skip.challenge.model.OrderItem;
import com.rafael.skip.challenge.model.Product;
import com.rafael.skip.challenge.model.ResultModel;

@Repository
public class OrderRepository {

	@Autowired
	JdbcTemplate jdbctemplate;

	public ResultModel Post(Order Order, OrderItem orderitem, Product product) {

		try {
			jdbctemplate.update(
					"INSERT INTO `vanhack`.`Order`(`date`,`customerId`,`deliveryAddress`,`contact`,`storeId`)VALUES(?,?,?,?,?);",
					Order.getDate(), Order.getCustomerId(), Order.getDeliveryAddress(), Order.getContact(),
					Order.getStoreId());

			jdbctemplate.update(
					"INSERT INTO `vanhack`.`OrderItem`(`orderId`,`price`,`quantity`,`total`,`productId`)VALUES(?,?,?,?,?);",
					orderitem.getOrderId(), orderitem.getPrice(), orderitem.getQuantity(), orderitem.getTotal());

			jdbctemplate.update(
					"INSERT INTO `vanhack`.`product`(`storeid`,`name`,`description`,`price`)VALUES(?,?,?,?,);",
					product.getStoreid(), product.getName(), product.getDescription(), product.getPrice());

		} catch (Exception e) {
			return new ResultModel(400, "error:");
		}
		return new ResultModel(200, "Sucess");
	}

		
	public Order findbyId(int id) {
		return jdbctemplate.queryForObject("Select * from vanhack.Order where id = ?",
				new BeanPropertyRowMapper<Order>(Order.class), id);
	}

}
