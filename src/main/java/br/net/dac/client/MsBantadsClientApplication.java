package br.net.dac.client;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@EnableRabbit
public class MsBantadsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBantadsClientApplication.class, args);
    }

}
