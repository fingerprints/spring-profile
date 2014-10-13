package co.fingerprintsoft.spring.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import co.fingerprintsoft.spring.data.config.LoadApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LoadApplication.class)
@TransactionConfiguration(defaultRollback = true)
public class PersonTest {

    @Autowired
    private PersonService service;


    @Test
    public void testSavePerson() {
        Person person = new Person();
        service.savePerson(person);
        Assert.assertNotNull(person);
    }

    @Test
    public void findPerson() {
        Person person = service.findPerson(-1L);
        Assert.assertNotNull(person);
    }

}
