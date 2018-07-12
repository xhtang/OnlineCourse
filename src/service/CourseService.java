package service;

import entity.*;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/9.
 */
public interface CourseService {
    Course openCourse(int teacherId, Course course);

    void selectCourse(int studentId, int courseId);

    void withdrawal(int studentId, int courseId);

    Chapter addChapter(Chapter chapter);

    void deleteChapter(int chapterId);

    Point addPoint(Point point);

    void deletePoint(int pointId);

    Video addVideo(Video video);

    void deleteVideo(int videoId);

    CourseDetails getCourseDetails(int id);

    List<Course> getByTeacher(int teacherId);

    List<Course> getByStudent(int studentId);

    List<Course> getFamousCourses();

    List<Course> getFreshCourses();

    List<Course> getAll();

    List<Course> getByName(String coursename);
}
