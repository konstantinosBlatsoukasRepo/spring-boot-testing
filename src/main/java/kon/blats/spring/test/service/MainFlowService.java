package kon.blats.spring.test.service;

import kon.blats.spring.test.model.Feedback;
import kon.blats.spring.test.model.Student;

/**
 * Created by kon on 25/3/2018.
 */
public interface MainFlowService {
    Feedback getFeedbackIfAny(Student student);
}
