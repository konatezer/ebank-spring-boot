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
@DiscriminatorValue("SA")
public class SavingAccount extends BankAccount{
    private double interestRate;
}
