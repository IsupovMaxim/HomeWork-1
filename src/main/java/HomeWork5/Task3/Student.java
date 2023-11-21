package HomeWork5.Task3;
/**
 * Дан список студентов, участвовавших в олимпиаде. Необходимо подвести итоги олимпиады и выбрать победителей.
 * Призовых мест - 3.
 * <p>
 * Для решения этой задачи необходимо:
 * <p>
 * создать класс Student с полями (учесть модификаторы доступа и геттеры, сеттеры)
 * String name - Имя студента
 * String surname - Фамилия студента
 * String patronymic - Отчество студента
 * List<Integer> score - список баллов по заданиям
 * <p>
 * Создать метод, который принимает на вход список студентов
 * и выводит в консоль победителей в формате: '{Номер места} место: {Фамилия} {Имя} {Отчество}'
 * победителей необходимо определять по их среднему арифметическому значению баллов за задания
 */

import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private String patronymic;
    private List<Integer> score;

    public Student(String name, String surname, String patronymic, List<Integer> score) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    public double averageScore() {
        int sum = 0;
        for (int i : score) {
            sum += i;
        }
        return (double) sum / score.size();
    }

    public int compareTo(Student o) {

        return (int) (this.averageScore() - o.averageScore());
    }
}












