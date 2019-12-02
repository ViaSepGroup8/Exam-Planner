import java.util.ArrayList;

public class Subject {
    private int semester, ects, numberOfStudents;
    private String lecturer;
    private ArrayList<Student> studentList;

    public Subject(int semester, int ects, String lecturer) {
        this.semester = semester;
        this.ects = ects;
        this.numberOfStudents = 0;
        this.lecturer = lecturer;
        this.studentList = new ArrayList<Student>();
    }

    public int getSemester() { return semester; }
    public int getEcts() { return ects; }
    public int getNumberOfStudents() { return numberOfStudents; }
    public String getLecturer() { return lecturer; }
    public Student getStudent(int index) { return studentList.get(index); }

    public void addStudent(Student student) {
        numberOfStudents ++;
        studentList.add(student);
    }
}
