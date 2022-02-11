package web.servlet.user;

import service.CalculationResultService;
import web.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGOUT_LINK)
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculationResultService calculationResultService = new CalculationResultService();
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        if (login != null) {
            calculationResultService.deleteResultHistory(login);
            session.invalidate();
        }
        resp.sendRedirect(Constants.HOME_LINK);
    }
}
