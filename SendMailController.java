package com.axelbork.portfolio.Controller;

import com.axelbork.portfolio.Security.Controller.Mensaje;
import com.axelbork.portfolio.Service.SendMailService;
import com.axelbork.portfolioDto.dtoMail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:4200")

public class SendMailController {

    @Autowired
    SendMailService sendMailService;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody dtoMail dtoMail) {
        if (StringUtils.isBlank(dtoMail.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoMail.getEmail())) {
            return new ResponseEntity(new Mensaje("El mail es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoMail.getMessage())) {
            return new ResponseEntity(new Mensaje("El message es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        sendMailService.sendMail(dtoMail.getName(), dtoMail.getEmail(), dtoMail.getMessage());

        return new ResponseEntity(
                new Mensaje("Email enviado"), HttpStatus.OK);

    }

}
