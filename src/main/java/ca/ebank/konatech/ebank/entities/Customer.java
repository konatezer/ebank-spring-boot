package ca.ebank.konatech.ebank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;



// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//JPA
@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    //un client peut avoir plusieur compte
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}
