package de.ph.sac.controller.dto;

public class CompleteTask {

    private String signature;
    private String id;

    public String getSignature() {
        return signature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}