package sk.springjpa.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.springjpa.entity_abstract.Vehicle;
import sk.springjpa.repository.VehicleRepository;

import java.util.List;

@Component
public class VehicleService {

    @Autowired
    private VehicleRepository<Vehicle> vehicleRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save((Vehicle) vehicle);
    }

    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }



    public void printAllVehiclesE() {
        entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList().forEach(System.out::println);
    }

    public void printAllVehiclesOrderBySpeedE() {
        entityManager.createNamedQuery("Vehicle.findAllOrderSpeed", Vehicle.class).getResultList().forEach(System.out::println);
    }

    public List<Vehicle> printAllVehiclesOrderBySpeed() {
        return (List<Vehicle>) vehicleRepository.findAllByOrderByMaxSpeed();
    }

    public List<Vehicle> findAllByMaxSpeedBetween(int min, int max) {
        return (List<Vehicle>) vehicleRepository.findAllByMaxSpeedBetween(min, max);
    }
    public List<Vehicle> findAllByBrandStartingWith(String brand) {
        return (List<Vehicle>) vehicleRepository.findAllByBrandStartingWith(brand);
    }


    public List<Vehicle> findTop10ByMaxSpeedBetweenOrderByBrandDesc(int min, int max) {
        return (List<Vehicle>) vehicleRepository.findTop10ByMaxSpeedBetweenOrderByBrandDesc(min, max);
    }

    @Transactional
    public void deleteByIdE(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Vehicle v WHERE v.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
