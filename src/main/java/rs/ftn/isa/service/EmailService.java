package rs.ftn.isa.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import rs.ftn.isa.model.BookingFlight;

@Service
public class EmailService {

	private JavaMailSender mailSender;
	
	@Autowired
	public EmailService(JavaMailSender mailSender) throws MailException {
		this.mailSender = mailSender;
	}
		
	@Async
	public void SendEmail(String receiver, Object obj) {
			BookingFlight f = (BookingFlight) obj;
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(receiver);
			mailMessage.setSubject("Successful reservation");
			mailMessage.setText("Your reservation is successfully created! " + "Flight to " + f.getFlight().getDestination() + " on day " + f.getReservationDate() + ".");
			mailSender.send(mailMessage);
		
		
		
	}
	
	@Async
	public void InviteEmail(String receiver, Object obj, String sender) throws MessagingException {
			BookingFlight f = (BookingFlight) obj;							
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,false,"utf-8");
			String text = "" + sender + " has invited you to " + f.getFlight().getDestination() +  ". For more details" +  " <a href=\"http://localhost:4200/invitations/" + f.getId() + "\"> click here! </a>" ;
			mimeMessage.setContent(text,"text/html");
			mimeMessageHelper.setTo(receiver);
			mimeMessageHelper.setSubject("Flight invitation");
			mimeMessageHelper.setFrom("student.ftn.isa@gmail.com");
			mailSender.send(mimeMessage);

		
	}
	
	
}
