public class Exam {
    private Subject subject;
    private Date examDate;
    private boolean isReexam, isWritten;


    public Exam(Subject subject, Date examDate, boolean isReexam, boolean isWritten) {
        this.subject = subject;
        this.examDate = examDate;
        this.isReexam = isReexam;
        this.isWritten = isWritten;
    }

    public Subject getSubject() { return subject; }
    public Date getExamDate() { return examDate; }
    public boolean isReexam() { return isReexam; }
    public boolean isWritten() { return isWritten; }

    public String toString () {
        String s = "Semester: " + subject.getSemester() + ", ECTS: " + subject.getEcts() + ", N. students: " + subject.getNumberOfStudents();
        s += ", Date: " + examDate.getDate() + ", Time: " + examDate.getTime() + " Lecturer: " + subject.getLecturer();
        return s;
    }
}
