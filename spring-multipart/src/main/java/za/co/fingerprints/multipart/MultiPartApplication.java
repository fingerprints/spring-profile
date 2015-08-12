package za.co.fingerprints.multipart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("za.co.fingerprints.multipart")
public class MultiPartApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultiPartApplication.class, args);
    }
}
