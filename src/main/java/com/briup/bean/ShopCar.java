package com.briup.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类
 */
public class ShopCar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//key   - 书籍编号
	//value - 订单项
	private Map<Integer,OrderLine> map;
	
	{
		map = new HashMap<>();
	}
	
	public void add(Book book,Integer num) {
		Integer bookId = book.getId();
		if(map.containsKey(bookId)) {
			OrderLine orderLine = map.get(bookId);
			orderLine.setNum(orderLine.getNum()+num);
			orderLine.setCost(book.getPrice()*orderLine.getNum());
		}else {
			OrderLine orderLine = new OrderLine();
			orderLine.setBook(book);
			orderLine.setNum(num.longValue());
			orderLine.setCost(book.getPrice()*num);
			map.put(book.getId(), orderLine);
		}
	}
	public void add(Book book) {
		add(book,1);
	}
	
	public Map<Integer,OrderLine> getData(){
		return map;
	}
	
	public Collection<OrderLine> getOrderLines(){
		return map.values();
	}
	
	public int getSize() {
		return map.size();
	}
	
	public double getCost() {
		double sum = 0;
		for(OrderLine ol : map.values()) {
			sum+=ol.getCost();
		}
		return sum;
	}
	
	public void removeOrderLine(int bookId) {
		map.remove(bookId);
	}
	
	public void clear() {
		map.clear();
	}
	
}
