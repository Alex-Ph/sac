package de.ph.sac.controller;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.ph.sac.controller.dto.CompleteTask;
import de.ph.sac.controller.dto.Message;
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
    public ResponseEntity<Object> completeTask(@RequestBody CompleteTask task) {
        Map<String, Object> varMapping = new HashMap<>();

        if (task.getId() == null || task.getId().isEmpty()){
            return new ResponseEntity<>(new Message("error.forbidden.no-taskid"),HttpStatus.FORBIDDEN);
        }

        if (task.getSignature() == null || task.getSignature().isEmpty()){
            return new ResponseEntity<>(new Message("error.forbidden.no-signature"),HttpStatus.FORBIDDEN);
        }

        // could be also a list of all signatures, linked somehow or a local variable
        varMapping.put("latestSignature", task.getSignature());
        
        taskService.complete(task.getId(), varMapping);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/claimTask")
    public void claimTask(@RequestBody SacTask task) {
        taskService.claim(task.getId(), task.getAssignee());
    }

}