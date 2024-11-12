package devzeus.com.kiemtra_ltweb_de6.service;

import devzeus.com.kiemtra_ltweb_de6.model.Video_22110139;

import java.util.List;

public interface VideoService_22110139 {
    void addNewVideo(String title, String poster, int views, String description, boolean active, int categoryId);
    Video_22110139 getVideoDetails(int videoId);
    List<Video_22110139> listAllVideos(Long categoryId);
    void updateVideoDetails(int videoId, String title, String poster, int views, String description, boolean active, int categoryId);
    void deleteVideo(int videoId);
}
