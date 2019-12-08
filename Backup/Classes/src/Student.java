public class Student {
    int id;
    String firstName, lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() { return firstName + " " + lastName; }
    public int getId() { return id; }
}
