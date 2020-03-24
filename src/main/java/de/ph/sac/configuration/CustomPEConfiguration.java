package de.ph.sac.configuration;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.ph.sac.parserlistener.TaskLoggerParseListener;
import de.ph.sac.configuration.businesshours.BusinessCalendarManager;

@Component
@Order(Ordering.DEFAULT_ORDER + 1)
public class CustomPEConfiguration implements ProcessEnginePlugin {
    Logger logger = LoggerFactory.getLogger(CustomPEConfiguration.class);

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        logger.info("------------------------preInit---------------------------");
        logger.info("Adding custom dummy parse listeners to check");

        // get all existing preParseListeners
		List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPreBPMNParseListeners();
	
		if(preParseListeners == null) {
		  preParseListeners = new ArrayList<>();
		 
		  processEngineConfiguration.setCustomPreBPMNParseListeners(preParseListeners);
		}
		
		preParseListeners.add(new TaskLoggerParseListener());
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        logger.info("------------------------postInit---------------------------");
        
        processEngineConfiguration.setBusinessCalendarManager(new BusinessCalendarManager());
    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {
        logger.info("------------------------postProcessEngineBuild---------------------------");
    }

}