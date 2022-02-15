package web.servlet.user;

import web.Constants;
import web.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.AUTHORIZATION_LINK, name = "AuthorizationServlet")
public class AuthorizationServlet extends HomeServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserValidator userValidator = new UserValidator();
        HttpSession session = req.getSession();
        if (userValidator.existsByLogin(login)) {
            if (userValidator.passwordIsTrue(login, password)) {
                session.setAttribute("login", login);
                resp.sendRedirect(Constants.HOME_LINK);
            } else {
                req.setAttribute("msgWrongPassword", "Wrong password");
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
            }
        } else {
            req.setAttribute("msgUserNotFound", "User is not found");
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
        }
    }
}

