package kon.blats.spring.test.service.impl;

import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.repository.StudentRepository;
import kon.blats.spring.test.service.StudentValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by kon on 25/3/2018.
 */
@Service
public class StudentValidationServiceImpl implements StudentValidationService {

    private StudentRepository studentRepository;

    public StudentValidationServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean isValid(Student student) {
        boolean isValid = false;

        int studentId = student.getStudentId();
        Optional<Student> repoStudent = studentRepository.getStudent(studentId);

        if (repoStudent.isPresent()) {
            student = repoStudent.get();
            String repoStudentName = student.getName();
            String givenName = student.getName();
            isValid = repoStudentName.equals(givenName);
        }

        return isValid;
    }
}
