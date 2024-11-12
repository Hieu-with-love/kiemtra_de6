package devzeus.com.kiemtra_ltweb_de6.service.impl;

import devzeus.com.kiemtra_ltweb_de6.dao.VideoDao;
import devzeus.com.kiemtra_ltweb_de6.dao.impl.VideoDaoImpl;
import devzeus.com.kiemtra_ltweb_de6.model.Video;
import devzeus.com.kiemtra_ltweb_de6.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    VideoDao videoDao = new VideoDaoImpl();
    @Override
    public void addNewVideo(String title, String poster, int views, String description, boolean active, int categoryId) {
        Video video = new Video();
        video.setTitle(title);
        video.setPoster(poster);
        video.setViews(views);
        video.setDescription(description);
        video.setActive(active);
        video.setCategoryId(categoryId);

        videoDao.addVideo(video);
    }

    @Override
    public Video getVideoDetails(int videoId) {
        return videoDao.getVideoById(videoId);
    }

    @Override
    public List<Video> listAllVideos(Long categoryId) {
        return videoDao.getAllVideos();
    }

    @Override
    public void updateVideoDetails(int videoId, String title, String poster, int views, String description, boolean active, int categoryId) {
        Video video = new Video();
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
