package dao;

import entity.Course;
import entity.SelectCourse;
import entity.TeachCourse;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/8.
 */
public interface CourseDao {
    Course add(Course course);

    void addTeachCourse(TeachCourse teachCourse);

    void addSelectCourse(SelectCourse selectCourse);

    Course update(Course course);

    Course get(String coursename, String img, String description);

    Course get(int id);

    List<Course> getAll();

    List<Course> getByTeacher(int teacherId);

    List<Course> getByStudent(int studentId);

    List<Course> getByName(String courseName);

    List<Course> getFamousCourses();

    List<Course> getFreshCourses();

    Course delete(int id);

    boolean exists(String courseName);

    boolean existSelectCourse(int studentId, int courseId);

    boolean existTeacCourse(int teacherId, int courseId);

    void withdrawal(int studentId, int courseId);
}
