package com.shopping.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user")
public class User {
	@Id
	private String email; 
	private String name;
	private String password;
	private String mobile; 
	private char role;
	private Timestamp registerdate;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public char getRole() {
		return role;
	}
	public void setRole() {
		this.role = 'C';
	}
	public Timestamp getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate() {
		 this.registerdate=new Timestamp(System.currentTimeMillis());
	}

}
