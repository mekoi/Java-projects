package com.spring.boot.micro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {		
	
	@NotNull 
	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="customerid")
	private int customerId;
	
	@NotNull(message="Customer name is needed")
	@Size(min=1, max=30)
	@Column(name="customername")
	private String customerName;	
	
	@NotNull(message="Address is needed")
	@Size(min=1, max=100)
	@Column(name="address")
	private String address;
	
	@NotNull(message="City is needed")
	@Size(min=1, max=20)
	@Column(name="city")
	private String city;
	
	@NotNull(message="Email is needed")
	@Size(min=5, max=30)
	@Email(message = "Enter email address")
	@Column(name="email")
	private String email;
	
	@NotNull(message="Phone number is needed")
	@Size(min=10, max=10)
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Phone number is invalid")
	@Column(name="phonenumber")
	private String phoneNumber;
	
	public Customer() {		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}