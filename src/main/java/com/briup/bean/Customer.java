package com.briup.bean;

import java.io.Serializable;

/**
 *  顾客类
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String password;
	private String zipCode;
	private String address;
	private String telephone;
	private String email;

	public Customer() {}

	public Customer(String name, String password, String zipCode, String address, String telephone, String email) {
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zipCode=" + zipCode
				+ ", address=" + address + ", telephone=" + telephone + ", email=" + email + "]";
	}

}
