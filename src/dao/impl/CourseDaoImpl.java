package dao.impl;

import dao.CourseDao;
import entity.Course;
import entity.SelectCourse;
import entity.TeachCourse;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/11.
 */
public class CourseDaoImpl implements CourseDao {
    private JdbcUtil util;

    public CourseDaoImpl() {
        this.util = new JdbcUtil();
    }
    @Override
    public Course add(Course course) {
        Connection conn = util.getConnection();

        String sql = "INSERT INTO course(coursename, img, description) values (?, ?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, course.getCoursename());
            pst.setString(2, course.getImg());
            pst.setString(3, course.getDescription());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? get(course.getCoursename(), course.getImg(), course.getDescription()) : null;
    }

    @Override
    public void addTeachCourse(TeachCourse teachCourse) {
        Connection conn = util.getConnection();

        String sql = "INSERT INTO teach_course(userId,courseId) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, teachCourse.getUserId());
            pst.setInt(2, teachCourse.getCourseId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public void addSelectCourse(SelectCourse selectCourse) {
        Connection conn = util.getConnection();

        String sql = "INSERT INTO select_course(userId,courseId) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, selectCourse.getUserId());
            pst.setInt(2, selectCourse.getCourseId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public Course update(Course course) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  course SET coursename = ?, img = ?, description = ?, studentnum = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, course.getCoursename());
            pst.setString(2, course.getImg());
            pst.setString(3, course.getDescription());
            pst.setInt(4, course.getStudentnum());
            pst.setInt(5, course.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? course : null;
    }

    @Override
    public Course get(String coursename, String img, String description) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM course WHERE coursename = ? AND img = ? AND description = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Course course = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, coursename);
            pst.setString(2, img);
            pst.setString(3, description);
            rs =  pst.executeQuery();
            if (rs.next()) {
                course = buildCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return course;
    }

    @Override
    public Course get(int id) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM course WHERE id  = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Course course = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs =  pst.executeQuery();
            if (rs.next()) {
                course = buildCourse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return course;
    }

    @Override
    public List<Course> getAll() {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM course";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            if (rs.next()) {
                courseList.add(buildCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return courseList;
    }

    @Override
    public List<Course> getByTeacher(int teacherId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM course INNER JOIN teach_course ON course.id = teach_course.userId WHERE teach_course.userId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, teacherId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                courseList.add(buildCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return courseList;
    }

    @Override
    public List<Course> getByStudent(int studentId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM course INNER JOIN select_course ON course.id = select_course.userId WHERE select_course.userId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, studentId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                courseList.add(buildCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return courseList;
    }

    @Override
    public List<Course> getFamousCourses() {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM course ORDER BY studentnum DESC ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                courseList.add(buildCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return courseList;
    }

    @Override
    public List<Course> getFreshCourses() {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM course ORDER BY id DESC ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Course> courseList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                courseList.add(buildCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return courseList;
    }

    @Override
    public Course delete(int id) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM course WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return get(id);
    }

    @Override
    public boolean exists(String courseName) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM course WHERE coursename = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, courseName);
            rs = pst.executeQuery();
            if (rs.next()) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return flag;
    }

    @Override
    public void withdrawal(int studentId, int courseId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM select_course WHERE userId = ? AND courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setInt(2, courseId);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
    }

    private Course buildCourse(ResultSet rs) throws SQLException {
        return new Course(rs.getInt("id"), rs.getString("coursename"),
                rs.getString("img"), rs.getString("description"), rs.getInt("studentnum"));
    }
}
