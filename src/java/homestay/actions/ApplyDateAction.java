/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.BookingBLO;
import homestay.blos.CouponBLO;
import homestay.blos.RoomBLO;
import homestay.entities.Booking;
import homestay.entities.Rooms;
import java.util.List;

/**
 *
 * @author tuannnh
 */
public class ApplyDateAction extends ActionSupport {

    private static final String CREATE_ERROR = "createError";
    private static final String UPDATE_ERROR = "updateError";
    private static final String CREATE = "create";
    private static final String UPDATE = "update";

    private int bookingId, singleRoomRemain, coupleRoomRemain, familyRoomRemain, singleRoomBooked, coupleRoomBooked, familyRoomBooked;
    private String checkIn, checkOut, couponIdAvailable, lastSearchValue, bookingError;
    private Booking booking;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSingleRoomRemain() {
        return singleRoomRemain;
    }

    public void setSingleRoomRemain(int singleRoomRemain) {
        this.singleRoomRemain = singleRoomRemain;
    }

    public int getCoupleRoomRemain() {
        return coupleRoomRemain;
    }

    public void setCoupleRoomRemain(int coupleRoomRemain) {
        this.coupleRoomRemain = coupleRoomRemain;
    }

    public int getFamilyRoomRemain() {
        return familyRoomRemain;
    }

    public void setFamilyRoomRemain(int familyRoomRemain) {
        this.familyRoomRemain = familyRoomRemain;
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

    public Booking getBooking() {
        return booking;
    }

    public String getCouponIdAvailable() {
        return couponIdAvailable;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String getBookingError() {
        return bookingError;
    }

    public void setBookingError(String bookingError) {
        this.bookingError = bookingError;
    }

    
    public ApplyDateAction() {
    }

    public String execute() throws Exception {
        String url;
        RoomBLO roomBLO = new RoomBLO();

        String convertedCheckIn = convertToSqlDate(checkIn);
        String convertedCheckOut = convertToSqlDate(checkOut);

        //Get available coupon for the date
        CouponBLO couponBLO = new CouponBLO();
        if (couponBLO.getCouponIdByDate(convertedCheckIn, convertedCheckOut).size() > 0) {
            couponIdAvailable = couponBLO.getCouponIdByDate(convertedCheckIn, convertedCheckOut).get(0);
        }

        // Create new booking
        if (bookingId == 0) {
            List<Rooms> emptyRooms = roomBLO.getEmptyRooms(convertedCheckIn, convertedCheckOut);
            singleRoomRemain = 0;
            coupleRoomRemain = 0;
            familyRoomRemain = 0;
            for (Rooms emptyRoom : emptyRooms) {
                if (emptyRoom.getRoomType().equalsIgnoreCase("Single")) {
                    singleRoomRemain++;
                } else if (emptyRoom.getRoomType().equalsIgnoreCase("Couple")) {
                    coupleRoomRemain++;
                } else {
                    familyRoomRemain++;
                }
            }
            if ((singleRoomRemain + coupleRoomRemain + familyRoomRemain) > 0) {
                url = CREATE;
            } else {
                bookingError = "There are no remaining Rooms for the dates!";
                url = CREATE_ERROR;
            }
        } //Update exist Booking with bookingId
        else {
            BookingBLO bookingBLO = new BookingBLO();
            booking = bookingBLO.findByPrimaryKey(bookingId);

            singleRoomBooked = 0;
            coupleRoomBooked = 0;
            familyRoomBooked = 0;
            List<Rooms> bookedRooms = roomBLO.getBookedRooms(bookingId);
            for (Rooms bookedRoom : bookedRooms) {
                if (bookedRoom.getRoomType().equalsIgnoreCase("Family")) {
                    familyRoomBooked++;
                } else if (bookedRoom.getRoomType().equalsIgnoreCase("Couple")) {
                    coupleRoomBooked++;
                } else {
                    singleRoomBooked++;
                }
            }

            List<Rooms> emptyRooms = roomBLO.getEmptyRooms(convertedCheckIn, convertedCheckOut);
            singleRoomRemain = singleRoomBooked;
            coupleRoomRemain = coupleRoomBooked;
            familyRoomRemain = familyRoomBooked;
            for (Rooms emptyRoom : emptyRooms) {
                if (emptyRoom.getRoomType().equalsIgnoreCase("Single")) {
                    singleRoomRemain++;
                } else if (emptyRoom.getRoomType().equalsIgnoreCase("Couple")) {
                    coupleRoomRemain++;
                } else {
                    familyRoomRemain++;
                }
            }
            if ((singleRoomRemain + coupleRoomRemain + familyRoomRemain) > 0) {
                url = UPDATE;
            } else {
                bookingError = "There are no remaining Rooms for the dates!";
                url = UPDATE_ERROR;
            }
        }
        return url;
    }

    private String convertToSqlDate(String date) {
        String[] temp = date.split("/");
        String convertedDate = temp[2] + "-" + temp[1] + "-" + temp[0];
        return convertedDate;
    }

}
