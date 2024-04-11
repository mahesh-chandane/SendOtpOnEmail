package com.springboot.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserModel {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	private String user_name;
	private String user_email;
	private Long user_mobile;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Long getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(Long user_mobile) {
		this.user_mobile = user_mobile;
	}
	public UserModel(Long user_id, String user_name, String user_email, Long user_mobile) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
	}
	public UserModel() {
		super();
	}
	
	
}
