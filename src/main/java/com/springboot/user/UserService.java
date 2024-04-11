package com.springboot.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.emailService.Mail;

@Component
public interface UserService {

	public void sendEmail(Mail mail);
	
	UserModel save(UserModel userModel);
	
	List<UserModel> getAll();
	
	void getByUserID(Long user_id);
	
	UserModel updateUser(UserModel userModel);
	
	String delete(Long user_id);
	
}
