package com.kozachenko.lesson8.pizzeria.people;

import com.kozachenko.lesson8.pizzeria.WorkType;

public class ServiceFactoryMethod {

    public ServiceStaff service(WorkType type){
        ServiceStaff serviceStaff = null;
        switch (type){
            case COOK:
                serviceStaff = new Cock();
                break;
            case SERVE:
            case GET_ORDER:
            case CLOSE_ORDER:
                serviceStaff = new Waiter();
                break;
            case MAKE_DRINK:
                serviceStaff = new Barman();
                break;
        }
        return serviceStaff;
    }
}
