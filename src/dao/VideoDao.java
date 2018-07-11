package dao;

import entity.Video;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public interface VideoDao {
    Video add(Video video);

    void delete(int videoId);

    Video update(Video video);

    Video get(int videoId);

    List<Video> getVideoByPoint(int videoId);
}
