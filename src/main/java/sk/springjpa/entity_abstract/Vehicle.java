package sk.springjpa.entity_abstract;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@NamedQuery(name = "Vehicle.findAllOrderSpeed", query = "SELECT v FROM Vehicle v Order by v.maxSpeed DESC")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(name = "brand")
    private final String brand;

    @Column(name = "year")
    private final int year;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "consumption")
    private int consumption;

    @Column(name = "max_fuel")
    private final int maxFuel;

    @Transient
    private int currentFuel;

    @Transient
    private String licensePlate;

    public Vehicle() {
        this.brand = null;
        this.year = 0;
        this.maxSpeed = 0;
        this.maxFuel = 0;
        this.currentFuel = 0;
        this.consumption = 0;
    }


    public Vehicle(String brand, int year, int maxSpeed, int maxFuel, int consumption) {
        this.brand = brand;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
        this.consumption = consumption;
    }

    public void drive(int distance) {
        int fuelNeeded = distance * this.consumption / 100;
        if(fuelNeeded > currentFuel) {
            int distanceDrove = currentFuel * 100 / consumption;
            System.out.println(brand + ": Not enough fuel! Drove " + distanceDrove + " km" + " (used: " + currentFuel +" fuel)");
            currentFuel = 0;
            return;
        }
        currentFuel -= fuelNeeded;
        System.out.println(brand + ": Driving " + distance + " km" + " (used: " + fuelNeeded +" fuel)");
    }

    public void refuel(int newFuel) {
        if(newFuel + currentFuel > maxFuel) {
            System.out.println(brand + ": Refueled: ("+newFuel+" is Too much fuel!) set to max");
            currentFuel = maxFuel;
            return;
        }
        currentFuel += newFuel;
        System.out.println(brand + ": Refueled: " + newFuel + " fuel");
    }


    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void looseFuel(int fuel) {
        currentFuel -= fuel;
        if(currentFuel < 0) {
            currentFuel = 0;
        }
    }



    public int getMaxFuel() {
        return maxFuel;
    }

    public int getConsumption() {
        return consumption;
    }



    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return String.format("%s  fuel: %d/%d, maxSpeed: %d, year: %d", brand, currentFuel, maxFuel, maxSpeed, year);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vehicle && Objects.equals(this.getLicensePlate(), ((Vehicle) obj).getLicensePlate());
    }


}
