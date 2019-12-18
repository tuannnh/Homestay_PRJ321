/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import homestay.blos.UserBLO;
import java.util.Map;

/**
 *
 * @author tuannnh
 */
public class UpdateUserAction {

    private String username, password, fullname, role, lastSearchValue, updateConfirm;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUpdateConfirm() {
        return updateConfirm;
    }

    public void setUpdateConfirm(String updateConfirm) {
        this.updateConfirm = updateConfirm;
    }

    public UpdateUserAction() {
    }

    public String execute() throws Exception {
        UserBLO blo = new UserBLO();
        Map session = ActionContext.getContext().getSession();
        String curRole = (String) session.get("ROLE");
        if (curRole.equals("admin")) {
            blo.update(username, role);
            return "admin";
        } else {
            blo.update(username, password, fullname);
            updateConfirm = "Your profile is updated!";
            return "nonadmin";
        }

    }

}
