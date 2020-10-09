package com.kozachenko.lesson8.pizzeria.people;

import com.kozachenko.lesson8.pizzeria.things.Coffee;
import com.kozachenko.lesson8.pizzeria.things.Food;
import com.kozachenko.lesson8.pizzeria.things.Pasta;
import com.kozachenko.lesson8.pizzeria.things.Pizza;

import java.util.Random;

public class Client extends Person {
    @Override
    public String doSomething() {
        Food food = getFood();
        return makeOrder(food);
    }

    public String makeOrder(Food food){
        return food.getName();
    }

    private Food getFood(){
        Food food = null;
        int random = new Random().nextInt();
        if (random % 2 ==0){
            food = new Pizza();
        } else if(random % 3 == 0){
            food = new Pasta();
        }else {
            food = new Coffee();
        }

        return food;
    }
}
