package dao.impl;

import dao.UserDao;
import entity.User;
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
public class UserDaoImpl implements UserDao {
    private JdbcUtil util = new JdbcUtil();

    @Override
    public User add(User user) {
        Connection conn = util.getConnection();

        String sql = "INSERT INTO user(username, password) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? user : null;
    }

    @Override
    public User update(User user) {
        Connection conn = util.getConnection();
        // FirstName, LastName, Address, City, Region, Country, Postal, Phone, Email, Privacy)
        //language=MySQL
        String sql = "UPDATE  user SET username = ?, password = ? WHERE userId = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? user : null;
    }

    @Override
    public User get(String username, String password) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs =  pst.executeQuery();
            if (rs.next()) {
                user = buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM user";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                users.add(buildUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return users;
    }

    @Override
    public List<User> getStudentByCourseId(int courseId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM user INNER JOIN select_course ON user.userId = select_course.userId WHERE select_course.courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                users.add(buildUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return users;
    }

    @Override
    public User getTeacherByCourseId(int courseId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM user INNER JOIN teach_course ON user.userId = teach_course.userId WHERE teach_course.courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                user = buildUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return user;
    }

    @Override
    public boolean exists(String username) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM user WHERE username = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
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

    private User buildUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("userId"), rs.getString("username"), rs.getString("password"));
    }
}
