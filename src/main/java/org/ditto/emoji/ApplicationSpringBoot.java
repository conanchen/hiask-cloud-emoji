package org.ditto.emoji;

import org.ditto.emoji.grpc.EmojiGrpcService;
import org.ditto.emoji.grpc.GreeterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationSpringBoot {

    @Bean
    public GreeterService greeterService() {
        return new GreeterService();
    }


    @Bean
    public EmojiGrpcService emojiService() {
        return new EmojiGrpcService();
    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpringBoot.class, args);
    }
}
