package co.fingerprintsoft.spring.hibernate.audit;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Data;

@Data
@Entity
@Audited
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Audited
    @ManyToOne
    @JoinColumn(
            name = "customer_customernumber",
            referencedColumnName = "customerNumber",
            columnDefinition = "VARCHAR(6)",
            foreignKey = @ForeignKey(name = "fk_acc_cust_custnumber")

    )
    @NotNull
    private Customer customer;

}
