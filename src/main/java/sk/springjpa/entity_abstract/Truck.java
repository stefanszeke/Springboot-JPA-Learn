package sk.springjpa.entity_abstract;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import sk.springjpa.entity_relations.Goods;

@Entity
@Table(name = "vehicles")
public class Truck extends Vehicle {

    @Transient
    private Goods storage = null;

    public Truck() {
        super();
    }


    public Truck(String brand, int year, int maxSpeed, int maxFuel, int consumption) {
        super(brand, year, maxSpeed, maxFuel, consumption);
    }

    public void load(Goods storage) {
        if(this.storage != null) {
            System.out.println(this.getBrand() + ": Already loaded!");
            return;
        }
        this.storage = storage;
        this.setConsumption(this.getConsumption() + 10);
        System.out.println(this.getBrand() + ": Loaded " + storage);
    }

    public void unload() {
        if(this.storage == null) {
            System.out.println(this.getBrand() + ": Nothing to unload!");
            return;
        }
        System.out.println(this.getBrand() + ": Unloaded " + storage);
        this.setConsumption(this.getConsumption() - 10);
        this.storage = null;
    }
}

