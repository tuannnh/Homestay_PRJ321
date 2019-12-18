/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionContext;
import homestay.blos.BookingBLO;
import homestay.entities.Booking;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuannnh
 */
public class SearchBookingAction {

    private String searchBookingValue;
    private String lastSearchValue;
    List<Booking> listBookings;

    public String getSearchBookingValue() {
        return searchBookingValue;
    }

    public void setSearchBookingValue(String searchBookingValue) {
        this.searchBookingValue = searchBookingValue;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public List<Booking> getListBookings() {
        return listBookings;
    }

    public SearchBookingAction() {
    }

    public String execute() throws Exception {
        BookingBLO blo = new BookingBLO();
        HttpServletRequest request = ServletActionContext.getRequest();
        lastSearchValue = (String) request.getAttribute("SEARCH");
        if (lastSearchValue != null) {
            searchBookingValue = lastSearchValue;
        } else if (lastSearchValue == null && searchBookingValue == null) {
            searchBookingValue = "";
        }
        Map session = ActionContext.getContext().getSession();
        String role = (String) session.get("ROLE");
        String username = (String) session.get("USER");
        if (role.equals("admin") || role.equals("staff")) {
            listBookings = blo.findByLikeName(searchBookingValue);
        } else {
            listBookings = blo.findByUsername(username);
        }
        String uri = request.getRequestURI();

        if (!uri.contains("admin") &&  !uri.contains("staff") && !uri.contains("user")) {
            if (role.equals("admin")) {
                return "admin";
            }
            if(role.equals("staff")){
                return "staff";
            }
            if(role.equals("user")){
                return "user";
            }
        }
        return "home";

    }
}
