/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.BookingBLO;
import homestay.blos.CouponBLO;
import homestay.blos.RoomBLO;
import homestay.entities.Booking;
import homestay.entities.Rooms;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author tuannnh
 */
public class CheckOutAction {

    private int bookingId, singleRoomBooked, coupleRoomBooked, familyRoomBooked;
    private String currentDate;
    private Booking booking;
    private long daysBooked;
    private double discount, total;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public long getDaysBooked() {
        return daysBooked;
    }

    public void setDaysBooked(long daysBooked) {
        this.daysBooked = daysBooked;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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

    public CheckOutAction() {
    }

    public String execute() throws Exception {

        BookingBLO bookingBLO = new BookingBLO();
        booking = bookingBLO.findByPrimaryKey(bookingId);

        RoomBLO roomBLO = new RoomBLO();
        List<Rooms> bookedRooms = roomBLO.getBookedRooms(bookingId);
        for (Rooms bookedRoom : bookedRooms) {
            if (bookedRoom.getRoomType().equals("Single")) {
                singleRoomBooked++;
            }
            if (bookedRoom.getRoomType().equals("Couple")) {
                coupleRoomBooked++;
            }
            if (bookedRoom.getRoomType().equals("Family")) {
                familyRoomBooked++;
            }
        }

        discount = 0;
        String couponId = booking.getCouponId();
        if (!couponId.equals("")) {
            CouponBLO couponBLO = new CouponBLO();
            discount = couponBLO.getDiscount(couponId) * 100;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        currentDate = dtf.format(now);

        LocalDate checkIn = LocalDate.parse(booking.getCheckIn(), dtf);
        LocalDate checkOut = LocalDate.parse(booking.getCheckOut(), dtf);

        daysBooked = ChronoUnit.DAYS.between(checkIn, checkOut);

        double amount = ((100 * singleRoomBooked) + (180 * coupleRoomBooked) + (320 * familyRoomBooked)) * daysBooked;

        total = amount - (amount * discount) / 100;

        return "success";
    }

}
