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
@ConfigurationProperties(prefix = "sms")
public class SMS {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
