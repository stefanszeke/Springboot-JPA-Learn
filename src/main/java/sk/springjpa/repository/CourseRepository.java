package sk.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.springjpa.entity_relations.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
