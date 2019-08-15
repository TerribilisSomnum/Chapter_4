package by.etc.somnum;

/*
Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод    toString().  Создать  второй  класс,  агрегирующий  массив  типа  Book,  с  подходящими  конструкторами  и
методами. Задать критерии выбора данных и вывести эти данные на консоль.

Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
*/

final class Book {

    private int id;
    private String title;
    private String autor;
    private String publishingHouse;
    private int yearPublishingHouse;
    private int countPages;
    private int price;
    private String typeBinding;

    public Book() {

        this.id = 0;
        this.title = "";
        this.autor = "";
        this.publishingHouse = "";
        this.yearPublishingHouse = 0;
        this.countPages = 0;
        this.price = 0;
        this.typeBinding = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearPublishingHouse() {
        return yearPublishingHouse;
    }

    public void setYearPublishingHouse(int yearPublishingHouse) {
        this.yearPublishingHouse = yearPublishingHouse;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeBinding() {
        return typeBinding;
    }

    public void setTypeBinding(String typeBinding) {
        this.typeBinding = typeBinding;
    }

    @Override
    public String toString() {

        return "id = " + getId() + "\nНазвание книги: " + getTitle() + "\nАвтор: " + getAutor() + "\nИздательство " + getPublishingHouse() +
                "\nГод издания: " + getYearPublishingHouse() + "\nКоличество страниц: " + getCountPages() +
                "\nЦена: " + getPrice() + "\nТип переплета: " + getTypeBinding();
    }
}

final class Library {

    Book[] books;

    public Library(Book[] books) {

        this.books = books;
    }

    public void showsBooksSpecificAuthor(String specificAutor) {

        System.out.println("Список книг заданного автора: \n");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAutor() == specificAutor) {
                System.out.println(books[i].toString());
                System.out.println();
            }
        }
    }

    public void showsBooks_SpecificPublishingHouse(String publishingHouse) {

        System.out.println("Список книг, выпущенных заданным издательством: \n");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublishingHouse() == publishingHouse) {
                System.out.println(books[i].toString());
                System.out.println();
            }
        }
    }

    public void showsBooksAfterSpecificYear(int year) {

        System.out.println("Список книг, выпущенных после заданного года: \n");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYearPublishingHouse() > year) {
                System.out.println(books[i].toString());
                System.out.println();
            }
        }
    }

}

public class Classes_exe_9 {

    public static void main(String[] args) {

        Book[] books = new Book[4];
        books[0] = new Book();
        books[0].setId(456);
        books[0].setTitle("Bob");
        books[0].setAutor("Alan");
        books[0].setPublishingHouse("Hooli");
        books[0].setYearPublishingHouse(2014);
        books[0].setCountPages(350);
        books[0].setPrice(50);
        books[0].setTypeBinding("solid");

        books[1] = new Book();
        books[1].setId(457);
        books[1].setTitle("Animals");
        books[1].setAutor("Radrigo");
        books[1].setPublishingHouse("White house");
        books[1].setYearPublishingHouse(2019);
        books[1].setCountPages(456);
        books[1].setPrice(55);
        books[1].setTypeBinding("soft");

        books[2] = new Book();
        books[2].setId(458);
        books[2].setTitle("People");
        books[2].setAutor("God");
        books[2].setPublishingHouse("Sky");
        books[2].setYearPublishingHouse(2007);
        books[2].setCountPages(656);
        books[2].setPrice(80);
        books[2].setTypeBinding("solid");

        books[3] = new Book();
        books[3].setId(459);
        books[3].setTitle("Children");
        books[3].setAutor("God");
        books[3].setPublishingHouse("Sky");
        books[3].setYearPublishingHouse(2010);
        books[3].setCountPages(474);
        books[3].setPrice(25);
        books[3].setTypeBinding("solid");


        Library library = new Library(books);
        library.showsBooksSpecificAuthor("God");
        library.showsBooks_SpecificPublishingHouse("White house");
        library.showsBooksAfterSpecificYear(2010);
    }
}
