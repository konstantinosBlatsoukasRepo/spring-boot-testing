package kon.blats.spring.test.model;

/**
 * Created by kon on 25/3/2018.
 */
public class Feedback {
    private Student student;
    private String feedback;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
