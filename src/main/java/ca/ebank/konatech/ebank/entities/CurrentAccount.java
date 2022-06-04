package ca.ebank.konatech.ebank.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends BankAccount{
    private double overDraft;

}
