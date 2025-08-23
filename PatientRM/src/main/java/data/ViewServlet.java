package data;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Patient> received = new PatientDao().getPatients();
            HttpSession session = req.getSession(true);
            session.setAttribute("people", received);
            RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
            rd.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
