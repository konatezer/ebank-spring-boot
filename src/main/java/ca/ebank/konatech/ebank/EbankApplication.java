package ca.ebank.konatech.ebank;

import ca.ebank.konatech.ebank.entities.AccountOperation;
import ca.ebank.konatech.ebank.entities.CurrentAccount;
import ca.ebank.konatech.ebank.entities.Customer;
import ca.ebank.konatech.ebank.entities.SavingAccount;
import ca.ebank.konatech.ebank.enums.AccountStatus;
import ca.ebank.konatech.ebank.enums.OperationType;
import ca.ebank.konatech.ebank.repositories.AccountOperationRepository;
import ca.ebank.konatech.ebank.repositories.BankAccountRepository;
import ca.ebank.konatech.ebank.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankApplication.class, args);
    }


    // Inserer des donnees pas le bias de commandLineRunner
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            AccountOperationRepository accountOperationRepository,
                            BankAccountRepository bankAccountRepository) {
        return args -> {
            // creer des clients
            Stream.of("Emmanuel", "Philippe", "Patrick", "Mamoutou").forEach(name -> {
                Customer customer = new Customer();
                customer.setFirstname(name);
                customer.setLastname(name.substring(2, 6));
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });

            // pour chaque client on vas creer des comptes
            customerRepository.findAll().forEach(cust -> {
            	// compte courant
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 10000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(1000);
                bankAccountRepository.save(currentAccount);
				// compte d'epargne
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 10000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(3.5);
                bankAccountRepository.save(savingAccount);
            });



            // effecteur des operation dans chaque comptes
			bankAccountRepository.findAll().forEach(bankAccount -> {

				for(int i = 0; i < 10 ; i++){
				AccountOperation accountOperation = new AccountOperation();
				accountOperation.setBankAccount(bankAccount);
				accountOperation.setOperationDate(new Date());
				accountOperation.setAmount(Math.random()*5000);
				accountOperation.setType(Math.random() >0.5 ? OperationType.DEBIT : OperationType.CREDIT );
				accountOperationRepository.save(accountOperation);

				}

			});



        };
    }

}
