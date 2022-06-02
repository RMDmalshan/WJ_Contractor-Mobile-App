package com.example.wj_contractor;

import java.util.Date;

public class AddNewSite {

    private String SiteName;
    private String SupervisorName;
    private String Location;
    private String StartDate;
    private String EndDate;
    private String SiteID;


    public AddNewSite(String siteName, String supervisorName, String location, String startDate, String endDate, String siteID) {
        this.SiteName = siteName;
        this.SupervisorName = supervisorName;
        this.Location = location;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.SiteID = siteID;
    }




    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getSupervisorName() {
        return SupervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        SupervisorName = supervisorName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getSiteID() {
        return SiteID;
    }

    public void setSiteID(String siteID) {
        SiteID = siteID;
    }
}
