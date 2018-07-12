package dao;

import dao.impl.*;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class DaoFactory {
    public static ChapterDao getChapterDaoImpl() {
        return new ChapterDaoImpl();
    }

    public static CourseDao getCourseDaoImpl() {
        return new CourseDaoImpl();
    }

    public static HomeworkDao getHomeworkDaoImpl() {
        return new HomeworkDaoImpl();
    }

    public static UserDao getUserDaoImpl() {return new UserDaoImpl();}

    public static PointDao getPointDaoImpl() {return new PointDaoImpl();}

    public static VideoDao getVideoDaoImpl() { return new VideoDaoImpl(); }

    public static ResourceDao getResourceDaoImpl() { return  new ResourceDaoImpl(); }
}
