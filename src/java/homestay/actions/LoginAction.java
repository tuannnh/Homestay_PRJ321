/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.UserBLO;
import homestay.entities.Users;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author tuannnh
 */
public class LoginAction extends ActionSupport {

    private static final String ERROR = "error";
    private static final String LOGGED = "logged";
    private static final String SUCCESS = "success";

    private String username, password, errorUsername;

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

    public String getErrorUsername() {
        return errorUsername;
    }

    public void setErrorUsername(String errorUsername) {
        this.errorUsername = errorUsername;
    }

    public LoginAction() {

    }

    @Override
    public String execute() throws Exception {
        String url = ERROR;
        Map session = ActionContext.getContext().getSession();
        String role = (String) session.get("ROLE");
        if (role == null) {
            UserBLO blo = new UserBLO();
            role = blo.checkLogin(username, password);

            HttpServletRequest request = ServletActionContext.getRequest();
            if (role.equals("failed")) {
                request.setAttribute("ERROR", "Invalid Username or Password");
                errorUsername = username;
            } else {
                url = SUCCESS;
                Users user = blo.findByPrimaryKey(username);
                session.put("USER", username);
                session.put("ROLE", role);
                session.put("USEROBJECT", user);
            }
        } else {
            url = LOGGED;
        }

        return url;
    }

}
