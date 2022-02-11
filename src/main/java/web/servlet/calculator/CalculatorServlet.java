package web.servlet.calculator;

import entity.Operation;
import service.CalculationResultService;
import web.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.CALCULATOR_LINK, name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private CalculationResultService calculationResultService = new CalculationResultService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theFirstValue = req.getParameter("theFirstValue");
        String theSecondValue = req.getParameter("theSecondValue");
        String operationSign = req.getParameter("operationSign");

        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");

        Operation operation = new Operation(theFirstValue,theSecondValue,operationSign);
        CalculationResultService calculationResultService = new CalculationResultService();


        double result = calculationResultService.calculate(operation);
        calculationResultService.saveCalculationResult(operation, result, login);
        req.setAttribute("result", "Result =" + result);
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, resp);
    }
}
