package dao.impl;

import dao.CourseDao;
import entity.Course;
import entity.SelectCourse;
import entity.TeachCourse;

import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class CourseDaoImpl implements CourseDao {
    @Override
    public Course add(Course course) {
        return null;
    }

    @Override
    public void addTeachCourse(TeachCourse teachCourse) {

    }

    @Override
    public void addSelectCourse(SelectCourse selectCourse) {

    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public Course get(int id) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }

    @Override
    public List<Course> getByTeacher(int teacherId) {
        return null;
    }

    @Override
    public List<Course> getByStudent(int studentId) {
        return null;
    }

    @Override
    public List<Course> getFamousCourses() {
        return null;
    }

    @Override
    public List<Course> getFreshCourses() {
        return null;
    }

    @Override
    public Course delete(int id) {
        return null;
    }

    @Override
    public boolean exists(String courseName) {
        return false;
    }

    @Override
    public void withdrawal(int studentId, int courseId) {

    }
}
