package devzeus.com.kiemtra_ltweb_de6.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/user/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bookId = Long.parseLong(req.getParameter("bookId"));
        //List<Rating> ratings = ratingService
        req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
    }
}