package co.fingerprintsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableHystrix
@ComponentScan("za.co.fingerprints.hystrix")
@RestController
public class HystrixApplication {

    @Autowired
    Service service;

    @RequestMapping("/")
    @HystrixCommand
    public String slash() {
        return service.hello();
    }

    @Bean
    Service service() {
        return new Service();
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    class Service {

        public String hello() {
            return "Hello";
        }
    }

}
