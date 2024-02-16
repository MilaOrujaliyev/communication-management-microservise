package org.afetankanet.communicationmanagementmicroservise.controller;

import org.afetankanet.communicationmanagementmicroservise.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        emailService.sendEmail("milaorujaliyev@gmail.com", "Test Konusu", "Bu bir test e-postasıdır.");
        return "E-posta gönderildi.";
    }
}
