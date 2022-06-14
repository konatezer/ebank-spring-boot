package ca.ebank.konatech.ebank.services;


import ca.ebank.konatech.ebank.entities.BankAccount;
import ca.ebank.konatech.ebank.entities.CurrentAccount;
import ca.ebank.konatech.ebank.entities.SavingAccount;
import ca.ebank.konatech.ebank.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("19d610aa-29d0-4d14-b6c0-da5297ebb276").orElse(null);
        if (bankAccount != null) {
            System.out.println("===================== INFO ACCOUNT ========================");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getFirstname());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("Over draft ==>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("Rate ==>" + ((SavingAccount) bankAccount).getInterestRate());
            }

            System.out.println("================= Les Operation du compte ==============");
            bankAccount.getAccountOperations().forEach(op -> {

                System.out.println("Type: " + op.getType() + "\t Date: " + op.getOperationDate() + "\t Montant: " + op.getAmount());

            });
        }
    }
}
