package examPlanner;

public class Person implements BinarySave
{
  private Integer id;
  private String firstName;
  private String lastName;
  private String subjects;
  private boolean isTeacher;

  public Person(Integer id, String firstName, String lastName, String subjects)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.subjects = subjects;
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

  public String getSubjects()
  {
    return subjects;
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

  public void setSubjects(String subjects)
  {
    this.subjects = subjects.replace(" ", "");
  }

  @Override public boolean equals(Object obj)
  {
    if(obj instanceof Person){
      Person other = (Person)obj;
      return this.id == other.id;
    }
    return false;
  }

  @Override public String toString()
  {
    return "Person[" + id + " " + firstName + " " + lastName  + " " + subjects + "]";
  }
}