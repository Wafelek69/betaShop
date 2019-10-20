package pl.cz.shop.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.cz.shop.entity.User;

import javax.mail.internet.MimeMessage;

@Component
public class EmailUtil {

    private  JavaMailSender javaMailSender;



    public EmailUtil() {
      //  this.javaMailSender = new JavaMailSender();
    }

    @Async
    private void sendSimpleMessage(String to, String subject, String body) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom("szkolenia@wp.pl");
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {

        }
    }

    @Async
    public void sendSpam(User user) {
        sendSimpleMessage(
                user.getEmail(),
                "to jest sss",
                "promocje wielkie");
    }




}