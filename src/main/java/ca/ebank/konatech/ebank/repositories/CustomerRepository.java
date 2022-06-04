package ca.ebank.konatech.ebank.repositories;

import ca.ebank.konatech.ebank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
