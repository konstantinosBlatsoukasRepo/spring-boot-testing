package kon.blats.spring.test.controller;

import kon.blats.spring.test.model.Feedback;
import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.service.MainFlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kon on 25/3/2018.
 */
@Controller
public class FeedbackController {

    public final String FEEDBACK_NOT_FOUND = "We can't provide any feedback, since the student is not valid";

    private MainFlowService mainFlowService;

    public FeedbackController(MainFlowService mainFlowService) {
        this.mainFlowService = mainFlowService;
    }

    @RequestMapping(path = "/feedback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Feedback> getFeedback(@RequestBody Student student) {
        Feedback feedback = mainFlowService.getFeedbackIfAny(student);
        String feedbackValue = feedback.getFeedback();

        ResponseEntity<Feedback> responseEntity = ResponseEntity.ok().body(feedback);
        if (feedbackValue.equals(FEEDBACK_NOT_FOUND)) {
            responseEntity = ResponseEntity.badRequest().body(feedback);
        }

        return responseEntity;
    }

}
