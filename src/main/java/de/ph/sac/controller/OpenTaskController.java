package de.ph.sac.controller;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ph.sac.controller.dto.SacTask;

/**
 * Creating custom controller to avoid CORS and to show how we
 * can access the processEngine
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Component
public class OpenTaskController {
 
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    @Autowired
	private ProcessEngine processEngine;
    
    @GetMapping("/openSacTasks")
    public List<SacTask> getOpenTasks() {
        logger.info("Engine: "+ processEngine);

        return openTaskData();
    }

    private List<SacTask> openTaskData() {
        List<Task> camundaTasks = processEngine.getTaskService().createTaskQuery().active().list();
        List <SacTask> tasks = new ArrayList<>();

        if (camundaTasks == null){
            return null;
        }

        camundaTasks.forEach(camundaTask -> {
            SacTask sacTask = new SacTask();

            sacTask.setId(camundaTask.getId());
            sacTask.setName(camundaTask.getName());
            sacTask.setAssignee(camundaTask.getAssignee());

            tasks.add(sacTask);
        });

        return tasks;
    }
}