package by.etc.somnum;

//Создать объект класса Государство, используя классы Область, Город, Район. Методы: вывести на консоль столицу,
//количество областей, площадь, областные центры.

import java.util.ArrayList;

class State {

    private City capital;
    private ArrayList<Region> regions = new ArrayList<Region>();

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return getRegions().get(0).getCities().get(0).getName().toString();
    }

    public void printCapital() {

        System.out.println(getRegions().get(0).getCities().get(1).getName().toString());
    }

    public void printCountRegionCity() {

        int count = 0;
        for (int i = 0; i < getRegions().size(); i++) {
            count++;
        }
        System.out.println(count);
    }

    public void printRegionCity() {

        for (int i = 0; i < getRegions().size(); i++) {
            System.out.println(getRegions().get(i).getRegionalCity());
        }
    }

    public void printAreaRegionalCities() {

        for (int i = 0; i < getRegions().size(); i++) {
            System.out.print(getRegions().get(i) + " = ");
            System.out.println(getRegions().get(i).getArea());
        }
    }
}

class Region {

    private ArrayList<City> regionalCity = new ArrayList<City>();
    private ArrayList<City> cities = new ArrayList<City>();
    private ArrayList<City> area = new ArrayList<City>();

    public ArrayList<City> getArea() { return area; }

    public void setArea(ArrayList<City> area) { this.area = area; }

    public ArrayList<City> getRegionalCity() {
        return regionalCity;
    }

    public void setRegionalCity(ArrayList<City> regionalCity) {
        this.regionalCity = regionalCity;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return getRegionalCity().get(0).getName();
    }

}

class City {

    private String name;
    private ArrayList<District> districts = new ArrayList<>();

    public City(String name) { this.setName(name); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return getName().toString();
    }
}

class District {

    private String name;

    public District(String name) { this.setName(name); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}

public class AggregationAndComposition_exe_3 {

    public static void main(String[] args) {

        District districtFirst = new District("Pervomaiskii");
        District districtSecond = new District("Centralnyi");

        City city = new City("Borisov");
        city.getDistricts().add(districtFirst);
        city.getDistricts().add(districtSecond);

        City capital = new City("Minsk");
        capital.getDistricts().add(districtSecond);
        City areaMinsk = new City("348,8");

        City regionCityGomel = new City("Gomel");
        City areaGomel = new City("139,8");

        City regionCityBrest = new City("Brest");
        City areaBrest = new City("146,1");

        Region regionOne = new Region();
        regionOne.getCities().add(city);
        regionOne.getCities().add(capital);
        regionOne.getRegionalCity().add(capital);
        regionOne.getArea().add(areaMinsk);

        Region regionTwo = new Region();
        regionTwo.getCities().add(regionCityBrest);
        regionTwo.getRegionalCity().add(regionCityBrest);
        regionTwo.getArea().add(areaBrest);

        Region regionThree = new Region();
        regionThree.getCities().add(regionCityGomel);
        regionThree.getRegionalCity().add(regionCityGomel);
        regionThree.getArea().add(areaGomel);

        State state = new State();
        state.getRegions().add(regionOne);
        state.getRegions().add(regionTwo);
        state.getRegions().add(regionThree);

        System.out.print("Столица: ");
        state.printCapital();

        System.out.print("\nКоличество областных городов: ");
        state.printCountRegionCity();

        System.out.println("\nОбластные города: ");
        state.printRegionCity();

        System.out.println("\nПлощадь областных городов: ");
        state.printAreaRegionalCities();
    }
}
