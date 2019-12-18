/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.UserBLO;
import java.util.Map;

/**
 *
 * @author tuannnh
 */
public class CreateUserAction extends ActionSupport {

    private static final String CREATEERROR = "createError";
    private static final String REGISTERERROR = "registerError";
    private static final String ADMIN = "admin";
    private static final String NEWUSER = "newUser";

    private String username, password, fullname, role, lastSearchValue, createError, errorUsername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String getCreateError() {
        return createError;
    }

    public void setCreateError(String createError) {
        this.createError = createError;
    }

    public String getErrorUsername() {
        return errorUsername;
    }

    public void setErrorUsername(String errorUsername) {
        this.errorUsername = errorUsername;
    }

    public CreateUserAction() {
    }

    public String execute() throws Exception {
        UserBLO blo = new UserBLO();
        Map session = ActionContext.getContext().getSession();
        String currentRole = (String) session.get("ROLE");
        if (currentRole == null) {
            if (blo.insert(username, password, fullname)) {
                return NEWUSER;
            }
            errorUsername = username;
            createError = "Username is existed!";
            return REGISTERERROR;
        }
        if (blo.insert(username, password, fullname, role)) {
            return ADMIN;
        }
        errorUsername = username;
        createError = "Username is existed!";
        return CREATEERROR;

    }

}
