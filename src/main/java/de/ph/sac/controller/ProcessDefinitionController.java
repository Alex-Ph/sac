package de.ph.sac.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creating custom controller to avoid CORS and to be able to start our process
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProcessDefinitionController {
 
    @Autowired
    private RuntimeService runtimeService;
    
    private static final String SAC_KEY = "sacProcess";

    @PostMapping("/startSacProcessInstance")
    public String startSacProcess() {
        return runtimeService.startProcessInstanceByKey(SAC_KEY).getProcessInstanceId();
    }

}