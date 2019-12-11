package examPlanner;
//todo Check for duplicate adding

import java.util.ArrayList;

public class Subject implements BinarySave
{
  private String subjectName;
  private Room room;
  private ArrayList<Person> participants;
  //private int semester, ects, numberOfStudents;

  public Subject(String subjectName)
  {
    this.subjectName = subjectName;
    this.participants = new ArrayList<Person>();
    this.room = null;
  }

  public void addParticipant(Person person)
  {
    participants.add(person);
  }

  public void addParticipants(ArrayList<Person> people){
    for(Person person : people){
      participants.add(person);
    }
  }

  public void setRoom(Room room)
  {
    this.room = room;
  }


  public ArrayList<Person> getParticipants()
  {
    return participants;
  }

  @Override public String toString()
  {
    return subjectName;
  }
}
