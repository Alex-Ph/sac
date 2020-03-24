package de.ph.sac.parserlistener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TaskLoggerTaskListener implements TaskListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private String eventName;

	public TaskLoggerTaskListener(String eventName) {
        this.eventName = eventName;
	}

	public void notify(DelegateTask delegateTask) {
        logger.info("------------------------------------");
        logger.info("Event: " + eventName);
        logger.info("Task-ID: " + delegateTask.getId());
        logger.info("Task-Name: " + delegateTask.getName());
        logger.info("------------------------------------");
        
        if (delegateTask.getVariable("latestSignature") != null){
            logger.info("Sac-Signature: " + delegateTask.getVariable("latestSignature"));
            logger.info("Fullname: " + delegateTask.getVariable("fullName"));
        }
    }
}