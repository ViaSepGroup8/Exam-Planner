package examPlanner;

public class Room
{
  private String name;
  private int capacity;

  public Room(String name, int capacity)
  {
    this.name = name;
    this.capacity = capacity;
  }

  @Override public String toString()
  {
    return "Room(" + name + ")";
  }

  @Override public boolean equals(Object obj)
  {
    if(obj instanceof Room){
      Room other = (Room) obj;
      return this.name.equals(other.name) && this.capacity == other.capacity;
    }
    return false;
  }
}
