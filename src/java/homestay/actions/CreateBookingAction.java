/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionContext;
import homestay.blos.BookingBLO;
import homestay.blos.RoomBLO;
import homestay.entities.Rooms;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tuannnh
 */
public class CreateBookingAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String checkIn, checkOut, fullname, username, couponId, phone, lastSearchValue;
    private int bookingId, people, single, couple, family;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSingle() {
        return single;
    }

    public void setSingle(int single) {
        this.single = single;
    }

    public int getCouple() {
        return couple;
    }

    public void setCouple(int couple) {
        this.couple = couple;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public CreateBookingAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        username = (String) session.get("USER");
        BookingBLO blo = new BookingBLO();
        String convertedCheckIn = convertToSqlDate(checkIn);
        String convertedCheckOut = convertToSqlDate(checkOut);
        bookingId = blo.insert(username, convertedCheckIn, convertedCheckOut, people, couponId, fullname, phone);
        if (bookingId > 0) {
            RoomBLO roomBLO = new RoomBLO();
            List<Rooms> emptyRooms = roomBLO.getEmptyRooms(convertedCheckIn, convertedCheckOut);
            for (Rooms emptyRoom : emptyRooms) {
                if (emptyRoom.getRoomType().equals("Single")) {
                    if (single > 0) {
                        blo.insertBookingRoom(bookingId, emptyRoom.getRoomNo());
                        single--;
                    }
                }
                if (emptyRoom.getRoomType().equals("Couple")) {
                    if (couple > 0) {
                        blo.insertBookingRoom(bookingId, emptyRoom.getRoomNo());
                        couple--;
                    }
                }
                if (emptyRoom.getRoomType().equals("Family")) {
                    if (family > 0) {
                        blo.insertBookingRoom(bookingId, emptyRoom.getRoomNo());
                        family--;
                    }
                }
            }
            url = SUCCESS;
        }
        return url;
    }

    private String convertToSqlDate(String date) {
        String[] temp = date.split("/");
        String convertedDate = temp[2] + "-" + temp[1] + "-" + temp[0];
        return convertedDate;
    }

}
