package de.ph.sac.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import de.ph.sac.controller.dto.SacTask;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

   @InjectMocks
   TaskController taskController;

   @Mock
   TaskService mockedTaskService;

   @Before
   public void setup() {
      MockitoAnnotations.initMocks(this);
   }
   
   @Test
   public void getNotEmptyOpenTasks(){
      TaskQuery mockedTaskQuery = mock(TaskQuery.class);
      List<Task> camundaTasks = new ArrayList<>();
      List<SacTask> sacTasks = null;

      camundaTasks.add(new CamundaTask("ID1","TestTask A"));
      camundaTasks.add(new CamundaTask("ID13333","TestTask B"));

      when(this.mockedTaskService.createTaskQuery()).thenReturn(mockedTaskQuery);

      when(mockedTaskQuery.active()).thenReturn(mockedTaskQuery);
      when(mockedTaskQuery.list()).thenReturn(camundaTasks);

      sacTasks = this.taskController.getOpenTasks();

      assertThat(sacTasks.size() == 2);
      assertThat("ID1".equals(sacTasks.get(0).getId()));
      assertThat("TestTask A".equals(sacTasks.get(0).getName()));
      assertThat("ID13333".equals(sacTasks.get(0).getId()));
      assertThat("TestTask B".equals(sacTasks.get(0).getName()));
   }
}