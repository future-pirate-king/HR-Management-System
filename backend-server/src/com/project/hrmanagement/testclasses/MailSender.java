package com.project.hrmanagement.testclasses;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;
public class MailSender {
	  
	public static void main(String[] args) {  
		  
		  String host="smtp.sendgrid.net";  
		  final String user="apikey";//change accordingly  
		  final String password="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";//change accordingly  
		    
		  String to="virajbhat69@gmail.com";//change accordingly  
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		   props.put("mail.smtp.port", 587);
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("Password reset Request from Lets Manage");  
		     message.setText("your OTP is");  
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		 }  
	

}
