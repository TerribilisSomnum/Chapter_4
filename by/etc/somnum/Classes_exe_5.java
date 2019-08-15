package by.etc.somnum;

/*
Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
на  единицу  в  заданном  диапазоне.  Предусмотрите инициализацию  счетчика  значениями  по  умолчанию  и
произвольными  значениями. Счетчик  имеет  методы  увеличения  и  уменьшения  состояния,  и  метод
позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */

final class MyСounter {

    private int x;
    private int botton;
    private int top;

    public MyСounter(int bottonLimit, int topLimit) {

        this.botton = bottonLimit;
        this.top = topLimit;
        this.x = ((bottonLimit + topLimit) / 2);
    }

    public MyСounter(int bottonLimit, int topLimit, int x) {

        this.botton = bottonLimit;
        this.top = topLimit;
        if (x > bottonLimit || x < topLimit) {
            this.x = x;
        } else {
            this.x = ((bottonLimit + topLimit) / 2);
        }
    }

    public void increment() {

        if (this.x < top) {
            this.x++;
        }
    }

    public void dincrement() {

        if (this.x > botton) {
            this.x--;
        }
    }

    public int getCounter() {

        return this.x;
    }
}

public class Classes_exe_5 {

    public static void main(String[] args) {

        MyСounter someCount = new MyСounter(5, 10);
        System.out.println("Создан счетчик с границей от 5 до 10: ");

        System.out.println("Его значение равно: " + someCount.getCounter());

        System.out.println("\nЕго значение увеличиваем на 1: ");
        someCount.increment();
        System.out.println("Его значение равно: " + someCount.getCounter());

        System.out.println("\nЕго значение увеличиваем на 5: ");
        for (int i = 0; i < 5; i++) {
            someCount.increment();
        }
        System.out.println("Его значение равно: " + someCount.getCounter());

        System.out.println("\nЕго значение уменьшим на 20: ");
        for (int i = 0; i < 20; i++) {
            someCount.dincrement();
        }
        System.out.println("Его значение равно: " + someCount.getCounter());
    }
}
