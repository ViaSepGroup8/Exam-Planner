package examPlanner;

import java.util.ArrayList;

public class Event
{
  private MyDate date;
  private ArrayList<Person> participants;

  public void setParticipants(ArrayList<Person> participants)
  {
    this.participants = participants;
  }

  public Event(MyDate date)
  {
    this.date = date;
    this.participants = new ArrayList<Person>();
  }

  @Override public String toString()
  {
    return "Event[" + date + "]";
  }

  public ArrayList<Person> getParticipants()
  {
    return participants;
  }

  public void removeParticipant(Person person){
    participants.remove(person);
  }

  public void addParticipant(Person person){
    participants.add(person);
  }

  public MyDate getDate()
  {
    return date;
  }

  public boolean hasCommonParticipant(ArrayList<Person> other){
    for (Person thisPerson: participants)
    {
      for (Person otherPerson: other)
      {
        if(thisPerson.equals(otherPerson)){
          return true;
        }
      }
    }
    return false;
  }

  public boolean collision(MyDate other){
    return this.equals(other);
  }
}