package ro.sd.a3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a3.EmailSender;
import ro.sd.a3.entity.AppUser;
import ro.sd.a3.repo.UserRepository;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    /*private final UserRepository userRepository;

    @Autowired
    public ConsumerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    */
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(AppUser appUser) {
        EmailSender.sendConfirmationEmail(appUser.getEmail());
        logger.info("persisted " + appUser.getName());
        logger.info("User Details Received is.. " + appUser.getEmail());
    }

}
