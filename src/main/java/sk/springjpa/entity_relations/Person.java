package sk.springjpa.entity_relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;

    @Column(name = "name") // optional if the name of the field is the same as the name of the column
    private String name;

    // Relationships

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    @ManyToMany(mappedBy = "people", fetch = FetchType.LAZY)
    private List<Course> courses = new ArrayList<>();

    // mappedBy is name of the field in the Address entity
    // cascade = CascadeType.ALL means that if we delete a Person, we also delete the Address
    // fetch = FetchType.LAZY means that we don't load the Address, when we load the Person

    @Override
    public String toString() {
        String result = String.format("Person [Name: %s]", name);

        if(bankAccount != null) {
            result += String.format(" [(O-O)accountNumber: %s, balance: %d]", bankAccount.getAccountNumber(), bankAccount.getBalance());
        } else {
            result += " [no bank account]";
        }

        if(cars.size() > 0) {
            result += " [(O-M)cars: ";
            for(Car car : cars) {
                result += String.format("%s %d, ", car.getBrand(), car.getYear());
            }
            result = result.replaceAll(", $", "");
            result += "]";
        } else {
            result += " [no cars]";
        }

        if(courses.size() > 0) {
            result += " [(M-M)courses: ";
            for(Course course : courses) {
                result += String.format("%s, ", course.getName());
            }
            result = result.replaceAll(", $", "");
            result += "]";
        } else {
            result += " [no courses]";
        }

        return result;
    }

    public void addCar(Car car) {
        if(cars.contains(car)) return;
        cars.add(car);
        car.setPerson(this);
    }

    public void addCourse(Course course) {
        if(courses.contains(course)) return;
        courses.add(course);
        course.getPeople().add(this);
    }
}
