package com.xworkz.servlet.dto;

public class MuseumTicketFormDto {
    private String customerName;
    private int adultMembers;
    private int childMembers;
    private String mobileNo;
    private String email;

    public MuseumTicketFormDto(String customerName, int adultMembers, int childMembers, String mobileNo, String email) {
        this.customerName = customerName;
        this.adultMembers = adultMembers;
        this.childMembers = childMembers;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "MuseumTicketFormDto{" +
                "customerName='" + customerName + '\'' +
                ", adultMembers=" + adultMembers +
                ", childMembers=" + childMembers +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAdultMembers() {
        return adultMembers;
    }

    public void setAdultMembers(int adultMembers) {
        this.adultMembers = adultMembers;
    }

    public int getChildMembers() {
        return childMembers;
    }

    public void setChildMembers(int childMembers) {
        this.childMembers = childMembers;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
