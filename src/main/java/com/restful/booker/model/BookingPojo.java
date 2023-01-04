package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {
    /*{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}*/
    private String firstName;
    private String lastName;
    private boolean depositPaid;
    private String additionalNeeds;
    private int totalPrice;
    private HashMap<String,String> bookingDates;

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public boolean isDepositpaid() {
        return depositPaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositPaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalNeeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalNeeds = additionalneeds;
    }

    public int getTotalprice() {
        return totalPrice;
    }

    public void setTotalprice(int totalprice) {
        this.totalPrice = totalprice;
    }

    public HashMap<String, String> getBookingdates() {
        return bookingDates;
    }

    public void setBookingdates(HashMap<String, String> bookingdates) {
        this.bookingDates = bookingdates;
    }
}
