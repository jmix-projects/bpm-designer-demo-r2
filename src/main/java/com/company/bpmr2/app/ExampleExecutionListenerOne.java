package com.company.bpmr2.app;

import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bpmr2_ExampleExecutionListenerOne")
public class ExampleExecutionListenerOne implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(ExampleExecutionListenerOne.class);
    public Expression testValue;
    public Expression firstValue;
    @Autowired
    public Logger log1;

    @Override
    public void execute(DelegateExecution execution) {
        execution.setVariable("variableSetInExecutionListener", "firstValue");
        execution.setVariable("eventReceived", execution.getEventName());
        testValue.getValue(execution);
    }

    public void myMethod(String text) {
        System.out.println("Some text is " + text);
    }
}

