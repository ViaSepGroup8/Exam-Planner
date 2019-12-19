package examPlanner;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.codec.binary.Hex;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Model implements BinarySave, CSVsave
{
  private ArrayList<Room> rooms;
  private ArrayList<Subject> subjects;
  private ArrayList<Exam> exams;
  private ArrayList<Person> people;

  private MyDate examinationStartDate;
  private MyDate examinationEndDate;

  public Model()
  {
    rooms = new ArrayList<Room>();
    subjects = new ArrayList<Subject>();
    exams = new ArrayList<Exam>();
    people = new ArrayList<Person>();

    examinationStartDate = new MyDate(10,1,2020);
    examinationEndDate = new MyDate(20, 1, 2020);
  }

  public void setExaminationStartDate(MyDate examinationStartDate)
  {
    this.examinationStartDate = examinationStartDate;
  }

  public void setExaminationEndDate(MyDate examinationEndDate)
  {
    this.examinationEndDate = examinationEndDate;
  }

  public void loadSampleData(){
    //this method is intended to fill some date to the program.
    //mainly used in debugging should be omitted in production version.

    //Add the students
    people.add(new Student(294000, "Juan", "Trebolle", "rwd"));
    people.add(new Student(294322, "Jan", "Lishak", "rwd"));

    people.add(new Student(3232, "Ju23an", "Trebo42lle", "rwd"));
    people.add(new Student(222, "Ja24n", "L42ishak", "rwd"));


    //Create the rooms as well
    rooms.add(new Room("X301", 40, "rwd", "hdmi"));
    rooms.add(new Room("X302", 20, "sse", "vga"));
    rooms.add(new Room("X303", 70, "", "hdmi, vga"));

    //Add Teachers
    Person astrid = new Teacher(11, "Astrid", "xxx", "rwd");
    Person michael = new Teacher(22, "Michal", "xxx", "rwd");

    people.add(astrid);
    people.add(michael);

    Exam newExam;
    newExam = new Exam(
        new MyDate(1,1,1),
        "SSE",
        new Room("toDoRoom",2,"rwd", "hdmi"),
        "Michal",
        "o",
        "w",
        "10",
        "noone");

    exams.add(newExam);
  }

  public ArrayList<Person> getPeople()
  {
    return people;
  }

  public void setPeople(ArrayList<Person> people)
  {
    this.people = people;
  }

  public ArrayList<Room> getRooms()
  {
    return rooms;
  }

  public void setRooms(ArrayList<Room> rooms)
  {
    this.rooms = rooms;
  }

  //This method returns all subjects in an array of Strings. Each student has a string with subjects separated by commas.
  //Firstly we create an empty list called "allSubjects". The algorithm goes through all the students and looks at their subjects Strings.
  //Than splits every Subjects String by comma, so that we have Multiple Strings each representing one subject of the student.
  //We add each of the newly created single subject String to the list "allSubjects, if it is not already in there.
  //Lastly we end up with a list of all subjects.

  public ArrayList<String> getAllSubjects(){
    ArrayList<String> allSubjects = new ArrayList<String>();
    for(Person person : getPeople()){
      for(String subject : person.getSubjects().split(",")){
        if(!(allSubjects.contains(subject))){
          if(!subject.equals(""))
          allSubjects.add(subject);
        }
      }
    }
    return allSubjects;
  }

  public void setExams(ArrayList<Exam> exams)
  {
    this.exams = exams;
  }

  public ArrayList<Exam> getExams()
  {
    return exams;
  }

  //Firstly we create an empty list called "freeDates" where we will later add all the freeDates.
  //To find a free date for an exam we firstly need to know which subject and what room we want to have the exam in.
  //A Free Date is such date that: 1. does not use the same room at that specific date
  //                               2. There is no exam with same people at that specific date.
  //For each Date in the examination period the algorithm checks if at that date there is some exam.
  //If there are no exams at that date. The date is "free" and we can add it to our list of free dates.
  //If there is some exam on that date we need to check if it collides with our exam. To check it we it needs to meet our two requirements.
  //The exam cannot use the same room as we want or any of the people that are taking that exam cannot be taking our exam. For the second requirement we can use function subjectCollision().
  //If both requirement are met the exam does not collide with the one we want to create so we can add the date to the list of free dates.
  //When we check all the dates, we end up with a list of all the dates that are possible for the exam we want to create.
  public ArrayList<MyDate> getAllFreeDates(String subject, Room room)
  {
    ArrayList<MyDate> freeDates = new ArrayList<MyDate>();

    for(MyDate date : getAllDates()){
      boolean collision = false;
      for(Exam exam : getExams()){
        if(exam.getDate().equals(date)){
          if(exam.getRoom().equals(room) || subjectCollision(exam.getSubject(), subject))
          {
            collision = true;
            break;
          }
        }
      }
      if(!collision)
        freeDates.add(date);
    }

    return freeDates;
  }

  //If there exists at least one persons that has both of the subjects the subjects collide.
  //At first we need two subjects that we want to check. We will call them subject1 and subject2.
  //Than we can go through every single student and check if he/she has both of them.
  //If we find at least one such students that has both subject1 and subject2 than does two subjects collide.
  private boolean subjectCollision(String subject1, String subject2)
  {
    for(Person person : getPeople()){
      if(person.getSubjectsList().contains(subject1) && person.getSubjectsList().contains(subject2))
        return true;
    }
    return false;
  }

  //This method return a list of all dates that are within the examination period.
  public ArrayList<MyDate> getAllDates(){
    ArrayList<MyDate> dates = new ArrayList<MyDate>();
    MyDate examinationStartDateCopy = examinationStartDate.copy();

    while (examinationStartDateCopy.isBefore(examinationEndDate) || examinationStartDateCopy.equals(examinationEndDate)){
      dates.add(examinationStartDateCopy.copy());
      examinationStartDateCopy.stepForwardOneDay();
    }

    return dates;
  }

  @Override public void saveToCSV()
  {
    String StringCSV[] = new String[exams.size() + 1];
    StringCSV[0] = "Subject,Room,Date,Teacher,Ordinary/Reexam,Oral/Writen,ECTS,External examinor";
    for (int i = 0; i < exams.size(); i++)
    {
      StringCSV[i+1] = exams.get(i).toString();
    }

    try
    {
      CSVsave.CSVSave("table.csv", StringCSV);
    }
    catch (Exception e)
    {
      System.out.println("Cannot write to file table.csv");
      return;
    }
  }

  public void uploadToFTP(){
    FTPClient client = new FTPClient();
    FileInputStream fis = null;

    try
    {
      client.connect("files.000webhost.com");
      client.login("via-jd-sep", new String(Hex.decodeHex("7373657375636b73".toCharArray()), "UTF-8"));
      // Create an InputStream of the file to be uploaded

      String filename = "table.csv";
      fis = new FileInputStream(filename);
      client.storeFile("public_html/" + filename, fis);
      client.logout();
    }catch (Exception e)
    {
      System.out.println("Something went wrong!");
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if (fis != null) {
          fis.close();
        }
        client.disconnect();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}