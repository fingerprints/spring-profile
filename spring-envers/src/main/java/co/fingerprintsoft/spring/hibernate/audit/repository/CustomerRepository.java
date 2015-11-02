package co.fingerprintsoft.spring.hibernate.audit.repository;

import org.springframework.data.envers.repository.support.EnversRevisionRepository;
import org.springframework.stereotype.Repository;

import co.fingerprintsoft.spring.hibernate.audit.Customer;

@Repository
public interface CustomerRepository extends EnversRevisionRepository<Customer, Long, Integer> {
}
