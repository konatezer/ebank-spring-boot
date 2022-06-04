package ca.ebank.konatech.ebank.repositories;

import ca.ebank.konatech.ebank.entities.AccountOperation;
import ca.ebank.konatech.ebank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
