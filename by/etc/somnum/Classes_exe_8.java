package by.etc.somnum;

/*
Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод  toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.

Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
*/

import java.util.Arrays;
import java.util.Comparator;

final class Customer {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public int getNumberBankCount() {
        return numberBankCount;
    }

    public void setNumberBankCount(int numberBankCount) {
        this.numberBankCount = numberBankCount;
    }

    private int id;
    private String secondName;
    private String name;
    private String thirdName;
    private String adress;
    private int numberCard;
    private int numberBankCount;

    public Customer() {

        this.id = 0;
        this.secondName = "";
        this.name = "";
        this.thirdName = "";
        this.adress = "";
        this.numberCard = 0;
        this.numberBankCount = 0;
    }


    @Override
    public String toString() {

        return "id = " + getId() + "\nФИО: " + getSecondName() + " " + getName() + " " + getThirdName() +
                "\nАдрес: " + getAdress() + "\nНомер кредитной карточки: " + getNumberCard() +
                "\nНомер банковского счета: " + getNumberBankCount();
    }
}

final class CustomerJournal {

    Customer[] customers;

    public CustomerJournal(Customer[] customers) {

        this.customers = customers;
    }

    public void showSortCustomersByName() {

        Arrays.sort(this.customers, new Comparator<Customer>() {

                    @Override
                    public int compare(Customer s1, Customer s2) {
                        String fioOne = s1.getSecondName() + " " + s1.getName() + " " + s1.getThirdName();
                        String fioTwo = s2.getSecondName() + " " + s2.getName() + " " + s2.getThirdName();
                        return fioOne.compareTo(fioTwo);
                    }
                }
        );
        System.out.println("Пользователи отстортированные по ФИО: \n");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
            System.out.println();
        }
    }

    public void showSortByCardNumber(int botton, int top) {

        Arrays.sort(this.customers, new Comparator<Customer>() {

                    @Override
                    public int compare(Customer s1, Customer s2) {
                        return s1.getNumberCard() > s2.getNumberCard() ? +1 : s1.getNumberCard() < s2.getNumberCard() ? -1 : 0;
                    }
                }
        );
        System.out.println("\nПользователи отстортированные по номеру карты в промежутке от " + botton + " до " + top);
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getNumberCard() >= botton && customers[i].getNumberCard() <= top) {
                System.out.println(customers[i].toString());
                System.out.println();
            }
        }
    }
}

public class Classes_exe_8 {

    public static void main(String[] args) {

        Customer[] customers = new Customer[3];
        customers[0] = new Customer();
        customers[0].setId(111);
        customers[0].setName("Bob");
        customers[0].setSecondName("Alan");
        customers[0].setThirdName("Po");
        customers[0].setAdress("Minsk, 234");
        customers[0].setNumberCard(789545);
        customers[0].setNumberBankCount(111258);

        customers[1] = new Customer();
        customers[1].setId(222);
        customers[1].setName("Ron");
        customers[1].setSecondName("Lee");
        customers[1].setThirdName("Chan");
        customers[1].setAdress("Gomel, 789");
        customers[1].setNumberCard(789654);
        customers[1].setNumberBankCount(222254);

        customers[2] = new Customer();
        customers[2].setId(333);
        customers[2].setName("Jony");
        customers[2].setSecondName("Dan");
        customers[2].setThirdName("White");
        customers[2].setAdress("Bobruisk, 888");
        customers[2].setNumberCard(888999);
        customers[2].setNumberBankCount(333778);

        CustomerJournal journal = new CustomerJournal(customers);
        journal.showSortCustomersByName();
        journal.showSortByCardNumber(789600, 999999);
    }
}
