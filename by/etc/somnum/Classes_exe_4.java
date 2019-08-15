package by.etc.somnum;

/*
Создайте  класс  Train,  содержащий  поля:  название  пункта  назначения,  номер  поезда,  время  отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте  возможность  сортировки  массив  по  пункту  назначения,  причем  поезда  с  одинаковыми  пунктами
назначения должны быть упорядочены по времени отправления.
 */

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Train {

    String distination;
    int trainNumber;
    LocalDateTime departure;

    public void Train() {

        this.distination = "";
        this.trainNumber = 0;
        this.departure = LocalDateTime.now();
    }

}

public class Classes_exe_4 {

    public static Train[] sortByTrainNumber(Train[] trains) {

        Arrays.sort(trains, new Comparator<Train>() {

                    @Override
                    public int compare(Train s1, Train s2) {
                        return s1.trainNumber > s2.trainNumber ? +1 : s1.trainNumber < s2.trainNumber ? -1 : 0;
                    }
                }
        );
        return trains;
    }

    public static int userInput() {

        System.out.print("Введите номер поезда: ");
        Scanner reader = new Scanner(System.in);
        int number = reader.nextInt();
        return number;
    }

    public static void showTrainInfo(int number, Train[] trains) {

        for (int i = 0; i < trains.length; i++) {
            if (trains[i].trainNumber == number) {
                System.out.println("Номер поезда " + trains[i].trainNumber + ", пункт назначения = "
                        + trains[i].distination + ", дата отправления: " + trains[i].departure);
            }
        }
    }

    public static Train[] sortByDistination(Train[] trains) {

        Arrays.sort(trains, new Comparator<Train>() {

                    @Override
                    public int compare(Train s1, Train s2) {
                        if (s1.distination.equals(s2.distination)) {
                            return s1.departure.compareTo(s2.departure);
                        }
                        return s1.distination.compareTo(s2.distination);
                    }
                }
        );
        return trains;
    }

    public static void main(String[] args) {

        Train[] trains = new Train[5];

        trains[0] = new Train();
        trains[0].distination = "Moscow";
        trains[0].trainNumber = 354;
        trains[0].departure = LocalDateTime.of(2019, 8, 11, 15, 20);

        trains[1] = new Train();
        trains[1].distination = "Gomel";
        trains[1].trainNumber = 210;
        trains[1].departure = LocalDateTime.of(2019, 8, 11, 18, 10);

        trains[2] = new Train();
        trains[2].distination = "Bobruisk";
        trains[2].trainNumber = 888;
        trains[2].departure = LocalDateTime.of(2019, 8, 11, 20, 20);

        trains[3] = new Train();
        trains[3].distination = "Gomel";
        trains[3].trainNumber = 987;
        trains[3].departure = LocalDateTime.of(2019, 8, 11, 22, 5);

        trains[4] = new Train();
        trains[4].distination = "Brest";
        trains[4].trainNumber = 789;
        trains[4].departure = LocalDateTime.of(2019, 8, 12, 7, 15);

        System.out.println("Поезда отсортированные по номеру: ");
        Train[] sortByNumbers = sortByTrainNumber(trains);
        for (int i = 0; i < sortByNumbers.length; i++) {
            System.out.println("Номер поезда " + sortByNumbers[i].trainNumber);
        }

        System.out.println();
        int userNumber = userInput();
        showTrainInfo(userNumber, trains);

        System.out.println("\nПоезда отсортированные по пункту  назначения: ");
        Train[] sortByDistination = sortByDistination(trains);
        for (int i = 0; i < sortByDistination.length; i++) {
            System.out.println("Номер поезда " + sortByDistination[i].distination + ", время отправления: " + sortByDistination[i].departure);
        }
    }
}
