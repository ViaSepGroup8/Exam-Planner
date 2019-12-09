package examPlanner;

public class Exam extends Event{
  private Subject subject;
  private Room room;
  private boolean isReexam;
  private boolean isWritten;
  private String time;

  public Exam(MyDate date, Subject subject, Room room, boolean isReexam,
      boolean isWritten, String time)
  {
    super(date);
    this.subject = subject;
    this.room = room;
    this.isReexam = isReexam;
    this.isWritten = isWritten;
    this.time = time;
    setParticipants(subject.getParticipants());
  }

  public Room getRoom()
  {
    return room;
  }

  @Override public String toString()
  {
    return super.toString() + "{" + subject + "}";
  }
}