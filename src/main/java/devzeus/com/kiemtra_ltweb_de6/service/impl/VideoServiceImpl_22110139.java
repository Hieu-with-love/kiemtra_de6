package devzeus.com.kiemtra_ltweb_de6.service.impl;

import devzeus.com.kiemtra_ltweb_de6.dao.VideoDao_22110139;
import devzeus.com.kiemtra_ltweb_de6.dao.impl.VideoDaoImpl_22110139;
import devzeus.com.kiemtra_ltweb_de6.model.Video_22110139;
import devzeus.com.kiemtra_ltweb_de6.service.VideoService_22110139;

import java.util.List;

public class VideoServiceImpl_22110139 implements VideoService_22110139 {
    VideoDao_22110139 videoDao = new VideoDaoImpl_22110139();
    @Override
    public void addNewVideo(String title, String poster, int views, String description, boolean active, int categoryId) {
        Video_22110139 video = new Video_22110139();
        video.setTitle(title);
        video.setPoster(poster);
        video.setViews(views);
        video.setDescription(description);
        video.setActive(active);
        video.setCategoryId(categoryId);

        videoDao.addVideo(video);
    }

    @Override
    public Video_22110139 getVideoDetails(int videoId) {
        return videoDao.getVideoById(videoId);
    }

    @Override
    public List<Video_22110139> listAllVideos(Long categoryId) {
        return videoDao.getAllVideos();
    }

    @Override
    public void updateVideoDetails(int videoId, String title, String poster, int views, String description, boolean active, int categoryId) {
        Video_22110139 video = new Video_22110139();
        video.setVideoId(videoId);
        video.setTitle(title);
        video.setPoster(poster);
        video.setViews(views);
        video.setDescription(description);
        video.setActive(active);
        video.setCategoryId(categoryId);

        videoDao.updateVideo(video);
    }

    @Override
    public void deleteVideo(int videoId) {
        videoDao.deleteVideo(videoId);
    }
}
