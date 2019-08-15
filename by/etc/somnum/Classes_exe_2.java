package by.etc.somnum;

// Создйте  класс  Test2  двумя  переменными.  Добавьте  конструктор  с  входными  параметрами.  Добавьте
//конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса.

final class Test2 {

    private int x;
    private int y;

    public Test2(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Test2() {

        this.x = 0;
        this.y = 0;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

}

public class Classes_exe_2 {

    public static void main(String[] args) {

        Test2 myTest2 = new Test2();
        System.out.println("x = " + myTest2.getX() + " y = " + myTest2.getY());
        myTest2.setX(4);
        myTest2.setY(8);
        System.out.println("x = " + myTest2.getX() + " y = " + myTest2.getY());
    }
}
