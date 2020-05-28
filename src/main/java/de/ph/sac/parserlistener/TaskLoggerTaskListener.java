package de.ph.sac.parserlistener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import de.ph.sac.controller.SSEController;

class TaskLoggerTaskListener implements TaskListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private String eventName;

    public TaskLoggerTaskListener(String eventName) {
        this.eventName = eventName;
    }

    public void notify(DelegateTask delegateTask) {
        this.sendSSE();
        logger.info("------------------------------------");
        logger.info("Event: " + eventName);
        logger.info("Task-ID: " + delegateTask.getId());
        logger.info("Task-Name: " + delegateTask.getName());
        logger.info("------------------------------------");

        if (delegateTask.getVariable("latestSignature") != null) {
            logger.info("Sac-Signature: " + delegateTask.getVariable("latestSignature"));
            logger.info("Fullname: " + delegateTask.getVariable("fullName"));
        }
    }

    private void sendSSE() {
        List<SseEmitter> sseEmitterListToRemove = new ArrayList<>();
        SSEController.emitters.forEach((SseEmitter emitter) -> {
            try {
                logger.info("Send event to client");
                emitter.send(new Event(eventName), MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                emitter.complete();
                sseEmitterListToRemove.add(emitter);
                e.printStackTrace();
            }
        });
        SSEController.emitters.removeAll(sseEmitterListToRemove);
    }
}