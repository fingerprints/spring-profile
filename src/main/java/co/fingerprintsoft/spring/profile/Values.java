package co.fingerprintsoft.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: naeem
 * Date: 2014/10/04
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties
@Component
public class Values {

    @Autowired
    private Email email;

    @Autowired
    private SMS sms;

    private String alert;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getSms() {
        return sms.getNumber();
    }

}
