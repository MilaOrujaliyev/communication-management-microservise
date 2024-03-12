package org.afetankanet.communicationmanagementmicroservise.controller;

import org.afetankanet.communicationmanagementmicroservise.model.EmailRequest;
import org.afetankanet.communicationmanagementmicroservise.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendTemplateEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getTemplateModel(), emailRequest.getTemplateName());
        return ResponseEntity.ok("E-posta gönderildi.");
    }
}






