package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_relations.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
