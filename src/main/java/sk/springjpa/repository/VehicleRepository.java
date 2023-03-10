package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_abstract.Vehicle;

import java.util.List;

public interface VehicleRepository<S extends Vehicle> extends JpaRepository<S, Long> {

    public List<S> findAllByOrderByMaxSpeed();

    public List<S> findTop3ByOrderByMaxSpeed();

    public List<S> findTop3ByOrderByMaxSpeedDesc();

    public List<S> findAllByMaxSpeedBetween(int min, int max);

    public List<S> findTop10ByMaxSpeedBetweenOrderByBrandDesc(int min, int max);

    public List<S> findAllByMaxSpeedGreaterThanEqual(int min);

    public List<S> findAllByBrandStartingWith(String brand);

}
