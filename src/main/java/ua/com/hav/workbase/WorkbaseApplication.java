package ua.com.hav.workbase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WorkbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkbaseApplication.class, args);
        log.info(".................. start ...................");
    }

}
