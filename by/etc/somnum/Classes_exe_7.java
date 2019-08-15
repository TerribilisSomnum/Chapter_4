package by.etc.somnum;

//Описать  класс,  представляющий  треугольник.  Предусмотреть  методы  для  создания объектов,  вычисления
//площади, периметра и точки пересечения медиан.

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

final class Point {

    double x;
    double y;

    public Point() {

        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {

        return "x = " + x + " " + "y = " + y;
    }

    public Point(double x, double y) {

        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {

        return sqrt((pow((this.x - p.x), 2)) + ((pow((this.y - p.y), 2))));
    }
}

final class Triangle {

    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c) {

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {

        return ((1.0 / 2.0) * Math.abs(((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y))));
    }

    public double perimeter() {

        double ab = this.a.distance(this.b);
        double bc = this.b.distance(this.c);
        double ca = this.c.distance((this.a));

        return ab + bc + ca;
    }

    public Point calculateCentroid() {

        return new Point(((this.a.x + this.b.x + this.c.x) / 3), ((this.a.y + this.b.y + this.c.y) / 3));
    }
}

public class Classes_exe_7 {

    public static double userInput() {

        Scanner reader = new Scanner(System.in);
        double number = reader.nextDouble();
        return number;
    }

    public static void main(String[] args) {

        System.out.print("Введите x1: ");
        double x1 = userInput();
        System.out.print("Введите y1: ");
        double y1 = userInput();
        System.out.print("Введите x2: ");
        double x2 = userInput();
        System.out.print("Введите y2: ");
        double y2 = userInput();
        System.out.print("Введите x3: ");
        double x3 = userInput();
        System.out.print("Введите y3: ");
        double y3 = userInput();

        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);

        Triangle abc = new Triangle(a, b, c);

        System.out.println("Площадь треугольника = " + abc.area());
        System.out.println("Периметр треугольника = " + abc.perimeter());
        System.out.println("Центрид треугольника: " + abc.calculateCentroid());
    }
}
