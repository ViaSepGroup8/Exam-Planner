package examPlanner;

public class Student extends Person
{
  private String studentClass;

  public Student(Integer id, String firstName, String lastName,
      String studentClass)
  {
    super(id, firstName, lastName);
    this.studentClass = studentClass;
  }

  public Student(Integer id, String studentClass)
  {
    super(id);
    this.studentClass = studentClass;
  }
}