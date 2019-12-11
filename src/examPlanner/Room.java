package examPlanner;

public class Room implements BinarySave
{
  private String name;
  private int capacity;
  private String subjects;
  private String functionalities;

  public Room(String name, int capacity, String subjects,
      String functionalities)
  {
    this.name = name;
    this.capacity = capacity;
    this.subjects = subjects;
    this.functionalities = functionalities;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public void setCapacity(int capacity)
  {
    this.capacity = capacity;
  }

  public String getFunctionalities()
  {
    return functionalities;
  }

  public void setFunctionalities(String functionalities)
  {
    this.functionalities = functionalities;
  }

  public String getSubjects()
  {
    return subjects;
  }

  public void setSubjects(String subjects)
  {
    this.subjects = subjects;
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
