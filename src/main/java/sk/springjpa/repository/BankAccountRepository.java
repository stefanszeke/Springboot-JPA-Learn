package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_relations.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
