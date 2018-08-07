package com.sbm.helpdesk.common.mailer;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;



public class Mailer {

	@Value("${mail.template.path}")
	private static String TEMPLATE_PATH;
	@Value("${mail.username}")
	private static String EMAIL;
	@Value("${mail.password}")
	private static String PASSWORD;
	@Value("${mail.smtp.host}")
	private static String MAIL_SMTP_HOST;
	@Value("${mail.smtp.port}")
	private static String MAIL_SMTP_PORT;

	public static void send(String to[], String sub, String content ) {

		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.host", MAIL_SMTP_HOST == null ? "192.168.3.138" : MAIL_SMTP_HOST);
		props.put("mail.smtp.auth", "true" );
		props.put("mail.smtp.port", MAIL_SMTP_PORT == null ? "25" : MAIL_SMTP_PORT);

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL  == null ? "info@sbm.helpdesk.com" : EMAIL , PASSWORD  == null ? "12345" : PASSWORD);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("info@sbm.helpdesk.com"));
			for (int i = 0; i < to.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}
			
			message.setSubject(sub, "UTF-8");
			message.setText(content);
			Transport.send(message);
		} catch (Exception e) {
			//logger.error("Error while sending notification - Message: " + e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}
	
}
