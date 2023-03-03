package Servlets;

import Logging.MyLogger;
import Services.UserService;
import Utils.RequestArgChecker;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet processes the user HTTP methods to get and return a User as requested, and if permitted
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@WebServlet(name = "UserServlet", value = {"/user", "/user?"})
public class UserServlet extends HttpServlet {
    /**
     * This get method returns a single User object, or all User objects based on arguments passed in the HTTP request
     * String array 'paramInfo' contains: paramInfo[0] = parameter, paramInfo[1] = value
     *
     * @param request  Request from client
     * @param response Response to client
     * @throws ServletException not thrown
     * @throws IOException      For input and output exceptions that can occur at runtime
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(202);
        response.setContentType("application/json");
        JSONObject jOBj = new JSONObject();
        String[] paramInfo = {"", ""};

        try {
            paramInfo = RequestArgChecker.handleRequest(request, response);
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 3);
        }

        if ("firstName".equals(paramInfo[0])) {
            jOBj.put("Requested User", UserService.getUserByFirstName(paramInfo[1]));
        } else {
            jOBj.put("Users", UserService.getAllUsers());
        }

        response.getWriter().print(jOBj);
    }
}
