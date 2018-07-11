package service.impl;

import dao.*;
import entity.*;
import service.CourseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class CourseServiceImpl implements CourseService {
    private ChapterDao chapterDao = DaoFactory.getChapterDaoImpl();
    private CourseDao courseDao = DaoFactory.getCourseDaoImpl();
    private PointDao pointDao = DaoFactory.getPointDaoImpl();
    private VideoDao videoDao = DaoFactory.getVideoDaoImpl();
    @Override
    public Course openCourse(int teacherId, Course course) {
        course = courseDao.add(course);
        TeachCourse teachCourse = new TeachCourse();
        teachCourse.setCourseId(course.getId());
        teachCourse.setUserId(teacherId);
        courseDao.addTeachCourse(teachCourse);
        return course;
    }

    @Override
    public void selectCourse(int studentId, int courseId) {
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setCourseId(courseId);
        selectCourse.setUserId(studentId);
        courseDao.addSelectCourse(selectCourse);
    }

    @Override
    public void withdrawal(int studentId, int courseId) {
        courseDao.withdrawal(studentId, courseId);
    }

    @Override
    public Chapter addChapter(Chapter chapter) {
        return chapterDao.add(chapter);
    }

    @Override
    public void deleteChapter(int chapterId) {
        chapterDao.delete(chapterId);
    }

    @Override
    public Point addPoint(Point point) {
        return pointDao.add(point);
    }

    @Override
    public void deletePoint(int pointId) {
        pointDao.delete(pointId);
    }

    @Override
    public Video addVideo(Video video) {
        return videoDao.add(video);
    }

    @Override
    public void deleteVideo(int videoId) {
        videoDao.delete(videoId);
    }

    @Override
    public CourseDetails getCourseDetails(int id) {
        CourseDetails details = new CourseDetails();
        Course course = courseDao.get(id);
        details.setCourse(course);

        List<ChapterDetails> chapterDetailsList = new ArrayList<>();

        List<Chapter> chapters = chapterDao.getByCourse(id);
        for (Chapter chapter: chapters) {
            ChapterDetails chapterDetails = new ChapterDetails();
            List<Point> points = pointDao.getPointsByChapter(chapter.getId());
            chapterDetails.setChapter(chapter);
            chapterDetails.setPoints(points);
            chapterDetailsList.add(chapterDetails);
        }
        details.setChapterDetailsList(chapterDetailsList);
        return details;
    }

    @Override
    public List<Course> getByTeacher(int teacherId) {
        return courseDao.getByTeacher(teacherId);
    }

    @Override
    public List<Course> getByStudent(int studentId) {
        return courseDao.getByStudent(studentId);
    }

    @Override
    public List<Course> getFamousCourses() {
        return courseDao.getFamousCourses();
    }

    @Override
    public List<Course> getFreshCourses() {
        return courseDao.getFreshCourses();
    }
}