package Servlets;

import Logging.MyLogger;
import Utils.JWTUtil;
import org.json.JSONObject;
import services.LoginService;
import services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet processes the user HTTP methods and handles the validation of an existing User as requested, and if permitted
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@WebServlet(name = "LoginServlet", value = {"/login", "/login?"})
public class LoginServlet extends HttpServlet {
    /**
     * Every POST request is handled in this method. It changes data within the server
     *
     * @param request  Client Request
     * @param response Response to Client
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jObj = new JSONObject();
        String jwt = JWTUtil.createJWT(request);

        response.setStatus(202);
        response.setContentType("application/json");

        if (LoginService.validate(request.getParameter("username"), request.getParameter("password"))) {
            // Parse token for validation
            if (JWTUtil.parseJWT(jwt)) {
                // Accept input and add information to Object
                jObj.put("Validation", jwt);
                jObj.put("User Exists", true);
                jObj.put("Role of User", UserService.getRoleID(request.getParameter("username")));

                try {
                    response.getWriter().write(jObj.toString());
                } catch (IOException e) {
                    MyLogger.getMyLogger().writeLog(e.toString(), 3);
                }
            }
        } else {
            jObj.put("User Exists", false);

            try {
                response.getWriter().write(jObj.toString());
            } catch (IOException e) {
                MyLogger.getMyLogger().writeLog(e.toString(), 3);
            }
        }
    }
}
