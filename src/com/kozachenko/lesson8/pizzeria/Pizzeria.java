package com.kozachenko.lesson8.pizzeria;

import com.kozachenko.lesson8.pizzeria.people.Client;
import com.kozachenko.lesson8.pizzeria.people.ServiceFactoryMethod;
import com.kozachenko.lesson8.pizzeria.people.ServiceStaff;

public class Pizzeria {

    public static void main(String[] args) {
        Client client = new Client();
        ServiceFactoryMethod serviceFactory = new ServiceFactoryMethod();
        String order = client.doSomething();
        WorkType work = getWork(order);
        ServiceStaff serviceStaff = serviceFactory.service(work);
        System.out.println(serviceStaff.work(work));
    }

    private static WorkType getWork(String order){
        switch (order){
            case "Pizza":
                return WorkType.COOK;
            case "Pasta":
                return WorkType.COOK;
            case "Coffee":
                return WorkType.MAKE_DRINK;
        }
        return null;
    }
}
