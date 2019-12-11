package examPlanner;
//todo Check for duplicate adding (I, Bernardo made a equals method, don't know if it's what you wanted)

import java.util.ArrayList;

public class Subject
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

  public boolean isDuplicate(Object obj) {
    if (!(obj instanceof Subject)) { return false; }
    Subject other = (Subject) obj;
    if ( this.room.equals(other.room) && this.subjectName.equals(other.subjectName) && this.participants.equals(other.participants)) { return true; }
    return false;
  }
}
