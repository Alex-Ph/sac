package de.ph.sac.context;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SacContext {

  @Bean
  public ProcessEngine processEngine(ProcessEngineFactoryBean factoryBean) throws Exception {
    return factoryBean.getObject();
  }

}
