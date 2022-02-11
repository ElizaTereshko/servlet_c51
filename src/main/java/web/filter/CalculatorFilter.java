package web.filter;

import web.Constants;
import web.validator.ParameterValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")){
            String theFirstValue = req.getParameter("theFirstValue");
            String theSecondValue = req.getParameter("theSecondValue");
            String operationSign = req.getParameter("operationSign");

            ParameterValidator parameterValidator = new ParameterValidator();
            if (parameterValidator.isNull(theFirstValue) && parameterValidator.isNull(theSecondValue)){
                if (parameterValidator.isBlank(theFirstValue) && parameterValidator.isBlank(theSecondValue)){
                    if (parameterValidator.isNumber(theFirstValue) && parameterValidator.isNumber(theSecondValue)){
                        if (parameterValidator.isNull(operationSign)){
                            if (theSecondValue.equals("0") && operationSign.equals("/")){
                                req.setAttribute("msgInfinity", "Infinity");
                                req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
                            }
                                chain.doFilter(req, res);
                        } else {
                            req.setAttribute("msgOperation", "Choose operation");
                            req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
                        }
                    } else {
                        req.setAttribute("msgInvalidData", "Invalid Data");
                        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
                    }
                } else {
                    req.setAttribute("msgInvalidData", "Invalid Data");
                    req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
                }
            } else {
                req.setAttribute("msgInvalidData", "Invalid Data");
                req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
