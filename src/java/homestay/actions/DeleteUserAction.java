/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.UserBLO;

/**
 *
 * @author tuannnh
 */
public class DeleteUserAction {
    private String username, lastSearchValue;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public DeleteUserAction() {
    }
    
    public String execute() throws Exception {
        UserBLO blo = new UserBLO();
        blo.delete(username);
        return "success";
    }
    
}
