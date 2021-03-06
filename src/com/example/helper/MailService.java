package com.example.helper;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import android.util.Log;

public class MailService {
	public void sendEmail() throws AddressException, MessagingException {
		String host = "smtp.gmail.com";
		String address = "naveed.umar@gmail.com";

		String from = "naveed.umar@gmail.com";
		String pass = "suave_1234";
		String to = "naveedumar@gmail.com";

		Multipart multiPart;
		String finalString = "";

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", address);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		Log.i("Check", "done pops");
		Session session = Session.getDefaultInstance(props, null);
		
		DataHandler handler = new DataHandler(new ByteArrayDataSource(
				finalString.getBytes(), "text/plain"));
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setDataHandler(handler);
		Log.i("Check", "done sessions");

		multiPart = new MimeMultipart();

		InternetAddress toAddress;
		toAddress = new InternetAddress(to);
		message.addRecipient(Message.RecipientType.TO, toAddress);
		Log.i("Check", "added recipient");
		message.setSubject("Send Auto-Mail");
		message.setContent(multiPart);
		message.setText("Demo For Sending Mail in Android Automatically");

		Log.i("check", "transport");
		Transport transport = session.getTransport("smtp");
		Log.i("check", "connecting");
		transport.connect(host, address, pass);
		Log.i("check", "wana send");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

		Log.i("check", "sent");

	}

	// Read more:
	// http://mrbool.com/how-to-work-with-java-mail-api-in-android/27800#ixzz2ulhTmmEU
}
