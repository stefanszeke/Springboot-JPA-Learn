package sk.springjpa.entity_relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    // mappedBy is name of the field in the Address entity
    // cascade = CascadeType.ALL means that if we delete a Person, we also delete the Address
    // fetch = FetchType.LAZY means that we don't load the Address, when we load the Person
}
