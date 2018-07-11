package service;

import entity.User;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
public interface UserService {
    User login(String username, String password);

    User register(String username, String password);

    User update(User user);

    boolean exist(String username);

    List<User> getStudentByCourse(int courseId);

    User getTeacherByCourse(int courseId);
}
