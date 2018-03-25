package kon.blats.spring.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kon.blats.spring.test.model.Feedback;
import kon.blats.spring.test.model.Student;
import kon.blats.spring.test.service.MainFlowService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kon on 25/3/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FeedbackController.class)
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainFlowService mainFlowService;

    @Autowired
    private ObjectMapper objectMapper;

    Feedback emptyFeedback;
    Feedback nonEmptyFeedback;
    Student student;

    @Before
    public void setUp() {
        student = new Student();

        emptyFeedback = new Feedback();
        emptyFeedback.setFeedback("We can't provide any feedback, since the student is not valid");

        nonEmptyFeedback = new Feedback();
        nonEmptyFeedback.setFeedback("Really good job! Keep working like that!");
    }

    @Test
    public void failedToRetrieveStudentFeedback() throws Exception {
        given(mainFlowService.getFeedbackIfAny(any())).willReturn(emptyFeedback);

        mockMvc.perform(post("/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void successfulRetrievalStudentFeedback() throws Exception {
        given(mainFlowService.getFeedbackIfAny(any())).willReturn(nonEmptyFeedback);

        mockMvc.perform(post("/feedback")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(student)))
                .andExpect(status().isOk());
    }

}