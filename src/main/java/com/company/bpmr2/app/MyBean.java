package com.company.bpmr2.app;

import org.springframework.stereotype.Component;

@Component(value = "bpmr2_MyBean")
public class MyBean {

    public Integer getSum(Integer first, Integer second){
        return first + second;
    }
}