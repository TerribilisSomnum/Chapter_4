package by.etc.somnum;

/*
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

final class Student {

    String fio;
    int groupNumber;
    int [] progress = new int[5] ;

    public void Student(){

        this.fio = "";
        this.groupNumber = 0;
    }

    public boolean isExcellentStudent(){

        if(this.progress[0] > 8 && progress[1] > 8 && progress[2] > 8 && progress[3] > 8 && progress[4] > 8){
            return  true;
        }else {
            return  false;
        }
    }
}

public class Classes_exe_3 {

    final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    final static java.util.Random rand = new java.util.Random();
    final static Set<String> identifiers = new HashSet<String>();

    public static String randomIdentifier() {

        StringBuilder builder = new StringBuilder();

        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;

            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public static int randomGroup (){

        Random rand = new Random();
        int random = (int)(1 + Math.random() * 50);
        return random;
    }

    public static int randomMarks (){

        Random rand = new Random();
        int random = (int)(4 + Math.random() * 11);
        return random;
    }

    public static void printSuccessfulStudent(Student[] stud){

        for(int i = 0; i < stud.length; i++){
            if(stud[i].isExcellentStudent()){
                System.out.println("Имя студента " + stud[i].fio + " = группа № " + stud[i].groupNumber);
            }
        }
    }

    public static void fillWithRandomData(Student student){

        student.fio = randomIdentifier();
        student.groupNumber = randomGroup();
        student.progress[0] = randomMarks();
        student.progress[1] = randomMarks();
        student.progress[2] = randomMarks();
        student.progress[3] = randomMarks();
        student.progress[4] = randomMarks();
    }

    public static void main(String[] args) {

        Student[] students = new Student[10];

        for (int i = 0; i < 10; i++){
            students[i] = new Student();
            fillWithRandomData(students[i]);
        }
        printSuccessfulStudent(students);
    }
}
