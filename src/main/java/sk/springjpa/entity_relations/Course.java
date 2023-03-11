package sk.springjpa.entity_relations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "people_courses", // join table name
            joinColumns = @JoinColumn(name = "course_identification"), // column name in the join table
            inverseJoinColumns = @JoinColumn(name = "person_identification") // column name in the join table
    )
    private List<Person> people = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("Course [name='%s']", name);
    }

}
