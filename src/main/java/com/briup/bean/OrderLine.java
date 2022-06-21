package com.briup.bean;

import java.io.Serializable;

/**
 * 订单项类
 */
public class OrderLine implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Long num;
	private Double cost;
	private Book book;
	private OrderForm orderForm;

	public OrderLine() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", cost=" + cost + ", book=" + book + "]";
	}

}
