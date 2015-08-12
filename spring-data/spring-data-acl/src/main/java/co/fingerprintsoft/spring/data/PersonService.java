package co.fingerprintsoft.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    public MutableAclService aclService;

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public Person findPerson(Long id) {
        return repository.findOne(id);
    }

}
