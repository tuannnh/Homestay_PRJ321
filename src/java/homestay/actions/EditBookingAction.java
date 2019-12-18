/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.BookingBLO;
import homestay.entities.Booking;

/**
 *
 * @author tuannnh
 */
public class EditBookingAction {
    private int bookingId;
    private String checkIn, checkOut, lastSearchValue;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public EditBookingAction() {
    }
    
    public String execute() throws Exception {
        BookingBLO blo = new BookingBLO();
        Booking currentBooking = blo.findByPrimaryKey(bookingId);
        checkIn = currentBooking.getCheckIn();
        checkOut = currentBooking.getCheckOut();
        
        return "success";
    }
    
}
