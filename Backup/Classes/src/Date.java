public class Date {
    public int day, month, year, hour, minute;

    public Date(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public String getDate() { return this.day + " / " + this.month + " / " + this.year; }
    public String getTime() { return this.hour + " : " + this.minute; }
}
