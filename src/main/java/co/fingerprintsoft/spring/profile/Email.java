package co.fingerprintsoft.spring.profile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: naeem
 * Date: 2014/10/04
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@ConfigurationProperties(prefix = "email")
public class Email {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
