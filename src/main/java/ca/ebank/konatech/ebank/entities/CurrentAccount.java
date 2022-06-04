package ca.ebank.konatech.ebank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor

//JPA
@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends BankAccount{
    private double overDraft;

}
