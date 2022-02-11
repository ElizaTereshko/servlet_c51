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

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")){
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ParameterValidator validation = new ParameterValidator();
            if (validation.isNull(login) && validation.isNull(password)){
                if (validation.isBlank(login) && validation.isBlank(password)){
                   chain.doFilter(req, res);
                } else {
                    req.setAttribute("msgNotCreated", "User is not created");
                    req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, res);
                }
            } else {
                req.setAttribute("msgNotCreated", "User is not created");
                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
