package com.springboot.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springboot.emailService.Mail;
import com.springboot.emailService.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MailService mailService;
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	
	@Override
	public void sendEmail(Mail mail) 
	{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setText(mail.getMailContent());
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel save(UserModel userModel) {
		return userRepository.save(userModel);
	}

	@Override
	public List<UserModel> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void getByUserID(Long user_id) {
		 userRepository.findById(user_id);
		 
		 
	}

	@Override
	public UserModel updateUser(UserModel userModel) {

		UserModel model=new UserModel();
		model.setUser_name(userModel.getUser_name());
		model.setUser_email(userModel.getUser_email());
		model.setUser_mobile(userModel.getUser_mobile());
		
		return model;
	}

	@Override
	public String delete(Long user_id) {
		
		  userRepository.deleteById(user_id);
		  return  "data delete ";
		
		
	}
	
	
	
	
}
