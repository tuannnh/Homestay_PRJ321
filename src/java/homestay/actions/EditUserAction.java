/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.UserBLO;
import homestay.entities.Users;

/**
 *
 * @author tuannnh
 */
public class EditUserAction {

    private String username, fullname, role, lastSearchValue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public EditUserAction() {
    }

    public String execute() throws Exception {
        UserBLO blo = new UserBLO();
        Users editUser = blo.findByPrimaryKey(username);
        fullname = editUser.getFullname();
        role = editUser.getRole();
        return "success";
    }

}
