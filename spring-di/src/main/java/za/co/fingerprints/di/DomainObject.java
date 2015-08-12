package za.co.fingerprints.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class DomainObject {

    @Autowired
    private BeanToInject beanToInject;
}
