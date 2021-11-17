package com.company.bpmr2.app;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component(value = "bpmr2_OrdersCountBean")
public class OrdersCountBean {

    Logger log;

    public void countOfOrders(Integer ordersCount) {
        log.info("The count of orders is " + ordersCount);
    }

    public String secondMethod(String value, Integer ordersCount, boolean isActive) {
        return "The count of " + value + " is " + ordersCount + "and the status is " + isActive;
    }

}