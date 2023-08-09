package aop;

public class Student {
    String fullName;
    int course;
    double averageGrade;

    public Student(String fullName, int course, double averageGrade) {
        this.fullName = fullName;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", course=" + course +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
