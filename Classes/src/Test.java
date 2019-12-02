import java.util.Scanner;

//This, with the TemporaryUI class, will be used for testing.
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("");

        TemporaryUI ui = new TemporaryUI();

        Subject subject = ui.createSubject();
        Date examDate = ui.createDate();
        Exam exam = ui.createExam(subject, examDate);

        Date examDate2 = new Date(16,1,2019,12,44);
        Subject subject2 = new Subject(1,10,"Michael");
        Exam exam2 = new Exam(subject2, examDate2, false, false);

        subject.addStudent(ui.createStudent());

        ExamList examList = new ExamList();
        examList.addExam(exam);
        examList.addExam(exam2);

        System.out.println(examList);
    }
}
