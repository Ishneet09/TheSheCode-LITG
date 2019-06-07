package com.example.android.theshecode;

public class StudyPartnerItem {

    private String nameSP;
    private String locationSP;
    private String emailSP;
    private String reasonSP;

    public StudyPartnerItem(){

    }

    public StudyPartnerItem(String nameSP, String locationSP, String emailSP, String reasonSP ){
        this.nameSP = nameSP;
        this.locationSP = locationSP;
        this.emailSP = emailSP;
        this.reasonSP = reasonSP;
    }

    public String getNameSP() {
        return nameSP;
    }

    public String getLocationSP() {
        return locationSP;
    }

    public String getEmailSP() {
        return emailSP;
    }

    public String getReasonSP() {
        return reasonSP;
    }
}
