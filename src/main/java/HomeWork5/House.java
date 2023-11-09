package HomeWork5;
//- Создать класс House
//        - Создать HashMap
//        - Заполнить ее жильцами по принципу (ФИО, Возраст)
//        - Пройти по Мапе и найти всех жильцов кому больше 18ти лет
//        - Найденных жильцов записать в ArrayList (Возраст указывать необязательно)
//        - Получившийся ArrayList отсортировать и вывести в консоль

import java.util.*;

public class House {
    public static void main(String[] args) {
        HashMap<Integer, String> House = new HashMap<>();

        House.put(17, "Иванов Иван Иванович");
        House.put(21, "Петров Петр Петрович");
        House.put(30, "Максимов Максим Максимович");
        House.put(43, "Кузьмин Андрей Сергеевич");
        System.out.println("Жильцы проживающие в доме: " + House.entrySet());

        for (Map.Entry<Integer, String> entry : House.entrySet()) {
            Integer key = entry.getKey();
            {
                if (key > 18) {
                    // System.out.println(key);
                    ArrayList<String> adultSegment = new ArrayList<>();
                    adultSegment.add(entry.getValue());
                    Collections.sort(adultSegment);

                    System.out.println("Жильцы кому больше 18ти лет - " + adultSegment);
                }
            }
        }
    }
}