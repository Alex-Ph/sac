package de.ph.sac.controller;

import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.ph.sac.controller.dto.SacTask;

/**
 * Creating custom controller to avoid CORS and to be able to start our process
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ManageTaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/completeTask/")
    public void completeTask(@RequestBody SacTask task) {
        taskService.complete(task.getId());
    }

    @PostMapping("/claimTask")
    public void claimTask(@RequestBody SacTask task) {
        taskService.claim(task.getId(), task.getAssignee());
    }

}