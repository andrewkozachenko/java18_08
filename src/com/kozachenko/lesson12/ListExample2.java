package com.kozachenko.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MapperFromStringToListPerson {

    private static List<String> getListOfString(String s) {
        String[] array =s.split(" ");
        List<String> list = Arrays.asList(array);
       return list;
    }

    private static Person getPerson(String s){
        String [] name = s.split(",");
        String firstName = name[1];
        String lastName = name[0];
        Person anonim = new Person(firstName, lastName);
        return anonim;
    }

    public static List<Person> getPersonsFromString(String s){
        List<Person> personList = new ArrayList<>();
        List<String> listOfStrings = getListOfString(s);
        for (String person: listOfStrings) {
            personList.add(getPerson(person));
        }
        return personList;
    }
}


public class ListExample2 {

    public static void main(String[] args) {

        String students = "Ланкин,Никита\\n" +
                "Чернобай,Василий\\n" +
                "Петров,Роман\\n" +
                "Дроздов,Артур\\n" +
                "Хмель,Богдан\\n" +
                "Кореньков,Дмитрий\\n" +
                "Батурдинов, \\n";

        List<Person> people = MapperFromStringToListPerson.getPersonsFromString(students);
        for (Person person: people
             ) {
            System.out.println(person);
        }
    }

}
