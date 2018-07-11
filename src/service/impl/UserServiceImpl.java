package service.impl;

import dao.CourseDao;
import dao.DaoFactory;
import dao.UserDao;
import entity.User;
import service.UserService;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoImpl();
    CourseDao courseDao = DaoFactory.getCourseDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public User register(String username, String password) {
        if (exist(username))
            return null;
        else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            return userDao.add(user);
        }

    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean exist(String username) {
        return userDao.exists(username);
    }

    @Override
    public List<User> getStudentByCourse(int courseId) {
        return userDao.getStudentByCourseId(courseId);
    }

    @Override
    public User getTeacherByCourse(int courseId) {
        return userDao.getTeacherByCourseId(courseId);
    }
}
