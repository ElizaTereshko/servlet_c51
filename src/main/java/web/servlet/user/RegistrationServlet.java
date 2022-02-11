package web.servlet.user;

import entity.User;
import service.UserService;
import storage.memory.InMemoryUserStorage;
import web.Constants;
import web.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.REGISTRATION_LINK, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        UserValidator userValidator = new UserValidator();
        if (userValidator.existsByLogin(login)){
            req.setAttribute("msgUserExists", "User with this login already exists");
            req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        } else {
            userService.saveUser(new User(login, password));
            resp.sendRedirect(Constants.HOME_LINK);
        }
    }
}


