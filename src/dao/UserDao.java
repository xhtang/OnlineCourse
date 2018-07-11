package dao;

import entity.User;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/8.
 */
public interface UserDao {
    User add(User user);

    User update(User user);

    User get(String username, String password);

    List<User> getAll();

    List<User> getStudentByCourseId(int courseId);

    User getTeacherByCourseId(int courseId);

    boolean exists(String username);
}
