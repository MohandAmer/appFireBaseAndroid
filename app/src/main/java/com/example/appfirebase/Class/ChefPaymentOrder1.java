package com.example.appfirebase.Class;

public class ChefPaymentOrder1 {
    private String Address;
    private String GrandTotalPrice;
    private String MobileNumber;
    private String statues;
    private String Name;
    private String Note;
    private String RandomUID;

    public ChefPaymentOrder1() {

    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public String getRandomUID() {
        return RandomUID;
    }

    public void setRandomUID(String randomUID) {
        RandomUID = randomUID;
    }

    public ChefPaymentOrder1(String address, String grandTotalPrice, String mobileNumber,String statues, String name, String note, String RandomUID) {
        Address = address;
        GrandTotalPrice = grandTotalPrice;
        MobileNumber = mobileNumber;
        this.statues=statues;
        Name = name;
        Note = note;
        this.RandomUID=RandomUID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGrandTotalPrice() {
        return GrandTotalPrice;
    }

    public void setGrandTotalPrice(String grandTotalPrice) {
        GrandTotalPrice = grandTotalPrice;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
