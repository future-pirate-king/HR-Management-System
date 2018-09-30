package com.project.hrmanagement.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hrmanagement.model.Employee;
import com.project.hrmanagement.model.LoginCredential;
import com.project.hrmanagement.service.IEmployeeLoginService;
import com.project.hrmanagement.service.IEmployeeService;

//-----------working-----------//
// authentication (working completely with aungular and json obj) no changes req!!

@RestController
@RequestMapping("/LoginIn")
public class EmployeeLoginController {

	IEmployeeLoginService employeeLoginService;

	private IEmployeeService employeeService;

	int len = 4;
	char[] otp = new char[len];

	// authenticate employee by checking employee Id and password
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Employee authenticate(@RequestBody LoginCredential lc) {

		if (this.employeeLoginService.authenticate(lc)) {
			return this.employeeService.getEmployee(lc.getEmpId());
		}
		return null;
	}

	@RequestMapping(value = "/otpgen", method = RequestMethod.POST)
	public Boolean OtpGenerator(@RequestParam("empId") Integer empId) {
		/* System.out.print("You OTP is : "); */
		String numbers = "0123456789";
		// Using random method
		Random rndm_method = new Random();
		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));

		}
		if (otp != null)

		{
			System.out.println(otp);
			String host = "smtp.sendgrid.net";
			final String user = "apikey";
			final String password = "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";
			String to = employeeLoginService.getEmployeeMail(empId);
			String generatedOtp = new String(otp);

			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", 587);

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			// Compose the message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Password reset Request from Lets Manage");
				message.setText("your OTP is " + generatedOtp);

				// send the message
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

	public Boolean OtpVerifier(@RequestParam("recvdOtp") Integer recvdOtp) {

		String receivedOtp = recvdOtp.toString();
		String generatedOtp = new String(otp);
		if (receivedOtp == generatedOtp) {
			return true;
		} else

			return false;

	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public Boolean resetPassword(@RequestParam("password") String newPass, @RequestParam("empId") Integer empId,
			@RequestParam("OTP") Integer recvdOtp) {
		

		String receivedOtp = recvdOtp.toString();
		String generatedOtp = new String(otp);
		if (receivedOtp == generatedOtp) {
			otp = null;
			return employeeLoginService.resetPassword(newPass, empId);
		}
		return false;
	}

	// Extra service not yet used in UI
	@RequestMapping(value = "/getLastLogin", method = RequestMethod.GET)
	public List<String> getLastLogin(@RequestParam("empId") Integer empId) {

		return employeeLoginService.getLastLogin(empId);

	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	@Autowired
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public IEmployeeLoginService getEmployeeLoginService() {
		return employeeLoginService;
	}

	@Autowired
	public void setEmployeeLoginService(IEmployeeLoginService employeeLoginService) {
		this.employeeLoginService = employeeLoginService;
	}

}
