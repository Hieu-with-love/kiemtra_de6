package devzeus.com.kiemtra_ltweb_de6.dao;

import devzeus.com.kiemtra_ltweb_de6.model.Video;

import java.util.List;

public interface VideoDao {
    void addVideo(Video video);
    Video getVideoById(int videoId);
    List<Video> getAllVideos();
    void updateVideo(Video video);
    void deleteVideo(int videoId);
}
