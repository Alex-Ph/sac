package de.ph.sac.controller.dto;

/**
 * ToDo: also provide candidates, so we know if we are allowed to claim this
 * task For now user see all tasks and will be able to claim all of em (check
 * right mgmt in camunda)
 */
public class Message {

    private String message;
    
    public Message(){
    }

    public Message(String message){
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}