package devzeus.com.kiemtra_ltweb_de6.dao;

import devzeus.com.kiemtra_ltweb_de6.model.Video_22110139;

import java.util.List;

public interface VideoDao_22110139 {
    void addVideo(Video_22110139 video);
    Video_22110139 getVideoById(int videoId);
    List<Video_22110139> getAllVideos();
    void updateVideo(Video_22110139 video);
    void deleteVideo(int videoId);
}
