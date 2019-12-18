/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.BookingBLO;

/**
 *
 * @author tuannnh
 */
public class DeleteBookingAction {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    
    private int bookingId;
    private String lastSearchValue;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    
    public DeleteBookingAction() {
    }
    
    public String execute() throws Exception {
        String url = ERROR;
        BookingBLO blo = new BookingBLO();
        if(blo.delete(bookingId)){
            url = SUCCESS;
        }
        return url;
    }
    
}
