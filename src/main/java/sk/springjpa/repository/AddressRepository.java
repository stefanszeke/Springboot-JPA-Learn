package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_relations.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
