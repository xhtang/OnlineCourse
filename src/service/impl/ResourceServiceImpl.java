package service.impl;

import dao.DaoFactory;
import dao.ResourceDao;
import entity.Resource;
import service.ResourceService;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/12.
 */
public class ResourceServiceImpl implements ResourceService {
    private ResourceDao resourceDao = DaoFactory.getResourceDaoImpl();

    @Override
    public Resource add(Resource resource) {
        return resourceDao.add(resource);
    }

    @Override
    public void delete(int resourceId) {
        resourceDao.delete(resourceId);
    }

    @Override
    public Resource update(Resource resource) {
        return resourceDao.update(resource);
    }

    @Override
    public Resource get(int resourceId) {
        return resourceDao.get(resourceId);
    }

    @Override
    public Resource exist(int courseId, String name) {
        return resourceDao.exist(courseId, name);
    }

    @Override
    public List<Resource> getByCourse(int courseId) {
        return resourceDao.getByCourse(courseId);
    }
}
