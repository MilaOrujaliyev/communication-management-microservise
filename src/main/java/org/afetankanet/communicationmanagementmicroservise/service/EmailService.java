package org.afetankanet.communicationmanagementmicroservise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendTemplateEmail(String to, String subject, Map<String, Object> templateModel, String templateName) {
        Context context = new Context();
        context.setVariables(templateModel);
        String htmlBody = templateEngine.process(templateName, context);

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.setFrom("afetankanet@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
        };
        mailSender.send(messagePreparator);
    }
}









