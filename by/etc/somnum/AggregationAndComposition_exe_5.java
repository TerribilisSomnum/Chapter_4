package by.etc.somnum;

/*
Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */

import java.util.ArrayList;
import java.util.Scanner;

class TravelVoucher{

    private ArrayList<TypeVoucher> typeVouchers = new ArrayList<TypeVoucher>();

    public ArrayList<TypeVoucher> getTypeVouchers() {
        return typeVouchers;
    }

    public void setTypeVouchers(ArrayList<TypeVoucher> typeVouchers) {
        this.typeVouchers = typeVouchers;
    }

    @Override
    public String toString() {
        return "Выбор путевки: " + getTypeVouchers();
    }

    public void showPackageMenu(){

        int result = 0;
        System.out.println("Выберите тип путевки:\n 1)Отдых\n 2)Экскурсии\n 3)Лечение");
        Scanner reader = new Scanner(System.in);
        result = reader.nextInt();

        switch (result){
            case(1): { getTypeVouchers().get(0).setRelax(true); break;}
            case(2): { getTypeVouchers().get(0).setExcursion(true); break;}
            case(3): { getTypeVouchers().get(0).setTreatment(true);break;}
            default: { System.out.println("тру-ля-ля"); break; }
        }
    }

    public void showPackageTransport(){

        int result = 0;
        System.out.println("Выберите тип транспорта:\n 1)Автобус\n 2)Такси");
        Scanner reader = new Scanner(System.in);
        result = reader.nextInt();

        switch (result){
            case(1): { getTypeVouchers().get(0).getTransports().get(0).setBus(true);break;}
            case(2): { getTypeVouchers().get(0).getTransports().get(0).setTaxi(true);break;}
            default: { System.out.println("тру-ля-ля"); break; }
        }
    }

    public void showPackageNutrition(){

        int result = 0;
        System.out.println("Выберите тип питания:\n 1)Завтрак\n 2)Завтрак, обед\n 3)Завтрак, обед и ужин");
        Scanner reader = new Scanner(System.in);
        result = reader.nextInt();

        switch (result){
            case(1): { getTypeVouchers().get(0).getNutritions().get(0).setBreakfast(true);break;}
            case(2): { getTypeVouchers().get(0).getNutritions().get(0).setbreakfastAndLunch(true);break;}
            case(3): { getTypeVouchers().get(0).getNutritions().get(0).setbreakfastAndLunchAndDinner(true);break;}
            default: { System.out.println("тру-ля-ля"); break; }
        }
    }

    public void showPackageDays(){

        int result = 0;
        System.out.println("Выберите количество дней:\n 1)7 дней (неделя)\n 2)14 дней (две недели)");
        Scanner reader = new Scanner(System.in);
        result = reader.nextInt();

        switch (result){
            case(1): { getTypeVouchers().get(0).getCountDays().get(0).setWeek(true);break;}
            case(2): { getTypeVouchers().get(0).getCountDays().get(0).setTwoWeek(true);break;}
            default: { System.out.println("тру-ля-ля"); break; }
        }
    }

    public void showUserChoice() {

        for (int i = 0; i < getTypeVouchers().size(); i++) {
            if (true) {
                System.out.println(getTypeVouchers().get(i));
            }
        }
    }
}

class TypeVoucher {

    private boolean relax;
    private boolean excursion;
    private boolean treatment;

    private ArrayList<Transport> transports = new ArrayList<Transport>();
    private ArrayList<Nutrition> nutritions = new ArrayList<Nutrition>();
    private ArrayList<CountDay> countDays = new ArrayList<CountDay>();

    public TypeVoucher() {

        this.relax = false;
        this.excursion = false;
        this.treatment = false;
    }

    public ArrayList<CountDay> getCountDays() { return countDays; }

    public void setCountDays(ArrayList<CountDay> countDays) { this.countDays = countDays; }

    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public void setTransports(ArrayList<Transport> transports) {
        this.transports = transports;
    }

    public ArrayList<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(ArrayList<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }

