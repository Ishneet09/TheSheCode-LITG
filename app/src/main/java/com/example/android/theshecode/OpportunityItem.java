package com.example.android.theshecode;

public class OpportunityItem {

    private String form;
    private String deadline;
    private String description;

    public OpportunityItem(){

    }

    public OpportunityItem(String form, String deadline, String description){
        this.form = form;
        this.deadline = deadline;
        this.description = description;
    }

    public String getForm() {
        return form;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }
}
