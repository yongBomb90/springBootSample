package kr.co.bomb.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BombWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        setRegisterErrorPageFilter(false);
        return builder.sources(BombWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BombWebApplication.class, args);
    }

}
