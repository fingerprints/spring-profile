package co.fingerprintsoft.spring.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@SpringApplicationConfiguration(classes = {
        App.class
}
)
@ActiveProfiles("dev,strange")
public class AppWithStrangeProfileTest {

    @Autowired
    private Values val;

    @Test
    public void testApp() {
        System.out.println("val = " + val);
        assertEquals("strange@fingerprintsoft.co", val.getEmail());
        assertEquals("devnum", val.getSms());
        assertEquals("none", val.getAlert());
    }
}
