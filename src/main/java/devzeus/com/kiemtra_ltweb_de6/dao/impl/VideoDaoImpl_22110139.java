package devzeus.com.kiemtra_ltweb_de6.dao.impl;

import devzeus.com.kiemtra_ltweb_de6.config.DBConnectMySQL;
import devzeus.com.kiemtra_ltweb_de6.dao.VideoDao_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.Video_22110139;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDaoImpl_22110139 implements VideoDao_22110139 {
    @Override
    public void addVideo(Video_22110139 video) {
        String query = "INSERT INTO videos (title, poster, views, description, active, categoryId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnectMySQL.getDatabaseConnection()) {
             PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, video.getTitle());
            stmt.setString(2, video.getPoster());
            stmt.setInt(3, video.getViews());
            stmt.setString(4, video.getDescription());
            stmt.setBoolean(5, video.isActive());
            stmt.setInt(6, video.getCategoryId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Video_22110139 getVideoById(int videoId) {
        String query = "SELECT * FROM videos WHERE videoId = ?";
        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, videoId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Video_22110139 video = new Video_22110139();
                video.setVideoId(rs.getInt("videoId"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));
                video.setCategoryId(rs.getInt("categoryId"));
                return video;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Video_22110139> getAllVideos() {
        List<Video_22110139> videos = new ArrayList<>();
        String query = "SELECT * FROM videos";
        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Video_22110139 video = new Video_22110139();
                video.setVideoId(rs.getInt("videoId"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));
                video.setCategoryId(rs.getInt("categoryId"));
                videos.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    @Override
    public void updateVideo(Video_22110139 video) {
        String query = "UPDATE videos SET title = ?, poster = ?, views = ?, description = ?, active = ?, categoryId = ? WHERE videoId = ?";
        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, video.getTitle());
            stmt.setString(2, video.getPoster());
            stmt.setInt(3, video.getViews());
            stmt.setString(4, video.getDescription());
            stmt.setBoolean(5, video.isActive());
            stmt.setInt(6, video.getCategoryId());
            stmt.setInt(7, video.getVideoId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVideo(int videoId) {
        String query = "DELETE FROM videos WHERE videoId = ?";
        try (Connection conn = DBConnectMySQL.getDatabaseConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, videoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
