package kon.blats.spring.test.repository.impl;

import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by kon on 25/3/2018.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Optional<Student> getStudent(int studentId) {
        Student student = null;

        if (studentId == 10) {
            student = new Student();
            student.setStudentId(10);
            student.setName("Kostas");
            student.setAverageGrade(20);
        }

        if (studentId == 12) {
            student = new Student();
            student.setStudentId(12);
            student.setName("James");
            student.setAverageGrade(15);
        }

        Optional<Student> studentOptional = Optional.empty();
        if (student != null) {
            Optional.of(student);
        }
        return studentOptional;
    }

}
