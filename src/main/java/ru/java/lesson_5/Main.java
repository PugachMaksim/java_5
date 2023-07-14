package ru.java.lesson_5;

import java.util.*;

/*
*Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.

***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.
* */

public class Main {

    public static void main(String[] args) {
        String[] cantact = {
                "Григорьев 123456789",
                "Фокин 65431651",
                "Шестаков 6543164",
                "Хохлов 684354644",
                "Шубин 1634645",
                "Гущина 6848613",
                "Брагина 56741343",
                "Брагина 56741355"
        };
        Task1(cantact);
    }


    public static void Task1(String[] telephone) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, List<Telephone>> catalog = new HashMap<>();

        for (String tel : telephone) {
            String[] contact = tel.split(" ");
            int a = Integer.parseInt(contact[1]);
            Telephone cont = new Telephone(contact[0], a);
            if (catalog.containsKey(contact[0])) {
                catalog.get(contact[0]).add(cont);
            }
            else {
                ArrayList<Telephone> lst = new ArrayList<>();
                lst.add(cont);
                catalog.put(contact[0], lst);
            }
//        }
            boolean flag = true;
            while (flag) {

                System.out.println("""
                        Выбирете действие:
                        1 - Добавить контакт
                        2 - Найти контакт
                        3 - Выход
                        """);
                int Ent = sc.nextInt();
                switch (Ent) {
                    case 1 -> {
                        System.out.println("Введите фамилию: ");
                        String SN = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Введите номер телефона: ");
                        int tlf = sc.nextInt();
                        Telephone NewCont = new Telephone(SN, tlf);

                        if (catalog.containsKey(SN)) {
                            catalog.get(SN).add(NewCont);
                        } else {
                            ArrayList<Telephone> lst = new ArrayList<>();
                            lst.add(NewCont);
                            catalog.put(SN, lst);
                        }
                    }
                    case 2 -> {
                        String poise = sc.next();
                        //sc.nextLine();
                        List<Telephone> lst2 = catalog.get(poise);
                        if (lst2 != null) {
                            System.out.println(lst2);
                        }
                    }
                    case 3 -> System.exit(0);
                }
            }
        }
    }
}