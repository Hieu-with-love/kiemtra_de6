package devzeus.com.kiemtra_ltweb_de6.service;

import devzeus.com.kiemtra_ltweb_de6.model.Video;

import java.util.List;

public interface VideoService {
    void addNewVideo(String title, String poster, int views, String description, boolean active, int categoryId);
    Video getVideoDetails(int videoId);
    List<Video> listAllVideos(Long categoryId);
    void updateVideoDetails(int videoId, String title, String poster, int views, String description, boolean active, int categoryId);
    void deleteVideo(int videoId);
}
