/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import homestay.actions.CreateUserAction;
import homestay.actions.LoginAction;
import homestay.actions.UpdateUserAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.apache.struts2.StrutsStatics.HTTP_REQUEST;

/**
 *
 * @author tuannnh
 */
public class Authorize implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        final ActionContext context = ai.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
        HttpSession session = request.getSession(true);

        String role = (String) session.getAttribute("ROLE");

        String uri = request.getRequestURI();
        //Logged in
        if (role != null) {
            //want to login while logged in
            if (ai.getAction() instanceof LoginAction) {
                return "notallow";
            }
            //Access by role
            if (uri.contains("/admin/") || uri.contains("DeleteUserAction") || uri.contains("EditUserAction") || uri.contains("RoomAction")) {
                if (!role.equals("admin")) {
                    return "notallow";
                }
            } else if (uri.contains("/staff/")) {
                if (!role.equals("staff")) {
                    return "notallow";
                }
            } else if (uri.contains("/user/")) {
                if (!role.equals("user")) {
                    return "notallow";
                }
            }
        } else {
            if (role == null && !(ai.getAction() instanceof LoginAction) && !(ai.getAction() instanceof CreateUserAction)) {
                return "notallow";
            }
        }
        return ai.invoke();

    }
}
