import java.util.Scanner;

//This class is used to simplify testing but can, in the future, be used as a controller for the ui.
public class TemporaryUI {
    public TemporaryUI() {}

    public Student createStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the students id?");
        int id = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println("What is (his/her) first name?");
        String firstName = scan.nextLine();
        scan = new Scanner(System.in);
        System.out.println("What is (his/her) last name?");
        String lastName = scan.nextLine();
        Student st = new Student(id, firstName, lastName);
        return st;
    }

    public Exam createExam(Subject subject, Date date) {
        boolean isReexam, isWritten;
        Scanner scan = new Scanner(System.in);
        System.out.println("Is this exam a reexam (y/n)?");
        String input = scan.nextLine();
        if(input == "y") { isReexam = true; } else { isReexam = false; }
        System.out.println("Is this exam written (y/n)?");
        input = scan.nextLine();
        if(input == "y") { isWritten = true; } else { isWritten = false; }
        Exam ex = new Exam(subject, date, isReexam, isWritten);
        return ex;
    }
    public Exam createExam() {
        Subject subject = this.createSubject();
        Date date = this.createDate();
        boolean isReexam, isWritten;
        Scanner scan = new Scanner(System.in);
        System.out.println("Is this exam a reexam (y/n)?");
        String input = scan.nextLine();
        if(input == "y") { isReexam = true; } else { isReexam = false; }
        System.out.println("Is this exam written (y/n)?");
        input = scan.nextLine();
        if(input == "y") { isWritten = true; } else { isWritten = false; }
        Exam ex = new Exam(subject, date, isReexam, isWritten);
        return ex;
    }

    public Date createDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the day of the exam?");
        int day = scan.nextInt();
        System.out.println("What is the month of the exam?");
        int month = scan.nextInt();
        System.out.println("What is the year of the exam?");
        int year = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println("What is the hour of the exam?");
        int hour = scan.nextInt();
        System.out.println("What is the minute of the exam?");
        int minute = scan.nextInt();
        Date date = new Date(day, month, year, hour, minute);
        return date;
    }

    public Subject createSubject() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the semester of this subject?");
        int semester = scan.nextInt();
        System.out.println("How many ects does this subject give?");
        int ects = scan.nextInt();
        scan = new Scanner(System.in);
        System.out.println("What is the lecturer of this subject?");
        String lecturer = scan.nextLine();
        Subject subject = new Subject(semester, ects, lecturer);
        return subject;
    }
}
