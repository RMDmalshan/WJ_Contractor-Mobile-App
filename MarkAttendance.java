package com.example.wj_contractor;

public class MarkAttendance {

    private String workername;
    private String id;
    private String date;

    public MarkAttendance(String workername, String id, String date) {
        this.workername = workername;
        this.id = id;
        this.date = date;
    }


    public String getWorkername() {
        return workername;
    }

    public void setWorkername(String workername) {
        this.workername = workername;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
