package dao.impl;

import dao.HomeworkDao;
import entity.Homework;
import entity.StudentAnswer;
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
public class HomeworkDaoImpl implements HomeworkDao {
    private JdbcUtil util;

    public HomeworkDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public Homework add(Homework homework) {
        Homework tmp = existHomework(homework.getCourseId(), homework.getType(), homework.getContent());
        if (tmp != null)
            return null;
        Connection conn = util.getConnection();

        String sql = "INSERT INTO homework(courseId, type, content, correctAnswer) values (?, ?, ?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, homework.getCourseId());
            pst.setString(2,homework.getType());
            pst.setString(3,homework.getContent());
            pst.setString(4, homework.getCorrectAnswer());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? existHomework(homework.getCourseId(), homework.getType(), homework.getContent()) : null;
    }

    @Override
    public Homework delete(int homeworkId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM homework WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, homeworkId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return get(homeworkId);
    }

    @Override
    public Homework update(Homework homework) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  homework SET courseId = ?, type = ?, content = ?, correctAnswer = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, homework.getCourseId());
            pst.setString(2,homework.getType());
            pst.setString(3,homework.getContent());
            pst.setString(4,homework.getCorrectAnswer());
            pst.setInt(5, homework.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? homework : null;
    }

    @Override
    public Homework get(int homeworkId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM homework WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Homework homework = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, homeworkId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                homework = buildHomework(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return homework;
    }

    public Homework existHomework(int courseId, String type, String content) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM homework WHERE courseId = ? AND type = ? AND content = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Homework homework = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            pst.setString(2, type);
            pst.setString(3, content);
            rs =  pst.executeQuery();
            if (rs.next()) {
                homework = buildHomework(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return homework;
    }

    @Override
    public List<Homework> getByCourse(int courseId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM homework WHERE courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Homework> homeworkList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                homeworkList.add(buildHomework(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return homeworkList;
    }

    @Override
    public StudentAnswer addAnswer(StudentAnswer studentAnswer) {
        StudentAnswer tmp = existAnswer(studentAnswer.getStudentId(),studentAnswer.getHomeworkId());
        if (tmp != null)
            return null;
        Connection conn = util.getConnection();

        String sql = "INSERT INTO student_answer(studentId, homeworkId, answer) values (?, ?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, studentAnswer.getStudentId());
            pst.setInt(2, studentAnswer.getHomeworkId());
            pst.setString(3, studentAnswer.getAnswer());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? existAnswer(studentAnswer.getStudentId(),studentAnswer.getHomeworkId()) : null;
    }

    @Override
    public StudentAnswer existAnswer(int studentId, int homeworkId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM student_answer WHERE studentId = ? AND homeworkId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        StudentAnswer studentAnswer = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setInt(2, homeworkId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                studentAnswer = buildStudentAnswer(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return studentAnswer;
    }

    @Override
    public StudentAnswer updateAnswer(StudentAnswer studentAnswer) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  student_answer SET studentId = ?, homeworkId = ?, answer = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, studentAnswer.getStudentId());
            pst.setInt(2, studentAnswer.getHomeworkId());
            pst.setString(3,studentAnswer.getAnswer());
            pst.setInt(4, studentAnswer.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? studentAnswer : null;
    }

    private Homework buildHomework(ResultSet rs) throws SQLException {
        return new Homework(rs.getInt("id"), rs.getInt("courseId"),
                rs.getString("type"), rs.getString("content"),
                rs.getString("correctAnswer"));
    }

    private StudentAnswer buildStudentAnswer(ResultSet rs) throws SQLException {
        return new StudentAnswer(rs.getInt("id"), rs.getInt("studentId"),
                rs.getInt("homeworkId"), rs.getString("answer"));
    }
}
