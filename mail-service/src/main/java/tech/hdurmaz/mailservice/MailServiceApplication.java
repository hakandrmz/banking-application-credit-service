package tech.hdurmaz.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(
    scanBasePackages = {
        "tech.hdurmaz.mailservice",
        "tech.hdurmaz.amqp",
    }
)
@ConfigurationPropertiesScan
public class MailServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MailServiceApplication.class, args);
  }

}
