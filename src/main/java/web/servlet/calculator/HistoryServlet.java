package web.servlet.calculator;

import service.CalculationResultService;
import storage.memory.InMemoryCalculationResultStorage;
import web.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = Constants.HISTORY_CALCULATOR_LINK, name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    InMemoryCalculationResultStorage inMemoryCalculationResultStorage = new InMemoryCalculationResultStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CalculationResultService calculationResultService = new CalculationResultService();
        String login = (String) session.getAttribute("login");
        List <String> calculationResult = calculationResultService.getResultHistory(login);
        if (calculationResult == null){
            req.setAttribute("msgEmpty", "History is empty");
            req.getServletContext().getRequestDispatcher(Constants.HISTORY_JSP).forward(req, resp);
        }
        req.setAttribute("history", calculationResult);
        req.getServletContext().getRequestDispatcher(Constants.HISTORY_JSP).forward(req, resp);
    }
}
