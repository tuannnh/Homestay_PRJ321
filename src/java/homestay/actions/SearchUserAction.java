/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.UserBLO;
import homestay.entities.Users;
import java.util.List;

/**
 *
 * @author tuannnh
 */
public class SearchUserAction {

    private String searchUserValue;
    private String lastSearchValue;
    List<Users> listUsers;

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String getSearchUserValue() {
        return searchUserValue;
    }

    public void setSearchUserValue(String searchUserValue) {
        this.searchUserValue = searchUserValue;
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public SearchUserAction() {
    }

    public String execute() throws Exception {
        UserBLO blo = new UserBLO();
        if (lastSearchValue != null) {
            searchUserValue = lastSearchValue;
        } else if (lastSearchValue == null && searchUserValue == null) {
            searchUserValue = "";
        }
        listUsers = blo.findByLikeName(searchUserValue);
        return "success";
    }

}
