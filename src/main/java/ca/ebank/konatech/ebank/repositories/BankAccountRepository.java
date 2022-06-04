package ca.ebank.konatech.ebank.repositories;

import ca.ebank.konatech.ebank.entities.BankAccount;
import ca.ebank.konatech.ebank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
