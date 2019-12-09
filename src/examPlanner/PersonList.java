package examPlanner;

import java.util.ArrayList;

public class PersonList
{
  private String name;
  private ArrayList<Student> participants;

  public PersonList(String name)
  {
    this.name = name;
    this.participants = new ArrayList<Student>();
  }

  public ArrayList<Student> getParticipants()
  {
    return participants;
  }

  public void addParticipant(Student student){
    participants.add(student);
  }

  @Override public String toString()
  {
    return "Name: " + name + " [" + participants +"]";
  }
}
