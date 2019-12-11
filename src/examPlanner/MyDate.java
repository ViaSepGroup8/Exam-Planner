package examPlanner;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate implements BinarySave
{
  private int month, day, year;

  public MyDate(int day, int month, int year){
    this.set(day, month, year);
  }

  public MyDate(){
    Calendar now = GregorianCalendar.getInstance();
    this.set(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH) + 1, now.get(Calendar.YEAR));
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public void set(int day, int month, int year){
    if (year < 0)
      year=-year;
    this.year = year;

    if (month<1)
      month = 1;
    if (month>12)
      month = 12;
    this.month = month;

    if (day < 1)
      day = 1;
    if (day>this.numberOfDaysInMonth(month))
      day = numberOfDaysInMonth(month);
    this.day = day;
  }

  @Override public String toString()
  {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

  public String getMonthName(){
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    return monthNames[this.month-1];
  }

  public boolean isLeapYear()
  {
    if(this.year%400==0 || this.year%4 == 0 && this.year%100 != 0)
      return true;
    else
      return false;
  }

  int numberOfDaysInMonth(int monthNumber){
    switch (monthNumber){
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        return 31;
      case 4: case 6: case 9: case 11:
        return 30;
      case 2:
        if(this.isLeapYear())
          return 29;
        else return 28;
      default:return -1;
    }
  }

  public void stepForwardOneDay(){
    if(this.day == this.numberOfDaysInMonth(this.month)){
      this.day = 1;
      if(this.month == 12){
        this.month = 1;
        this.year += 1;
      }
      else{
        this.month+=1;
      }
    }
    else{
      this.day += 1;
    }
  }

  @Override public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
      return false;

    MyDate other = (MyDate) obj;
    if (other.day == this.day && other.month == this.month && other.year == this.year)
      return true;
    else
      return false;
  }

  public static int convertToMonthNumber(String monthName){
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    monthName = monthName.toLowerCase();

    for (int i = 0; i < monthNames.length; i++)
    {
      if (monthName.equals(monthNames[i].toLowerCase()))
        return i+1;
    }

    return -1;
  }

  public void stepForward(int days){
    for (int i = 0; i < days; i++)
    {
      this.stepForwardOneDay();
    }
  }

  public boolean isBefore(MyDate other)
  {
    if(this.year<other.year)
      return true;
    else if (this.year == other.year){
      if(this.month<other.month)
        return true;
      else if (this.month == other.month){
        // TODO: 11/28/19 changed again!
        //WARNING CHANGE TO: (this.day<=other.day) IF YOU WANT TO RETURN TRUE FOR THE SAME DAY!
        if(this.day<other.day)
          return true;
        else
          return false;
      }else
        return false;
    }else{
      return false;
    }
  }

  public int yearsBetween(MyDate other){
    if(this.isBefore(other)){
      int numberOfDaysInBetween = Math.abs(this.year-other.year);
      boolean dayMonthBefore;
      //System.out.println("First: " + this + " " + "second: " + other);

      if(this.month<other.month)
        dayMonthBefore = true;
      else if (this.month == other.month){
        if(this.day<other.day)
          dayMonthBefore = true;
        else
          dayMonthBefore = false;
      }else
        dayMonthBefore = false;

      if (!dayMonthBefore)
        numberOfDaysInBetween-=1;

      return numberOfDaysInBetween;
    }
    else if(this.equals(other)){
      return 0;
    }
    else {
      return other.yearsBetween(this);
    }
  }

  public MyDate copy(){
    return new MyDate(day, month, year);
  }

  public int daysBetween(MyDate other){
    if(this.isBefore(other)){
      int dayCounter = 0;
      while(this.isBefore(other)){
        dayCounter++;
        this.stepForwardOneDay();
      }
      return dayCounter;
    }
    else if(this.equals(other))
      return 0;
    else return other.daysBetween(this);
  }

  public static MyDate now(){
    return new MyDate();
  }
}
