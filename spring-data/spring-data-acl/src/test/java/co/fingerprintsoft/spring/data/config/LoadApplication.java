package co.fingerprintsoft.spring.data.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "co.fingerprintsoft.spring.data")
@EntityScan(basePackages = "co.fingerprintsoft.spring.data")
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "co.fingerprintsoft.spring.data"
        }
)
public class LoadApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LoadApplication.class, args);
    }

}
