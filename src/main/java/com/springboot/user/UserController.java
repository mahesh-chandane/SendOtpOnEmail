package com.springboot.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.emailService.Mail;
import com.springboot.emailService.MailService;

@RestController
@RequestMapping("userModel")
public class UserController {

	@Autowired
	private UserService userService;
		
	@Autowired
	private MailService mailService;
	
	@PostMapping("/sendEmail")
	public int sendEmail(@RequestBody Mail info) {
		Mail mail = new Mail();
		int randomNumber = (int) (Math.random() * 900000) + 100000;
		mail.setMailFrom("maheshchandane7620@gmail.com");
		mail.setMailTo(info.getMailTo());
		mail.setMailSubject("OTP for forget Password");
		mail.setMailContent("Hello Mail send Successfully. Your OTP is : " + randomNumber);
		mailService.sendEmail(mail);
		return randomNumber;
	}
	
	
	@PostMapping("/saveUser")
	public UserModel saveUser(@RequestBody UserModel userModel)
	{
		return userService.save(userModel);
	}
	
	@PostMapping("/updateUser")
	public UserModel updateUser(@RequestBody UserModel userModel)
	{
		return userService.updateUser(userModel);
	}
	
	@PostMapping("/geAll")
	public List<UserModel> getAll()
	{
		return userService.getAll();
	}
	
	@GetMapping("/getById/{user_id}")
	public void getById(@PathVariable Long user_id)
	{
	   userService.getByUserID(user_id);
	}
	
	@DeleteMapping("/delete/{user_id}")
	public String deleteById(@PathVariable Long user_id)
	{
	   return userService.delete(user_id);
	   
	}
	
	
	
}
