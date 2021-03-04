package trash;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date(2020 - 1900, 10 - 1, 20, 10, 30);
        Time time = new Time(0, 40, 0);
        Time time1 = new Time(1, 30, 0);
        Date d = new Date(time.getTime());
        Date date1 = new Date(0 - 1900, 0 - 1, 0, 0, 40);
        Date date2 = new Date(date.getTime() + date1.getTime());
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestamp1 = new Timestamp(date1.getTime());
        Timestamp timestamp2 = new Timestamp(timestamp.getTime() + timestamp1.getTime());
        Time time2 = new Time(time.getTime() + time1.getTime());
        System.out.println(date);
        Timestamp timestamp3 = new Timestamp(date.getTime() + 2400000);
        System.out.println(timestamp3);
        int year, month, day, hour, min;


    }
}
