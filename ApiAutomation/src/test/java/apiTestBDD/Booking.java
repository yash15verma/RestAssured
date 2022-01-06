package apiTestBDD;

import java.util.Date;
import java.util.List;

public class Booking {

    public String firstName;
    public String lastName;
    public Integer totalPrice;
    public Boolean depositPaid;
    public String additionalNeeds;
    //public String checkInDate;
   // public String checkOutDate;

    List<Object> bookingDates;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

   /* public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }*/

    public List<Object> getBookingDates(){
        return bookingDates;
    }

    public void setBookingDates(List<Object> bookingDates){
        this.bookingDates = bookingDates;
    }

    public String getBookingDetails() {
        return (this.firstName + " " + this.lastName + " " + this.totalPrice + " " + this.depositPaid + " " + this.checkInDate + " " + this.checkOutDate + " " + this.additionalNeeds);
    }


}
