package de.ph.sac.controller;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.task.Task;
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
public class TaskController {
 
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private HistoryService historyService;
    
    @GetMapping("/openSacTasks")
    public List<SacTask> getOpenTasks() {
        return openTaskData();
    }

    @GetMapping("/completedSacTasks")
    public List<SacTask> getCompletedTasks() {
        return completedTaskData();
    }

    private List<SacTask> openTaskData() {
        List<Task> camundaTasks = taskService.createTaskQuery().active().list();
        List<SacTask> tasks = new ArrayList<>();

        if (camundaTasks == null) {
            return null;
        }

        camundaTasks.forEach(camundaTask -> tasks.add(new SacTask(camundaTask)));

        return tasks;
    }

    private List<SacTask> completedTaskData() {

        List<HistoricTaskInstance> finishedTasks = historyService
                .createHistoricTaskInstanceQuery().finished().list();
        List<SacTask> tasks = new ArrayList<>();

        if (finishedTasks == null){
            return null;
        }

        finishedTasks.forEach(finishedTask -> tasks.add(new SacTask(finishedTask)));

        return tasks;
    }
}