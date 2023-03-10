package sk.springjpa.entity_abstract;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "vehicles")
public class SportsCar extends Vehicle {
    @Transient
    boolean turboOn = false;
    @Transient
    boolean acOn = false;

    public SportsCar() {
        super();
    }

    public SportsCar(String brand, int year, int maxSpeed, int maxFuel, int consumption) {
        super(brand, year, maxSpeed, maxFuel, consumption);
    }

    public void toggleTurbo() {
        turboOn = !turboOn;
        this.setConsumption(turboOn ? this.getConsumption() + 4 : this.getConsumption() - 4);

    }

    public void toggleAc() {
        acOn = !acOn;
        this.setConsumption(acOn ? this.getConsumption() + 2 : this.getConsumption() - 2);
    }

}
