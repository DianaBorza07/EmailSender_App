package ro.sd.a3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Assignment3SdApplication {
    public static void main(String[] args) {
        SpringApplication.run(Assignment3SdApplication.class, args);
    }
}
