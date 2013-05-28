package pl.byMario.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Mariusz Lewandowski; byMario
 */
@Service
public class MailSendService {

	private static final long serialVersionUID = 1L;

	
	private JavaMailSender mailSender;

//	@Resource
//	public void setMailSender(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}

	public void executeSendMail() {
		// wyslanie maila
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mmHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mmHelper.setSentDate(new Date());
				
				mmHelper.setFrom("mariusz.lewandowski@archidoc.pl");
				mmHelper.addTo("mariusz.lewandowski@archidoc.pl");
				
				mmHelper.setSubject("TYTUL - test maila");
				mmHelper.setText("TRESC - test maila");
				return;
			}
		});
		return;
	}
}
