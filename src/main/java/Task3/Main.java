package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Иван", "Иванов", "Иванович", Arrays.asList(11, 17, 18));
        Student student2 = new Student("Максим", "Максимов", "Максимович", Arrays.asList(15, 17, 25));
        Student student3 = new Student("Ирина", "Мухаморова", "Александровна", Arrays.asList(10, 16, 7));

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Collections.sort(students);
        printOlympiadWinners(students);
    }

    private static void printOlympiadWinners(List<Student> students) {
        students.sort(Comparator.reverseOrder());

        for (int i = 0; i < 3; i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + " место: " + student.averageScore() + " " + student.getSurname() + " " + student.getName() + " " + student.getPatronymic());
        }
    }
}