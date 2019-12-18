/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionContext;
import homestay.blos.BillBLO;
import homestay.blos.BookingBLO;
import homestay.blos.RoomBLO;
import homestay.entities.Bills;
import homestay.entities.Booking;
import homestay.entities.Rooms;
import homestay.models.CheckOutModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tuannnh
 */
public class SearchBillAction {

    private String searchBillValue;
    private String lastSearchValue;
    List<CheckOutModel> historyList;

    public String getSearchBillValue() {
        return searchBillValue;
    }

    public void setSearchBillValue(String searchBillValue) {
        this.searchBillValue = searchBillValue;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public List<CheckOutModel> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<CheckOutModel> historyList) {
        this.historyList = historyList;
    }

    public SearchBillAction() {
    }

    public String execute() throws Exception {
        if (lastSearchValue != null) {
            searchBillValue = lastSearchValue;
        } else if (lastSearchValue == null && searchBillValue == null) {
            searchBillValue = "";
        }
        Booking booking;
        historyList = new ArrayList<>();
        List<Rooms> bookedRooms;
        int singleRoomBooked;
        int coupleRoomBooked;
        int familyRoomBooked;
        boolean bike, bbq, breakfast;
        String completeDate, checkOutBy, checkIn, checkOut;
        double total;

        BookingBLO bookingBLO = new BookingBLO();
        RoomBLO roomBLO = new RoomBLO();
        BillBLO billBLO = new BillBLO();
        Map session = ActionContext.getContext().getSession();
        String role = (String) session.get("ROLE");
        String username = (String) session.get("USER");
        List<Bills> listBills;
        if (role.equals("user")) {
            // Add in BILLBLO
            listBills = billBLO.findByUsername(username);
        } else {
            listBills = billBLO.findByLikeName(searchBillValue);
        }

        for (Bills bill : listBills) {

            booking = bookingBLO.findByPrimaryKey(bill.getBookingId());

            checkIn = booking.getCheckIn();
            checkOut = booking.getCheckOut();

            bookedRooms = roomBLO.getBookedRooms(bill.getBookingId());

            singleRoomBooked = 0;
            coupleRoomBooked = 0;
            familyRoomBooked = 0;

            for (Rooms bookedRoom : bookedRooms) {
                if (bookedRoom.getRoomType().equalsIgnoreCase("Family")) {
                    familyRoomBooked++;
                } else if (bookedRoom.getRoomType().equalsIgnoreCase("Couple")) {
                    coupleRoomBooked++;
                } else {
                    singleRoomBooked++;
                }
            }

            bike = bill.getBike();
            bbq = bill.getBbq();
            breakfast = bill.getBreakfast();

            completeDate = bill.getCompleteDate();

            checkOutBy = bill.getCheckoutBy();

            total = bill.getTotal();

            CheckOutModel checkOutModel = new CheckOutModel(singleRoomBooked, coupleRoomBooked, familyRoomBooked, booking.getFullname(), checkIn, checkOut, completeDate, checkOutBy, total, bike, bbq, breakfast);
            historyList.add(checkOutModel);
        }

        return "success";
    }

}
