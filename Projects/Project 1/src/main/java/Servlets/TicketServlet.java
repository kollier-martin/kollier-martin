package Servlets;

import Logging.MyLogger;
import POSTModels.NewTicket;
import Utils.JWTUtil;
import Utils.RequestArgChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import services.TicketService;
import services.TrainService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This servlet processes the user HTTP methods to get and return Ticket Info as requested, and if permitted
 *
 * @author Kollier Martin and Erika Johnson
 * @date 10/23/2021
 */

@WebServlet(name = "TicketServlet", value = {"/ticket", "/ticket?"})
public class TicketServlet extends HttpServlet {
    // Global parameters
    int trainID = 0;
    int id = 0;
    String[] paramInfo = {};
    InputStream requestBody = null;
    String jsonText;

    /**
     * This get method returns a single Ticket object, or all Ticket objects based on arguments passed in the HTTP request
     * String array 'paramInfo' contains: paramInfo[0] = parameter, paramInfo[1] = value
     *
     * @param request  Request from client
     * @param response Response to client
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(202);
        response.setContentType("application/json");
        JSONObject jOBj = new JSONObject();

        try {
            paramInfo = RequestArgChecker.handleRequest(request, response);

            if ("id".equals(paramInfo[0])) {
                try {
                    id = (Integer.parseInt(paramInfo[1]));
                    jOBj.put("Requested Ticket", TicketService.getByID(id));
                } catch (NumberFormatException e) {
                    MyLogger.getMyLogger().writeLog(e.toString(), 3);
                }
            } else if ("myTickets".equals(paramInfo[0])) {
                String username;

                try {
                    username = (paramInfo[1]);
                    ArrayList<Object> myTickets = (ArrayList<Object>) TicketService.getByUser(username);

                    if (myTickets != null) {
                        jOBj.put(username + "'s Tickets", myTickets);
                    } else {
                        jOBj.put("Status", "User Has No Tickets");
                    }
                } catch (Exception e) {
                    MyLogger.getMyLogger().writeLog(e.toString(), 3);
                }
            } else if ((paramInfo[0] == null)) {
                jOBj.put("All Tickets", TicketService.getAllTickets());
            }
            response.getWriter().print(jOBj);
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 3);
        }
    }

    /**
     * Every POST request is handled in this method. It changes data within the server
     *
     * @param request  Client Request
     * @param response Response to Client
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jOBj = new JSONObject();
        response.setContentType("application/json");
        response.setStatus(202);

        // Create ticket and assign it to User
        try {
            paramInfo = RequestArgChecker.handleRequest(request, response);
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 4);
        }

        try {
            String token = request.getHeader("Authorization");
            if (JWTUtil.parseJWT(token)) {
                if ("new".equals(paramInfo[0])) {
                    try {
                        requestBody = request.getInputStream();
                        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
                        jsonText = sc.useDelimiter("\\A").next();

                        ObjectMapper mapper = new ObjectMapper();
                        NewTicket newTicket = mapper.readValue(jsonText, NewTicket.class);

                        TicketService.create(newTicket.getUsername(), newTicket.getTid(), newTicket.getTotalTickets(), newTicket.getArrivalStation(),
                                newTicket.getDepartureStation());

                        jOBj.clear();
                        jOBj.put("Status", "Successful Ticket to User Assigning");

                        response.getWriter().write(jOBj.toString());
                    } catch (IOException e) {
                        MyLogger.getMyLogger().writeLog(e.toString(), 3);
                    }
                } else if ("getID".equals(paramInfo[0])) {
                    requestBody = request.getInputStream();
                    Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
                    jsonText = sc.useDelimiter("\\A").next();

                    ObjectMapper mapper = new ObjectMapper();
                    NewTicket newTicket = mapper.readValue(jsonText, NewTicket.class);

                    trainID = TrainService.getTrainByStation(newTicket.getDepartureStation());
                    jOBj.clear();
                    jOBj.put("trainID", trainID);

                    response.getWriter().write(jOBj.toString());
                }
            }
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 5);
        }
    }

    /**
     * Every PUT request is handled in this method. It modifies the data within the server
     *
     * @param request  Client Request
     * @param response Response to Client
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jOBj = new JSONObject();
        response.setContentType("application/json");
        response.setStatus(202);

        try {
            paramInfo = RequestArgChecker.handleRequest(request, response);
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 4);
        }

        try {
            String token = request.getHeader("Authorization");
            if (JWTUtil.parseJWT(token)) {
                if ("checkin".equals(paramInfo[0])) {
                    try {
                        String username = request.getHeader("Username");
                        int trainID = Integer.parseInt(request.getHeader("TrainID"));

                        TicketService.checkIn(username, trainID);

                        jOBj.put("Status", username + " Successful Check-In");

                        response.getWriter().write(jOBj.toString());
                    } catch (Exception e) {
                        MyLogger.getMyLogger().writeLog(e.toString(), 3);
                    }
                }
            }
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 5);
        }
    }

    /**
     * Every DELETE request is handled in this method. It deletes data within the server
     *
     * @param request  Client Request
     * @param response Response to Client
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jOBj = new JSONObject();
        response.setContentType("application/json");
        response.setStatus(202);

        try {
            paramInfo = RequestArgChecker.handleRequest(request, response);
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 4);
        }

        try {
            String token = request.getHeader("Authorization");
            if (JWTUtil.parseJWT(token)) {
                if ("cancel".equals(paramInfo[0])) {
                    try {
                        String username = request.getHeader("Username");
                        int trainID = Integer.parseInt(request.getHeader("TrainID"));
                        boolean success = TicketService.cancelTicket(username, trainID);

                        jOBj.put("Status", username + " " + "Ticket Cancel Success = "
                                + success);

                        response.getWriter().write(jOBj.toString());
                    } catch (Exception e) {
                        MyLogger.getMyLogger().writeLog(e.toString(), 3);
                    }
                }
            }
        } catch (Exception e) {
            MyLogger.getMyLogger().writeLog(e.toString(), 5);
        }

    }
}
