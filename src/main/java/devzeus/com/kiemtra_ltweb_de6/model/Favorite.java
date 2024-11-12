package devzeus.com.kiemtra_ltweb_de6.model;

import java.util.Date;

public class Favorite {
    private int favoriteId;
    private Date likedDate;
    private int videoId;
    private String username;

    public Favorite() {}

    public Favorite(int favoriteId, Date likedDate, int videoId, String username) {
        this.favoriteId = favoriteId;
        this.likedDate = likedDate;
        this.videoId = videoId;
        this.username = username;
    }

    public int getFavoriteId() { return favoriteId; }
    public void setFavoriteId(int favoriteId) { this.favoriteId = favoriteId; }

    public Date getLikedDate() { return likedDate; }
    public void setLikedDate(Date likedDate) { this.likedDate = likedDate; }

    public int getVideoId() { return videoId; }
    public void setVideoId(int videoId) { this.videoId = videoId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}

