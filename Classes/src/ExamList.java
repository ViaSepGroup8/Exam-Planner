import java.util.ArrayList;

public class ExamList {
    private ArrayList<Exam> examList;

    public ExamList() { examList = new ArrayList<Exam>(); }
    public void addExam( Exam newExam ) { examList.add(newExam); }

    public String toString() {
        String s = "";
        for(int i = 0; i < examList.size(); i++) {
            s += examList.get(i).toString() + "\n";
        }
        return s;
    }

    //Save to a file
    //Read from a file
    //Save to a pdf
}
