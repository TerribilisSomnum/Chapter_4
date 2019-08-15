package by.etc.somnum;

//Создайте  класс  Test1  двумя  переменными.  Добавьте  метод  вывода  на  экран  и  методы  изменения  этих
//переменных. Добавьте метод, который находит сумму  значений этих  переменных, и  метод, который находит
//наибольшее значение из этих двух переменных.

import static java.lang.Math.max;

final class Test1 {

    double x;
    double y;

    public Test1(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public void printToScreen() {

        System.out.println("x = " + x + " y = " + y);
    }

    public void setX(double x) {

        this.x = x;
    }

    public void setY(double y) {

        this.y = y;
    }

    public double sum() {

        return this.y + this.x;
    }

    public double greatest() {

        return max(this.y, this.x);
    }
}

public class Classes_exe_1 {

    public static void main(String[] args) {

        Test1 myTest = new Test1(1, 2);
        myTest.printToScreen();
        myTest.setX(5);
        myTest.setY(10);
        myTest.printToScreen();
        System.out.println("Сумма цифр равна = " + myTest.sum());
        System.out.println("Наибольшее число из двух = " + myTest.greatest());
    }
}
