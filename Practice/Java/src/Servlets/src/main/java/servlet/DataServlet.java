package servlet;

import dao.DataDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PersistenceService;

import java.io.IOException;

@WebServlet(name = "DataServlet", value = "/data")
public class DataServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //send POST with body containing string, integer and bool
        String s = req.getParameter("name");
        Integer i = Integer.parseInt(req.getParameter("age"));
        boolean b = Boolean.parseBoolean(req.getParameter("active"));

        DataDAO data = new DataDAO(s, i, b);

        PersistenceService.setData(data);

        resp.setStatus(202);
        resp.getWriter().print("Data accepted.");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DataDAO data = PersistenceService.getData();

        String s = data.getName();
        Integer i = data.getAge();
        boolean b = data.isActive();

        resp.setStatus(200);
        resp.getWriter().print("Data: " + s + ", " + i.toString() + ", " + b);
    }
}
