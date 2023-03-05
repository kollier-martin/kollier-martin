package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PingServlet", value = "/ping")
public class PingServlet extends HttpServlet {
    /**
     * This will take a simple GET request and respond with "Pong!" and status 200.
     *
     * @param req  incoming request
     * @param resp outgoing response
     * @throws IOException exception to be thrown on IO issue
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(200);
        resp.getWriter().print("Pong!");
    }
}