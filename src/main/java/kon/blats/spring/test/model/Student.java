package kon.blats.spring.test.model;

/**
 * Created by kon on 25/3/2018.
 */
public class Student {
    private String name;
    private int studentId;
    private int averageGrade;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
