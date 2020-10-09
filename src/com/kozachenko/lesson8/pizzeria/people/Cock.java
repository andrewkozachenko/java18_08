package com.kozachenko.lesson8.pizzeria.people;

import com.kozachenko.lesson8.pizzeria.WorkType;

public class Cock extends Person implements ServiceStaff {
    @Override
    public String doSomething() {
        return null;
    }

    @Override
    public String work(WorkType type) {
        return type.name();
    }
}
