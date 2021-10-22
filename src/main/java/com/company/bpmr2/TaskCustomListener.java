package com.company.bpmr2;

import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.common.engine.impl.scripting.ScriptingEngines;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.task.service.delegate.DelegateTask;

public class TaskCustomListener implements org.flowable.engine.delegate.TaskListener {
    protected Expression value;
    protected Expression language;
    protected Expression resultVariable;
    protected boolean autoStoreVariables;
    @Override

    public void notify(DelegateTask delegateTask) {
        ScriptingEngines scriptingEngines = CommandContextUtil.getProcessEngineConfiguration().getScriptingEngines();
        Object result = scriptingEngines.evaluate(value.getExpressionText(), language.getExpressionText(), delegateTask, autoStoreVariables);

        if (resultVariable != null) {
            delegateTask.setVariable(resultVariable.getExpressionText(), result);
        }
    }
}