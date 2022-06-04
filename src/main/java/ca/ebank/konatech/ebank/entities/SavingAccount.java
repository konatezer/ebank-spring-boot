package ca.ebank.konatech.ebank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends BankAccount{
    private double interestRate;
}
