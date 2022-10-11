package ro.sd.a3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ro.sd.a3.entity.AppUser;
import ro.sd.a3.entity.EmailSender;
import ro.sd.a3.entity.PayloadDTO;

@RestController
public class EmailController {
    private static final String TOKEN = "b88a21a4-45f0-42bc-9f26-499a403292e6";
    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    @PostMapping("/sendEmail")
    public ResponseEntity<Boolean> sendEmail(@RequestHeader("AUTHORIZATION") String authorizationToken, @RequestBody PayloadDTO payloadDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Error on binding result");
        }
        else{
            if(authorizationToken.equals(TOKEN)) {
                EmailSender.sendConfirmationEmail(payloadDTO.getEmail(), 2, payloadDTO);
                return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
            }
        }

        return  new ResponseEntity<>(Boolean.FALSE,HttpStatus.BAD_REQUEST);
    }
}
