package ro.sd.a3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ro.sd.a3.entity.EmailSender;
import ro.sd.a3.entity.AppUser;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(AppUser appUser) {
        EmailSender.sendConfirmationEmail(appUser.getEmail(),1,null);
        logger.info("persisted " + appUser.getName());
        logger.info("User Details Received is.. " + appUser.getEmail());
    }

}
