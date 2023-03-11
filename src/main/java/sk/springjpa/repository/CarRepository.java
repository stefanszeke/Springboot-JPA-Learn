package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_relations.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
