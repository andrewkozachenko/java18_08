package com.kozachenko.lesson13;

import com.kozachenko.lesson12.Person;

import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        firstTryToFoulSet();
    }

    private static void howToUseEquals(){
        Person person1 = new Person("Thor", "Odinson", 3000);
        Person person2 = new Person("Thor", "Odinson", 3000);
        Person person3 = new Person("Thor", "Odinson", 3001);
        Person person4 = person1;
        System.out.println("Before custom equals \n" +
                "true\n" +
                "false\n" +
                "true\n" +
                "false");
        System.out.println("After custom equals");
        System.out.println(person1.equals(person1));
        System.out.println(person1.equals(person2));
        System.out.println(person2.equals(person2));
        System.out.println(person2.equals(person1));
        System.out.println(person1.equals(person3));
        System.out.println(person2.equals(person3));
    }

    private static void firstTryToFoulSet(){
        Person person1 = new Person("Thor", "Odinson", 3000);
        System.out.println("Hashcode person 1 = " + person1.hashCode());
        Person person2 = new Person("Thor", "Odinson", 3000);
        System.out.println("Hashcode person 1 = " + person2.hashCode());
        Person person3 = new Person("Thor", "Odinson", 3001);
        System.out.println("Hashcode person 1 = " + person3.hashCode());
        HashSet<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.clear();
        System.out.println(people);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.remove(person1);
        System.out.println(people);

    }

    private static void createMySetAndPrint() {
        HashSet<String> myFirstSet = new HashSet<>();
        Set<String> mySecondSet = new HashSet<>();

        myFirstSet.add("Andrii");
        myFirstSet.add("Andrii");
        myFirstSet.add("Andrii");
        myFirstSet.add("Vasya");
        myFirstSet.add("Vasya");
        myFirstSet.add("Thor");
        myFirstSet.add("Loki");

        System.out.println(myFirstSet);
    }
}
