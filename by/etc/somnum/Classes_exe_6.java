package by.etc.somnum;

/*
Составьте  описание  класса  для  представления  времени.  Предусмотрте  возможности установки  времени  и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых  значений полей  поле  устанавливается  в  значение  0.  Создать  методы  изменения  времени на
заданное количество часов, минут и секунд.
*/

import java.sql.Time;
import java.time.LocalDateTime;

final class MyTime {

    int hour;
    int minute;
    int second;

    public MyTime() {

        this.hour = LocalDateTime.now().getHour();
        this.minute = LocalDateTime.now().getMinute();
        this.second = LocalDateTime.now().getSecond();
    }

    public MyTime(int hour, int minute, int second) {

        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    public void setHour(int hour) {

        if (hour >= 0 && hour <= 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    public void setMinute(int minute) {

        if (minute >= 0 && minute <= 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public void setSecond(int second) {

        if (second >= 0 && second <= 60) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    @Override
    public String toString() {

        return hour + ":" + minute + ":" + second;
    }

    public void addHours(int count) {

        this.hour += count;
        this.hour %= 24;
    }

    public void addMinute(int count) {

        this.minute += count;
        int newHours = this.minute / 60;
        addHours(newHours);
        this.minute %= 60;
    }

    public void addSecond(int count) {

        this.second += count;
        int newMinutes = this.second / 60;
        addMinute(newMinutes);
        this.second %= 60;
    }
}

public class Classes_exe_6 {

    public static void main(String[] args) {

        MyTime time = new MyTime();
        System.out.print("Текущее время = " + time.toString());

        System.out.println("\n\nУвеличиваем часы на 20 часов: ");
        time.addHours(20);
        System.out.print("Время = " + time.toString());

        System.out.println("\n\nУвеличиваем минуты на 50 минут: ");
        time.addMinute(50);
        System.out.print("Время = " + time.toString());

        System.out.println("\n\nУвеличиваем секунды на 100 секунд: ");
        time.addSecond(100);
        System.out.print("Время = " + time.toString());
    }
}
