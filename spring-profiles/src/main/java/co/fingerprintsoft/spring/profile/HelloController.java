package co.fingerprintsoft.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: naeem
 * Date: 2014/10/04
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class HelloController {

    @Autowired
    private Values values;

    @RequestMapping("/")
    public String helloWorld() {
        return "howzit!!";
    }

    @RequestMapping("/vals")
    public Values showAll() {
        return values;
    }
}
