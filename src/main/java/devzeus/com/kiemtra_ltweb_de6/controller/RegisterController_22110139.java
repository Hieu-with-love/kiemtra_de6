package devzeus.com.kiemtra_ltweb_de6.controller;

import devzeus.com.kiemtra_ltweb_de6.model.User;
import devzeus.com.kiemtra_ltweb_de6.service.UserService_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.impl.UserServiceImpl_22110139;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register", "/dang-ky"})
public class RegisterController_22110139 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService_22110139 userService = new UserServiceImpl_22110139();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullname");
        boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
        boolean isActive = Boolean.parseBoolean(req.getParameter("active"));
        String confirmPassword = req.getParameter("confirmPassword");
        String msg = "";

        if (username == null || password == null){
            msg = "Username or password cannot be null";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }

        assert password != null;
        if (!password.equals(confirmPassword)){
            msg = "Passwords do not match";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullName);
        user.setPhone(phone);
        user.setEmail(email);
        user.setActive(isActive);
        user.setAdmin(admin);

        boolean isSuccess = userService.register(user);
        if (!isSuccess){
            msg = "Username or password incorrect";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }else{
            msg = "Registration successful";
            req.setAttribute("alert", msg);
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
