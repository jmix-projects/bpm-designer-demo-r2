package com.company.bpmr2.screen.jmixinit;

import com.vaadin.ui.Button;
import io.jmix.bpmui.processform.ProcessFormContext;
import io.jmix.bpmui.processform.annotation.Outcome;
import io.jmix.bpmui.processform.annotation.OutputVariable;
import io.jmix.bpmui.processform.annotation.Param;
import io.jmix.bpmui.processform.annotation.ProcessForm;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@ProcessForm(
        outcomes = {
                @Outcome(id = "approve"),
                @Outcome(id = "reject")
        },
        params = {
                @Param(name = "variableName"),
                @Param(name = "entityPickerCaption")
        },
        outputVariables = {
                @OutputVariable(name = "out boolean", type = boolean.class),
                @OutputVariable(name = "out double", type = double.class),
        }
)
@UiController("bpmr2_JmixInitScreen")
@UiDescriptor("jmix-init-screen.xml")
public class JmixInitScreen extends Screen {
    @Autowired
    private ProcessFormContext processFormContext;

    @Subscribe("rejectBtn")
    protected void onRejectBtnClick(Button.ClickEvent event) {
        processFormContext.taskCompletion()
                .withOutcome("reject")
                .saveInjectedProcessVariables()
                .complete();
        closeWithDefaultAction();
    }

    @Subscribe("startProcessBtn")
    public void onStartProcessBtnClick(Button.ClickEvent event) {
        processFormContext.processStarting()
                .start();
        closeWithDefaultAction();
    }
}