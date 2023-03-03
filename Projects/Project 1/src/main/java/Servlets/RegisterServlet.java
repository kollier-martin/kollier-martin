package Servlets;

import Logging.MyLogger;
import POSTModels.RegisterInfo;
import Services.UserService;
import Utils.JWTUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This servlet processes the user HTTP methods and handles the passing of a Registered User as requested, and if permitted
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    /**
     * Handles the request for user registration
     *
     * @param request  Request from client
     * @param response Response to client
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jObj = new JSONObject();
        InputStream requestBody;

        try {
            requestBody = request.getInputStream();
            Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
            String jsonText = sc.useDelimiter("\\A").next();

            ObjectMapper mapper = new ObjectMapper();
            RegisterInfo newUser = mapper.readValue(jsonText, RegisterInfo.class);

            UserService.register(newUser.getFirstname(),
                    newUser.getLastname(), newUser.getUsername(),
                    newUser.getPassword());

            jObj.put("Token", JWTUtil.createJWT(request));
            response.setStatus(202);
            response.setContentType("application/json");
            response.getWriter().write(jObj.toString());
        } catch (IOException e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 3);
        }
    }
}
