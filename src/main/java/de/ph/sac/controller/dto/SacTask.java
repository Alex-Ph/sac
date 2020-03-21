package de.ph.sac.controller.dto;

public class SacTask {

    private String id;
    private String name;
    private String assignee;

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
	}

    /**
     * @return the assignee
     */
    public String getAssignee() {
        return assignee;
    }
}