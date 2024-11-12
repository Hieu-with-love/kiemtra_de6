package devzeus.com.kiemtra_ltweb_de6.controller.user;

import devzeus.com.kiemtra_ltweb_de6.model.Category_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.Video_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.CategoryService_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.VideoService_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.impl.CategoryServiceImpl_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.impl.VideoServiceImpl_22110139;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user/videos", "/user/videos-by-category", "/user/count-videos"})
public class VideoController_22110139 extends HttpServlet {
    VideoService_22110139 videoService = new VideoServiceImpl_22110139();
    CategoryService_22110139 categoryService = new CategoryServiceImpl_22110139();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/user/videos-by-category")) {
            // Lấy danh sách tất cả các thể loại
            List<Category_22110139> categories = categoryService.getAllCategories();
            req.setAttribute("categories", categories);

            // Lấy ID thể loại được chọn
            String categoryIdStr = req.getParameter("categoryId");
            List<Video_22110139> videos = null;

            if (categoryIdStr != null && !categoryIdStr.isEmpty()) {
                Long categoryId = Long.parseLong(categoryIdStr);
                // Lấy danh sách video theo categoryId
                videos = videoService.listAllVideos(categoryId);
                req.setAttribute("videos", videos);
                req.setAttribute("selectedCategoryId", categoryId);
            }

            req.getRequestDispatcher("/views/user/videos-by-category.jsp").forward(req, resp);
        } else if (uri.contains("/user/videos")) {
            Video_22110139 video = videoService.getVideoDetails(1);
            Category_22110139 category = categoryService.getCategory(video.getCategoryId());

            req.setAttribute("video", video);
            req.setAttribute("category", category);

            req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
        } else if (uri.contains("/user/count-videos")) {
            // Lấy tất cả các thể loại
            List<Category_22110139> categories = categoryService.getAllCategories();

            // Đếm số lượng video của từng thể loại
            for (Category_22110139 category : categories) {
                Video_22110139 video = videoService.getVideoDetails(category.getCategoryId());
                int videoCount = video.getVideoId();
                video.setViews(videoCount); // Set số lượng video vào category
            }

            // Đưa danh sách thể loại với số lượng video vào request để gửi đến JSP
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/views/user/count-videos.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
