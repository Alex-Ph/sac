package de.ph.sac.bpmn;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.complete;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.execute;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.job;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.runtimeService;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.task;
import static org.camunda.bpm.extension.mockito.DelegateExpressions.autoMock;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Deployment(resources = "demo_process.bpmn")
public class UserCreationProcessIntegTest extends AbstractProcessEngineRuleTest {

    @Autowired
    @Rule
    public ProcessEngineRule processEngineRule;

    @Test
    public void start_and_finish_process() {
        autoMock("demo_process.bpmn");

        final ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("sacProcess");

        assertThat(processInstance).isWaitingAt("UserTask_1");
        complete(task(),createSignatureVarMapping("Signature A"));

        assertThat(processInstance).isWaitingAt("UserTask_2");
        complete(task(),createSignatureVarMapping("Signature B"));

        assertThat(processInstance).isEnded();
    }

    private Map<String, Object> createSignatureVarMapping(String signature){
        Map<String, Object> varMapping = new HashMap<>();
        varMapping.put("latestSignature", signature);

        return varMapping;
    }
}