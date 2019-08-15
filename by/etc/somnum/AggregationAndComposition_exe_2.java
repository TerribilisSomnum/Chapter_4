package by.etc.somnum;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
// менять колесо, вывести на консоль марку автомобиля.

class Engine{

}

class Wheel {

   private int wheelNumber;

    public int getWheelNumber() {
        return wheelNumber;
    }

    public void setWheelNumber(int wheel) {
        this.wheelNumber = wheel;
    }

    public Wheel(int wheel){
        this.wheelNumber = wheel;
    }
}

class Car{

    private Wheel firstWheel;
    private Wheel secondWheel;
    private Wheel thirdWheel;
    private Wheel fourWheel;
    private Engine engine;
    private String carMake;

    public String getCarMake() { return carMake; }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public Car(String carMake){

        this.carMake = carMake;
        this.firstWheel = new Wheel(1);
        this.secondWheel = new Wheel(2);
        this.thirdWheel = new Wheel(3);
        this.fourWheel = new Wheel(4);
    }

    @Override
    public String toString() {
        return getCarMake();
    }

    public void start() {
        System.out.println("Поехали!");
    }

    public void refuel() {
        System.out.println("Заправились!");
    }

    public void changeWheel() {
        System.out.println("Колесо заменено!");
    }

    public void printCarMakeToScreen() {
        System.out.println(this.toString());
    }
}

public class AggregationAndComposition_exe_2 {

    public static void main(String[] args) {

    }
}
