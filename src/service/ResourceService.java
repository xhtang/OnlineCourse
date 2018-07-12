package service;

import entity.Resource;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/12.
 */
public interface ResourceService {
    Resource add(Resource resource);

    void delete(int resourceId);

    Resource update(Resource resource);

    Resource get(int resourceId);

    Resource exist(int courseId, String name);

    List<Resource> getByCourse(int courseId);


}
