package kon.blats.spring.test.repository;

import kon.blats.spring.test.model.Student;

import java.util.Optional;

/**
 * Created by kon on 25/3/2018.
 */
public interface StudentRepository {
    Optional<Student> getStudent(int studentId);
}
