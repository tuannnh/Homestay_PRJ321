/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.BillBLO;
import homestay.blos.BookingBLO;
import homestay.entities.Booking;

/**
 *
 * @author tuannnh
 */
public class CreateBillAction {

    private int bookingId;
    private boolean bike, bbq, breakfast;
    private Booking booking;
    private String dateComplete, checkOutBy;
    private double total;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public String getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(String dateComplete) {
        this.dateComplete = dateComplete;
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

    public Booking getBooking() {
        return booking;
    }

    public CreateBillAction() {
    }

    public String execute() throws Exception {
        String newDate = convertToSqlDate(dateComplete);
        BookingBLO bookingBLO = new BookingBLO();
        booking = bookingBLO.findByPrimaryKey(bookingId);
        BillBLO billBLO = new BillBLO();
        String fullname = booking.getFullname();
        if(billBLO.insert(bookingId, fullname, bbq, bike, breakfast, newDate, checkOutBy, total) && bookingBLO.completeBooking(booking, true)){
          return "success"; 
        }
        return "error";
    }

    private String convertToSqlDate(String date) {
        String[] temp = date.split("/");
        String convertedDate = temp[2] + "-" + temp[1] + "-" + temp[0];
        return convertedDate;
    }

}
