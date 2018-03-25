package kon.blats.spring.test.service.impl;

import kon.blats.spring.test.model.Feedback;
import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.service.StudentFeedbackService;
import org.springframework.stereotype.Service;

/**
 * Created by kon on 25/3/2018.
 */
@Service
public class StudentFeedbackServiceImpl implements StudentFeedbackService {

    @Override
    public Feedback getFeedback(Student student) {
        String feed = null;
        String name = student.getName();

        switch (name) {
            case  "James" :
                feed = "There is a a lot room for improvement! Work harder!";
                break;
            case  "Kostas": feed = "Congrats! you are the perfect student!";
        }

        Feedback feedback = new Feedback();
        feedback.setFeedback(feed);
        feedback.setStudent(student);

        return feedback;
    }
}
