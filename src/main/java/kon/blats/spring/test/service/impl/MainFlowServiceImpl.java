package kon.blats.spring.test.service.impl;

import kon.blats.spring.test.model.Feedback;
import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.service.MainFlowService;
import kon.blats.spring.test.service.StudentFeedbackService;
import kon.blats.spring.test.service.StudentValidationService;
import org.springframework.stereotype.Service;

/**
 * Created by kon on 25/3/2018.
 */
@Service
public class MainFlowServiceImpl implements MainFlowService {

    private StudentFeedbackService studentFeedbackService;
    private StudentValidationService studentValidationService;

    public MainFlowServiceImpl(StudentFeedbackService studentFeedbackService, StudentValidationService studentValidationService) {
        this.studentFeedbackService = studentFeedbackService;
        this.studentValidationService = studentValidationService;
    }

    @Override
    public Feedback getFeedbackIfAny(Student student) {
        Feedback feedback = new Feedback();
        boolean isAValidStudent = studentValidationService.isValid(student);

        if (isAValidStudent) {
            feedback = studentFeedbackService.getFeedback(student);
        } else {
            feedback.setFeedback("We can't provide any feedback, since the student is not valid");
        }

        return feedback;
    }
}
