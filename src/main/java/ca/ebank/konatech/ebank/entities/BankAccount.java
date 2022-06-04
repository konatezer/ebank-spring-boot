package ca.ebank.konatech.ebank.entities;


import ca.ebank.konatech.ebank.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//JPA
@Entity
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    // plusieur compte pour un client
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;

}
