package devzeus.com.kiemtra_ltweb_de6.controller.admin;

import devzeus.com.kiemtra_ltweb_de6.model.User;
import devzeus.com.kiemtra_ltweb_de6.service.UserService;
import devzeus.com.kiemtra_ltweb_de6.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/users", "/admin/user/add", "/admin/user/update", "/admin/user/delete", "/admin/user/view"})
public class UserController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("admin/users")) {
            List<User> users = userService.findAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);
        }else if (url.contains("admin/user/add")) {
            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
        } else if (url.contains("admin/user/update")) {

            String username = req.getParameter("username");
            User user = userService.findUserByName(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/admin/user-update.jsp").forward(req, resp);

        } else if (url.contains("admin/user/delete")) {
            String username = req.getParameter("username");
            userService.deleteUser(username);
            resp.sendRedirect(req.getContextPath() + "/admin/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("admin/user/add")) {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            addUser(req, resp);
        }
        else if (url.contains("admin/user/update")) {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            updateUser(req, resp);
        }
    }

    // Hàm addUser
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Lấy dữ liệu từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
        boolean active = Boolean.parseBoolean(req.getParameter("active"));
        String image = req.getParameter("pic");

        // Lấy file từ form
        String fname = "";
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads"; // Đường dẫn tương đối trong dự án
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Tạo thư mục nếu không tồn tại
        }

        try {
            Part filePart = req.getPart("pic");
            if (filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                // Chỉnh sửa tên file
                int index = fileName.lastIndexOf("."); // index của phần mở rộng file .jpg, .png, .jpeg
                String ext = fileName.substring(index + 1); // phần mở rộng file .jpg, .png, .jpeg
                fname = System.currentTimeMillis() + "." + ext;
                // Lưu file vào thư mục uploads
                String filePath = uploadPath + File.separator + fname;
                filePart.write(filePath);
            } else if (image != null) {
                fname = image;
            } else {
                fname = "default-avatar.jpg"; // Nếu không có ảnh, sử dụng ảnh mặc định
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tạo đối tượng User
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);  // Lưu mật khẩu dưới dạng hash nếu cần
        user.setPhone(phone);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setAdmin(admin);
        user.setActive(active);
        user.setImages(fname); // Đặt tên ảnh cho người dùng

        // Thêm người dùng vào cơ sở dữ liệu
        boolean createdUser = userService.createUser(user);  // Gọi service để thêm người dùng

        String msg = "This is default message";

        if (createdUser) {
            msg = "Create user successfully";
            req.setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/admin/users");  // Redirect đến trang danh sách người dùng
        } else {
            msg = "Failed to create user";
            req.setAttribute("msg", msg);
            resp.sendRedirect(req.getContextPath() + "/admin/user/add");  // Redirect lại trang thêm người dùng nếu thất bại
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // Lấy dữ liệu từ form
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
            boolean active = Boolean.parseBoolean(req.getParameter("active"));
            String existingImage = req.getParameter("pic"); // Ảnh hiện tại của người dùng

            // Đường dẫn lưu ảnh tải lên
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Tạo thư mục nếu không tồn tại
            }

            String fname = existingImage; // Mặc định là ảnh cũ nếu không tải ảnh mới

            try {
                Part filePart = req.getPart("pic");
                if (filePart != null && filePart.getSize() > 0) {
                    // Xóa ảnh cũ nếu có và ảnh mới được tải lên
                    if (existingImage != null && !existingImage.isEmpty()) {
                        File oldFile = new File(uploadPath + File.separator + existingImage);
                        if (oldFile.exists()) {
                            oldFile.delete(); // Xóa ảnh cũ
                        }
                    }

                    // Lưu ảnh mới
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
                    fname = System.currentTimeMillis() + "." + ext;

                    String filePath = uploadPath + File.separator + fname;
                    filePart.write(filePath); // Lưu ảnh mới
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Tạo đối tượng User mới với dữ liệu đã cập nhật
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);  // Lưu mật khẩu dưới dạng hash nếu cần
            user.setPhone(phone);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setAdmin(admin);
            user.setActive(active);
            user.setImages(fname); // Đặt ảnh cho người dùng

            // Cập nhật người dùng trong cơ sở dữ liệu
            boolean isUpdated = userService.updateUser(user);  // Gọi service để cập nhật người dùng

            // Thông báo kết quả
            String msg = isUpdated ? "User updated successfully" : "Failed to update user";
            req.setAttribute("msg", msg);

            // Chuyển hướng đến danh sách người dùng sau khi cập nhật
            resp.sendRedirect(req.getContextPath() + "/admin/users");
    }
}
