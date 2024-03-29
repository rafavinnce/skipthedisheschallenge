package com.rafael.skip.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.skip.challenge.model.Order;
import com.rafael.skip.challenge.model.OrderItem;
import com.rafael.skip.challenge.model.Product;
import com.rafael.skip.challenge.model.ResultModel;
import com.rafael.skip.challenge.repository.OrderRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Order")
public class OrderController {

	public OrderRepository OrderRepository;

	@Autowired
	public OrderController(OrderRepository OrderRepository) {
		this.OrderRepository = OrderRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResultModel insert(@RequestBody Order Order, OrderItem orderitem, Product product) {
		return this.OrderRepository.Post(Order, orderitem, product);
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Order findbyID(@PathVariable("orderId") Integer id) {
		return this.OrderRepository.findbyId(id);
	}
}
