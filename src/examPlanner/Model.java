package examPlanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Model implements BinarySave
{
  private ArrayList<Room> rooms;
  private ArrayList<Subject> subjects;
  private ArrayList<Event> schedule;
  private ArrayList<Person> people;

  public Model(MyDate examinationStartDate, MyDate examinationEndDate)
  {
    rooms = new ArrayList<Room>();
    subjects = new ArrayList<Subject>();
    schedule = new ArrayList<Event>();
    people = new ArrayList<Person>();

    //Add all possible dates of examination to the schedule.
    while (examinationStartDate.isBefore(examinationEndDate)){
      schedule.add(new Event(examinationStartDate));
      examinationStartDate.stepForwardOneDay();
    }
  }

  public void loadSampleData(){
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


//    //Create subjects
//    Subject SDJ1 = new Subject("SDJ1");
//    SDJ1.addParticipant(students.get(0));
//    SDJ1.addParticipant(students.get(1));
//    SDJ1.addParticipant(students.get(2));
//    SDJ1.addParticipant(teachers.get(1)); //select from list
//    SDJ1.setRoom(rooms.get(0));//select from list
//    subjects.add(SDJ1);
//
//    Subject SSE1 = new Subject("SSE1");
//    SDJ1.addParticipant(students.get(0));
//    SDJ1.addParticipant(students.get(1));
//    SDJ1.addParticipant(students.get(2));
//    SDJ1.addParticipant(teachers.get(0)); //select from list
//    SDJ1.setRoom(rooms.get(1));//select from list
//    subjects.add(SSE1);
//
//    Subject SDJ2 = new Subject("SDJ2");
//    SDJ1.addParticipant(students.get(3));
//    SDJ1.addParticipant(students.get(4));
//    SDJ1.addParticipant(students.get(5));
//    SDJ1.addParticipant(teachers.get(1)); //select from list
//    SDJ2.setRoom(rooms.get(2));//select from list
//    subjects.add(SDJ2);
  }

  public void createExam()
  {
    //Rules priority
    //Student cannot be at two exams at the same time

    Scanner keyboard = new Scanner(System.in);

    Room examRoom;
    Subject examSubject;
    MyDate examDate;
    ArrayList<Room> possibleRooms = (ArrayList<Room>) rooms.clone();
    ArrayList<Event> possibleDates = new ArrayList<Event>();

    System.out.println("Select Subject: ");
    for (int i = 0; i < subjects.size(); i++)
    {
      System.out.print(i + ": " + subjects.get(i) + " ");
    }
    examSubject = subjects.get(keyboard.nextInt());

    System.out.println("Select Room: ");
    for (int i = 0; i < possibleRooms.size(); i++)
    {
      System.out.print(i + ": " + possibleRooms.get(i) + " ");
    }
    System.out.print(": ");
    examRoom = rooms.get(keyboard.nextInt());

    for (Event event: schedule)
    {
      if(event instanceof Exam){
        //there is an exam on that date, we need to check if they don't have common participants or use the same room.
        if(event.hasCommonParticipant(examSubject.getParticipants()) || ((Exam) event).getRoom().equals(examRoom)){
          continue;
        }
        possibleDates.add(event);
      }
    }

    System.out.println("Select Date: ");
    for (int i = 0; i < possibleDates.size(); i++)
    {
      System.out.print(i + ": " + possibleDates.get(i) + "\n");
    }
    Event event = possibleDates.get(keyboard.nextInt());
    examDate = event.getDate();

    Exam newExam = new Exam(examDate, examSubject, examRoom, false, true, "12:00");
    event = newExam;
    //System.out.println(newExam);

//    boolean elementIsLast = true;
//    for (int i = 0; i < schedule.size(); i++)
//    {
//      if(examStartDate.isBefore(schedule.get(i).getStartDateTime())){
//        //System.out.println("Found!");
//        schedule.add(i, newExam);
//        elementIsLast = false;
//        break;
//      }
//    }
//
//    if(elementIsLast){
//      schedule.add(newExam);
//    }

    System.out.println("Actual Schedule:");
    for (int i = 0; i < schedule.size(); i++)
    {
      if(schedule.get(i)instanceof Exam){
        System.out.print(i + ": " + schedule.get(i) + "\n");
      }
    }
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

  public ArrayList<String> getAllSubjects(){
    ArrayList<String> allSubjects = new ArrayList<String>();
    for(Person person : getPeople()){
      for(String subject : person.getSubjects().split(",")){
        if(!(allSubjects.contains(subject))){
          allSubjects.add(subject);
        }
      }
    }
    return allSubjects;
  }

  public void deleteExam()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Select Exam to delete Room: ");
    for (int i = 0; i < schedule.size(); i++)
    {
      if (schedule.get(i) instanceof Exam)
        System.out.print(i + ": " + schedule.get(i) + "\n");
    }
    System.out.print(": ");
    schedule.remove(keyboard.nextInt());
  }
}