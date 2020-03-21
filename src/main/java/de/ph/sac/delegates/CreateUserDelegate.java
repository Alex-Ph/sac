package de.ph.sac.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserDelegate implements JavaDelegate {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String name = (String) execution.getVariable("name");
        String lastName = (String) execution.getVariable("name");

        String fullName = name + " " + lastName;

        logger.info("Create user and adding fullName: " + fullName);

        execution.setVariable("fullName", fullName);
    }

}