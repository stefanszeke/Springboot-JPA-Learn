package sk.springjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.springjpa.Service.VehicleService;
import sk.springjpa.entity_abstract.SportsCar;
import sk.springjpa.entity_abstract.Truck;
import sk.springjpa.entity_abstract.Vehicle;
import sk.springjpa.entity_relations.BankAccount;
import sk.springjpa.entity_relations.Car;
import sk.springjpa.entity_relations.Course;
import sk.springjpa.entity_relations.Person;

import java.util.List;

@Component
public class DemoApp {

    @Autowired
    private VehicleService vehicleService;

    public void runRelations() {
        System.out.println("\n ...\n");

        Person person = new Person();
        person.setName("jack");

        Person person2 = new Person();
        person2.setName("John");

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("465");
        bankAccount.setPerson(person);
        bankAccount.setBalance(1000);
        person.setBankAccount(bankAccount);

        Car car1 = new Car();
        car1.setBrand("Audi");
        car1.setYear(2005);
        Car car2 = new Car();
        car2.setBrand("Seat");
        car2.setYear(2003);
        person.addCar(car1);
        person.addCar(car2);

        Course course1 = new Course();
        course1.setName("Programming");
        Course course2 = new Course();
        course2.setName("Cooking");

        person.addCourse(course1);
        person.addCourse(course2);



        System.out.println(person);
        System.out.println(person2);



        System.out.println("\n ...\n");
    }

    public void runAbstract() {
        System.out.println("\n ...\n");

        vehicleService.addVehicle(new SportsCar("Seat", 2000, 110, 100, 5));
        vehicleService.addVehicle(new SportsCar("Audi", 2000, 150, 100, 5));
        vehicleService.addVehicle(new SportsCar("BMW", 2000, 120, 100, 5));
        vehicleService.addVehicle(new SportsCar("Ferrari", 2000, 200, 100, 5));
        vehicleService.addVehicle(new SportsCar("Porche", 2000, 220, 100, 5));
        vehicleService.addVehicle(new SportsCar("Skoda", 2000, 130, 100, 5));
        vehicleService.addVehicle(new SportsCar("Bugatti", 2000, 300, 100, 5));
        vehicleService.addVehicle(new Truck("Volvo", 2000, 80, 150, 10));
        vehicleService.addVehicle(new Truck("Scania", 2000, 100, 150, 10));
        vehicleService.addVehicle(new Truck("Avia", 2000, 95, 150, 10));
        vehicleService.addVehicle(new Truck("Tatra", 2000, 70, 150, 10));
        vehicleService.addVehicle(new Truck("Citroen", 2000, 75, 150, 10));
        vehicleService.addVehicle(new Truck("Ford", 2000, 80, 150, 10));
        vehicleService.addVehicle(new Truck("Opel", 2000, 82, 150, 10));

//        vehicleService.deleteByIdE(1L);
//        vehicleService.deleteVehicleById(3L);

        System.out.println("order by speed Desc");
        vehicleService.printAllVehiclesOrderBySpeedE();
        System.out.println();

        System.out.println("order by speed Asc");
        List<Vehicle> vehicleList = vehicleService.printAllVehiclesOrderBySpeed();
        vehicleList.forEach(System.out::println);
        System.out.println();

        System.out.println("speed between 100 and 140");
        List<Vehicle> vehicleList2 = vehicleService.findAllByMaxSpeedBetween(100, 140);
        vehicleList2.forEach(System.out::println);

        System.out.println();

        System.out.println("starting with B");
        List<Vehicle> vehicleList3 = vehicleService.findAllByBrandStartingWith("B");
        vehicleList3.forEach(System.out::println);

        System.out.println();

        System.out.println("find Top10 ByMaxSpeed Between Order ByBrand Desc(100,200)");
        List<Vehicle> vehicleList4 = vehicleService.findTop10ByMaxSpeedBetweenOrderByBrandDesc(100,200);
        vehicleList4.forEach(System.out::println);

        System.out.println("\n ...\n");
    }

}
