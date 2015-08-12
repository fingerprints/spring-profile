package za.co.fingerprints.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("za.co.fingerprints.di")
public class DIApplication {
    public static void main(String[] args) {
        SpringApplication.run(DIApplication.class, args);
        DomainObject domainObject = new DomainObject();
    }
}
