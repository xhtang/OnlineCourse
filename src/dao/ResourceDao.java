package dao;

import entity.Resource;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/12.
 */
public interface ResourceDao {
    Resource add(Resource resource);

    void delete(int resourceId);

    Resource update(Resource resource);

    Resource get(int resourceId);

    List<Resource> getByCourse(int courseId);

    Resource exist(int courseId, String name);
}
