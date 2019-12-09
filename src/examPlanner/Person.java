package examPlanner;

public class Person
{
  private Integer id;
  private String firstName;
  private String lastName;

  public Person(Integer id, String firstName, String lastName)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Person(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  @Override public boolean equals(Object obj)
  {
    if(obj instanceof Person){
      Person other = (Person)obj;
      return this.id == other.id;
    }
    return false;
  }
}