    public boolean isRelax() {
        return relax;
    }

    public void setRelax(boolean relax) {
        this.relax = relax;
    }

    public boolean isExcursion() {
        return excursion;
    }

    public void setExcursion(boolean excursion) {
        this.excursion = excursion;
    }

    public boolean isTreatment() {
        return treatment;
    }

    public void setTreatment(boolean treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Выбор путевки = " + (isRelax() ? " отдых\n" : "") + (isExcursion() ? " экскурсии\n" : "") +
                (isTreatment() ? " лечение\n" : "") + getTransports() + getNutritions() + getCountDays();
    }
}

class  Transport{

    private boolean bus;
    private boolean taxi;

    public Transport(){

        this.bus = false;
        this.taxi = false;
    }

    public boolean isBus() {
        return bus;
    }

    public void setBus(boolean bus) {
        this.bus = bus;
    }

    public boolean isTaxi() {
        return taxi;
    }

    public void setTaxi(boolean taxi) {
        this.taxi = taxi;
    }

    @Override
    public String toString() {
        return "Тип транспорта = " + (isBus() ? " автобус" : "" ) + (isTaxi() ? " такси" : "");
    }
}

class Nutrition{

    private boolean breakfast;
    private boolean breakfastAndLunch;
    private boolean breakfastAndLunchAndDinner;

    public Nutrition(){

        this.breakfast = false;
        this.breakfastAndLunch = false;
        this.breakfastAndLunchAndDinner = false;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isbreakfastAndLunch() {
        return breakfastAndLunch;
    }

    public void setbreakfastAndLunch(boolean lunch) {
        this.breakfastAndLunch = lunch;
    }

    public boolean isbreakfastAndLunchAndDinner() {
        return breakfastAndLunchAndDinner;
    }

    public void setbreakfastAndLunchAndDinner(boolean dinner) {
        this.breakfastAndLunchAndDinner = dinner;
    }

    @Override
    public String toString() {

        return "Питание = " + (isBreakfast() ? " завтрак" : "") + (isbreakfastAndLunch() ? " завтрак и обед" : "") +
                (isbreakfastAndLunchAndDinner() ? " завтрак, обед и ужин" : "");
    }
}

class  CountDay{

    private boolean week;
    private boolean twoWeek;

    public CountDay(){

        this.week = false;
        this.twoWeek = false;
    }

    public boolean isWeek() {
        return week;
    }

    public void setWeek(boolean week) {
        this.week = week;
    }

    public boolean isTwoWeek() {
        return twoWeek;
    }

    public void setTwoWeek(boolean twoWeek) {
        this.twoWeek = twoWeek;
    }

    @Override
    public String toString() {
        return "Количество дней = " + (isWeek() ? " 7 дней (неделя)" : "" ) + (isTwoWeek() ? " 14 дней (две недели)" : "");
    }
}

public class AggregationAndComposition_exe_5 {

    public static void main(String[] args) {

        CountDay countDays = new CountDay();
        countDays.isWeek();
        countDays.isTwoWeek();

        Nutrition nutrition = new Nutrition();
        nutrition.isBreakfast();
        nutrition.isbreakfastAndLunch();
        nutrition.isbreakfastAndLunchAndDinner();

        Transport transport = new Transport();
        transport.isBus();
        transport.isTaxi();

        TypeVoucher typeVouchers = new TypeVoucher();
        typeVouchers.isRelax();
        typeVouchers.isExcursion();
        typeVouchers.isTreatment();
        typeVouchers.getTransports().add(transport);
        typeVouchers.getNutritions().add(nutrition);
        typeVouchers.getCountDays().add(countDays);

        TravelVoucher travelVouchers = new TravelVoucher();
        travelVouchers.getTypeVouchers().add(typeVouchers);

        System.out.println("Меню наших услуг:");
        travelVouchers.showPackageMenu();
        travelVouchers.showPackageTransport();
        travelVouchers.showPackageNutrition();
        travelVouchers.showPackageDays();
        travelVouchers.showUserChoice();
    }
}
