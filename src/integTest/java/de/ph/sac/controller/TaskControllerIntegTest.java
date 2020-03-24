package de.ph.sac.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import de.ph.sac.AbstractBaseTest;
import de.ph.sac.controller.dto.SacTask;

/**
 * First "dummy" integtest. Need to be enhanced later
 */
public class TaskControllerIntegTest extends AbstractBaseTest {
    @Override
    @Before
    public void setUp() {
       super.setUp();
    }
    @Test
    public void getOpenTasks() throws Exception {
       String uri = "/openSacTasks";
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       String content = mvcResult.getResponse().getContentAsString();
       
       SacTask[] taskList = super.mapFromJson(content, SacTask[].class);
       
       assertEquals(200, status);
       assertTrue(taskList.length == 0);
    }
}