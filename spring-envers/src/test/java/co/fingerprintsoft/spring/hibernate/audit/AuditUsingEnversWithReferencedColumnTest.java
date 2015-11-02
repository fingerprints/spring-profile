package co.fingerprintsoft.spring.hibernate.audit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.fingerprintsoft.spring.hibernate.audit.repository.AccountRepository;
import co.fingerprintsoft.spring.hibernate.audit.repository.CustomerRepository;
import co.fingerprintsoft.spring.hibernate.audit.repository.DeviceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@Rollback(false)
@IntegrationTest
//@Transactional
public class AuditUsingEnversWithReferencedColumnTest {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Test
//    @Sql(
//            scripts = {
//                    "/data/single_customer_details_test_data.sql",
//                    "/data/single_account_test_data.sql",
//                    "/data/device_info_test_data.sql"
//            }
//    )
    public void testDeleteDevice() {
        Customer customer = new Customer();
        customer.setCustomerNumber("123457");
        customerRepository.save(customer);
        Device device = new Device();
        device.setCustomer(customer);

        Account account = new Account();
        account.setCustomer(customer);
        accountRepository.save(account);
        accountRepository.delete(account);

        deviceRepository.save(device);
//        customerRepository.delete(customer);
        deviceRepository.delete(device);
    }

}
