package devzeus.com.kiemtra_ltweb_de6.model;

public class User_22110139 {
    private String username;
    private String password;
    private String phone;
    private String fullname;
    private String email;
    private boolean admin;
    private boolean active;
    private String images;

    public User_22110139() {}

    public User_22110139(String username, String password, String phone, String fullname, String email, boolean admin, boolean active, String images) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.fullname = fullname;
        this.email = email;
        this.admin = admin;
        this.active = active;
        this.images = images;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}

