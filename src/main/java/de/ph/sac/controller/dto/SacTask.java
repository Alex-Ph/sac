package de.ph.sac.controller.dto;

import java.util.Date;

import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.task.Task;

/**
 * ToDo: also provide candidates, so we know if we are allowed to claim this
 * task For now user see all tasks and will be able to claim all of em (check
 * right mgmt in camunda)
 */
public class SacTask {

    private String id;
    private String name;
    private String assignee;
    private String description;
    
    private Date date;

    public SacTask() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SacTask(Task camundaTask) {
        this.setId(camundaTask.getId());
        this.setName(camundaTask.getName());
        this.setAssignee(camundaTask.getAssignee());
        this.setDate(camundaTask.getCreateTime());
        this.setDescription(camundaTask.getDescription());
    }

    public SacTask(HistoricTaskInstance finishedTask) {
        this.setId(finishedTask.getId());
        this.setName(finishedTask.getName());
        this.setAssignee(finishedTask.getAssignee());
        this.setDate(finishedTask.getEndTime());
        this.setDescription(finishedTask.getDescription());
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

	public void setAssignee(String assignee) {
        this.assignee = assignee;
	}

    /**
     * @return the assignee
     */
    public String getAssignee() {
        return assignee;
    }
}