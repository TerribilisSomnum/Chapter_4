package by.etc.somnum;

/*
Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод  toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.

Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
*/

import java.time.LocalDateTime;

class Airline {

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(int numberFlight) {
        this.numberFlight = numberFlight;
    }

    public String getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(String typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String daysWeek) {
        this.dayWeek = daysWeek;
    }

    private String destination;
    private int numberFlight;
    private String typeOfAircraft;
    private int departureTime;
    private String dayWeek;

    public Airline() {

        this.destination = "";
        this.numberFlight = 0;
        this.typeOfAircraft = "";
        this.departureTime = 0;
        this.dayWeek = "";
    }

    @Override
    public String toString() {

        return "Пункт назначения = " + getDestination() + "\nНомер рейса: " + getNumberFlight() + "\nТип самолета: "
                + getTypeOfAircraft() + "\nВремя вылета " + getDepartureTime() + "\nДни недели: " + getDayWeek();
    }
}

final class Airport {

    Airline[] airlines;

    public Airport(Airline[] airlines) {
        this.airlines = airlines;
    }

    public void destinationListFlights(String destination) {

        System.out.println("Список рейсов для заданного пункта назначения: \n");
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDestination() == destination) {
                System.out.println(airlines[i].toString());
                System.out.println();
            }
        }
    }

    public void listFlightsForDayWeek(String day) {

        System.out.println("Список рейсов для заданного дня недели: \n");
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDayWeek() == day) {
                System.out.println(airlines[i].toString());
                System.out.println();
            }
        }
    }

    public void listFlightsForDayWeek_PlusDepartureTime(String day, int departureTime) {

        System.out.println("Cписок рейсов для заданного дня недели, время вылета для которых больше заданного: \n");
        for (int i = 0; i < airlines.length; i++) {
            if (airlines[i].getDayWeek() == day) {
                if (airlines[i].getDepartureTime() > departureTime) {
                    System.out.println(airlines[i].toString());
                    System.out.println();
                }
            }
        }
    }
}

public class Classes_exe_10 {

    public static void main(String[] args) {

        Airline[] airlines = new Airline[3];
        airlines[0] = new Airline();
        airlines[0].setDestination("Minsk");
        airlines[0].setNumberFlight(1545);
        airlines[0].setTypeOfAircraft("Ту-134");
        airlines[0].setDepartureTime(1200);
        airlines[0].setDayWeek("Friday");

        airlines[1] = new Airline();
        airlines[1].setDestination("Gomel");
        airlines[1].setNumberFlight(7854);
        airlines[1].setTypeOfAircraft("ИЛ-62");
        airlines[1].setDepartureTime(1415);
        airlines[1].setDayWeek("Tusday");

        airlines[2] = new Airline();
        airlines[2].setDestination("Moscow");
        airlines[2].setNumberFlight(1232);
        airlines[2].setTypeOfAircraft("ИЛ-62");
        airlines[2].setDepartureTime(1400);
        airlines[2].setDayWeek("Tuesday");

        Airport airport = new Airport(airlines);
        airport.destinationListFlights("Moscow");
        airport.listFlightsForDayWeek("Friday");
        airport.listFlightsForDayWeek_PlusDepartureTime("Tusday", 1400);
    }
}
