package co.fingerprintsoft.spring.hibernate.audit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.internal.NotNull;

import lombok.Data;

@Data
@Entity
@Audited
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    @NotNull
    @Length(min = 6, max = 6)
    private String customerNumber;

    @Audited
    @OneToMany(mappedBy = "customer")
    private Collection<Account> accounts = new ArrayList();

//    @Size(max = 10, message = "{Size.customer.devices}")
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Set<Device> devices = new HashSet();

}
