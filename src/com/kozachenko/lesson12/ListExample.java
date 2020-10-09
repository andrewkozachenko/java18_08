package com.kozachenko.lesson12;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Person> javaGroup = getPeople();

        printList(javaGroup);

        javaGroup.remove(6);


    }
    private static List<Person> getPeople() {
        List<Person> javaGroup = new ArrayList<>();
        javaGroup.add(new Person("Василий", "Чернобай", 19));
        javaGroup.add(new Person("Никита", "Ланкин", 34));
        javaGroup.add(new Person("Роман", "Петров", 38));
        javaGroup.add(new Person("Артур", "Дроздов", 27));
        javaGroup.add(new Person("Богдан", "Хмель", 37));
        javaGroup.add(new Person("Дмитрий", "Кореньков", 44));
        javaGroup.add(new Person("Hue", "Jackman", 55));
        return javaGroup;
    }

    private static void printList(List<Person> javaGroup) {
        System.out.print("Group participants ");
        System.out.println(javaGroup.size());
        for (int i = 0; i < javaGroup.size(); i++){
            System.out.println("#" + i + " " + javaGroup.get(i));
        }
    }
}
