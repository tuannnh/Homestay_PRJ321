/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.models;

import java.io.Serializable;

/**
 *
 * @author tuannnh
 */
public class CheckOutModel implements Serializable{
    private int singleRoomBooked, coupleRoomBooked, familyRoomBooked;
    private String fullname, checkIn, checkOut, completeDate, checkOutBy;
    private double total;
    private boolean bike, bbq, breakfast;

    public CheckOutModel( int singleRoomBooked, int coupleRoomBooked, int familyRoomBooked, String fullname, String checkIn, String checkOut, String completeDate, String checkOutBy, double total, boolean bike, boolean bbq, boolean breakfast) {
        this.singleRoomBooked = singleRoomBooked;
        this.coupleRoomBooked = coupleRoomBooked;
        this.familyRoomBooked = familyRoomBooked;
        this.fullname = fullname;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.completeDate = completeDate;
        this.checkOutBy = checkOutBy;
        this.total = total;
        this.bike = bike;
        this.bbq = bbq;
        this.breakfast = breakfast;
    }
    


    public int getSingleRoomBooked() {
        return singleRoomBooked;
    }

    public void setSingleRoomBooked(int singleRoomBooked) {
        this.singleRoomBooked = singleRoomBooked;
    }

    public int getCoupleRoomBooked() {
        return coupleRoomBooked;
    }

    public void setCoupleRoomBooked(int coupleRoomBooked) {
        this.coupleRoomBooked = coupleRoomBooked;
    }

    public int getFamilyRoomBooked() {
        return familyRoomBooked;
    }

    public void setFamilyRoomBooked(int familyRoomBooked) {
        this.familyRoomBooked = familyRoomBooked;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getCheckOutBy() {
        return checkOutBy;
    }

    public void setCheckOutBy(String checkOutBy) {
        this.checkOutBy = checkOutBy;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isBike() {
        return bike;
    }

    public void setBike(boolean bike) {
        this.bike = bike;
    }

    public boolean isBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }
    
    
}
