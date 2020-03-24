package de.ph.sac.controller;

import java.util.Date;

import org.camunda.bpm.engine.task.DelegationState;
import org.camunda.bpm.engine.task.Task;


/**
 * Test class where only id and name are usable
 * Other methods will do nothing and return null
 */
class CamundaTask implements Task {

    private String id;
    private String name;

    CamundaTask(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDescription(String description) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getPriority() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPriority(int priority) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getOwner() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setOwner(String owner) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAssignee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAssignee(String assignee) {
        // TODO Auto-generated method stub

    }

    @Override
    public DelegationState getDelegationState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDelegationState(DelegationState delegationState) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getProcessInstanceId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getExecutionId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getProcessDefinitionId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCaseInstanceId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCaseInstanceId(String caseInstanceId) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCaseExecutionId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCaseDefinitionId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getCreateTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTaskDefinitionKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getDueDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDueDate(Date dueDate) {
        // TODO Auto-generated method stub

    }

    @Override
    public Date getFollowUpDate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFollowUpDate(Date followUpDate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delegate(String userId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setParentTaskId(String parentTaskId) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getParentTaskId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSuspended() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getFormKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTenantId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTenantId(String tenantId) {
        // TODO Auto-generated method stub

    }

}