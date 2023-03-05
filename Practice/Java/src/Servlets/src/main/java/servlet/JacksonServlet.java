package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DataDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PersistenceService;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "JacksonServlet", value = "/jackson")
public class JacksonServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ObjectMapper mapper = new ObjectMapper();
        DataDAO data = mapper.readValue(json, DataDAO.class);
        PersistenceService.setData(data);

        resp.setStatus(202);
        resp.setContentType("application/json");
        resp.getWriter().print("""
                {
                    "status" : "JSON accepted",
                    "data": %s
                }
                """.formatted(data));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DataDAO data = PersistenceService.getData();
        String json = mapper.writeValueAsString(data);

        resp.setStatus(200);
        resp.getWriter().print(json);
    }
}
