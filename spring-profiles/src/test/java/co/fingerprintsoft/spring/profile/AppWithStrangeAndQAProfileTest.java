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
@ActiveProfiles("qa,strange")
public class AppWithStrangeAndQAProfileTest {

    @Autowired
    private Values val;

    @Test
    public void testApp() {
        System.out.println("val = " + val);
        assertEquals("strange@fingerprintsoft.co", val.getEmail());
        assertEquals("qanum", val.getSms());
        assertEquals("qaprop", val.getAlert());
    }
}
