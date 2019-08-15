package by.etc.somnum;

/*
Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно.
*/

import java.util.ArrayList;
import java.util.Collections;

class Bank{

   private ArrayList<Client> clients = new ArrayList<Client>();

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void searchAccountByNumber(int number) {

        for (int i = 0; i < getClients().size(); i++) {
            for (int y = 0; y < getClients().get(i).getBankAccounts().size(); y++) {
                if (getClients().get(i).getBankAccounts().get(y).getNumber() == number) {
                    System.out.print(getClients().get(i).getBankAccounts().get(y).toString() + " ");
                }
            }
        }
    }

    public void calculatTotalAmountClients(){

        int count = 0;
        int accumulation = 0;
        int debt = 0;

        for(int i  = 0; i < clients.size();i++){

            System.out.print("\nКлиент " + getClients().get(i).getName());

            for (int y = 0; y < getClients().get(i).getBankAccounts().size(); y++) {
                count += getClients().get(i).getBankAccounts().get(y).getCountMoney();

                if(getClients().get(i).getBankAccounts().get(y).getCountMoney() > 0) {
                    accumulation += getClients().get(i).getBankAccounts().get(y).getCountMoney();
                } else {
                    debt += getClients().get(i).getBankAccounts().get(y).getCountMoney();
                }

                System.out.println("\nНомер счета: " + getClients().get(i).getBankAccounts().get(y).getNumber());
                System.out.println("Сумма накоплений: " + accumulation);
                System.out.println("Сумма долга: " + debt);
                accumulation = 0;
                debt = 0;

                System.out.print("Общая сумма клиента на счету = " + count);
                System.out.println();
                count = 0;
            }
        }
    }

    public void calculatTotalAmountBank() {

        int count = 0;
        for (int i = 0; i < clients.size(); i++) {
            for (int y = 0; y < getClients().get(i).getBankAccounts().size() - 1; y++) {
                count += getClients().get(i).getBankAccounts().get(y).getCountMoney();
            }
        }
        System.out.print(count);
    }

    public void sortAmountBank() {

        ArrayList<BankAccount> allAccounts = new ArrayList<BankAccount>();

        for (int i = 0; i < getClients().size(); i++) {
            allAccounts.addAll(getClients().get(i).getBankAccounts());
        }
        Collections.sort(allAccounts);
        for (int i = 0; i < allAccounts.size(); i++) {
            System.out.println(allAccounts.get(i));
        }
    }

    @Override
    public String toString() {
        return getClients().get(0).toString();
    }
}

class Client{

    private String name;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return getName() + " " + getBankAccounts().get(0).toString();
    }
}

class BankAccount implements Comparable<BankAccount> {

   private int number;
   private boolean lock_unlock;
   private int countMoney;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isLock_unlock() {
        return lock_unlock;
    }

    public void setLock_unlock(boolean lock_unlock) {
        this.lock_unlock = lock_unlock;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }
    @Override
    public String toString() {
        return "Номер: " + getNumber() + " средства: " + getCountMoney() + " cтатус: " +
                (isLock_unlock() ? "разблокировано" : "заблокировано");
    }

    @Override
    public int compareTo(BankAccount other){
        if(getNumber() > other.getNumber()){
            return 1;
        }
        else if(getNumber() < other.getNumber()){
            return -1;
        }
        return 0;
    }
}

public class AggregationAndComposition_exe_4 {

    public static void main(String[] args) {

        BankAccount bankAccountBob = new BankAccount();
        bankAccountBob.setNumber(100);
        bankAccountBob.setCountMoney(1000);
        bankAccountBob.setLock_unlock(true);

        Client nameClientBob = new Client();
        nameClientBob.setName("Bob");
        nameClientBob.getBankAccounts().add(bankAccountBob);

        //............................................................

        BankAccount bankAccountRon = new BankAccount();
        bankAccountRon.setNumber(101);
        bankAccountRon.setCountMoney(789);
        bankAccountRon.setLock_unlock(true);

        BankAccount twoBankAccountRon = new BankAccount();
        twoBankAccountRon.setNumber(103);
        twoBankAccountRon.setCountMoney(-500);
        twoBankAccountRon.setLock_unlock(false);

        Client nameClientRon = new Client();
        nameClientRon.setName("Ron");
        nameClientRon.getBankAccounts().add(bankAccountRon);
        nameClientRon.getBankAccounts().add(twoBankAccountRon);

        //............................................................

        BankAccount bankAccountDobby = new BankAccount();
        bankAccountDobby.setNumber(102);
        bankAccountDobby.setCountMoney(-100);
        bankAccountDobby.setLock_unlock(false);

        Client nameClientDobby = new Client();
        nameClientDobby.setName("Dobby");
        nameClientDobby.getBankAccounts().add(bankAccountDobby);

        //............................................................

        Bank bank = new Bank();
        bank.getClients().add(nameClientBob);
        bank.getClients().add(nameClientRon);
        bank.getClients().add(nameClientDobby);

        System.out.print("Поик счета по по номеру 101. Номер счета = ");
        bank.searchAccountByNumber(101);

        System.out.println("\n\nВычисление общей суммы по счетам клиентов: ");
        bank.calculatTotalAmountClients();

        System.out.print("\nБанк содержит на своем счету от всех клиентов: ");
        bank.calculatTotalAmountBank();

        System.out.println("\n\nСортировка счетов по возрастанию:");
        bank.sortAmountBank();
    }
}
