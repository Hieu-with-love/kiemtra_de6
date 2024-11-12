package devzeus.com.kiemtra_ltweb_de6.controller;

import devzeus.com.kiemtra_ltweb_de6.model.User;
import devzeus.com.kiemtra_ltweb_de6.service.UserService_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.impl.UserServiceImpl_22110139;
import devzeus.com.kiemtra_ltweb_de6.utils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController_22110139 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService_22110139 userService = new UserServiceImpl_22110139();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRememberMe = remember != null;

        String msg = "This is default message";
        if (username == null || password == null){
            msg = "Username or password cannot be null";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
        boolean isSuccess = userService.login(username, password);
        if (!isSuccess){
            msg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", msg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }else{
            HttpSession session = req.getSession(true);
            User user = userService.findUserByName(username);
            session.setAttribute("account", user);
            if(isRememberMe){
                saveRememberMe(resp, username);
            }
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }
    }
    private void saveRememberMe(HttpServletResponse response, String username){
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
