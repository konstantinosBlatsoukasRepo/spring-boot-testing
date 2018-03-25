package kon.blats.spring.test.service;

import kon.blats.spring.test.model.Student;

/**
 * Created by kon on 25/3/2018.
 */
public interface StudentValidationService {
    boolean isValid(Student student);
}