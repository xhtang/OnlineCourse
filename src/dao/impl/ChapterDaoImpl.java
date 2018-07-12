package dao.impl;

import dao.ChapterDao;
import entity.Chapter;
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
public class ChapterDaoImpl implements ChapterDao {
    private JdbcUtil util;

    public ChapterDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public Chapter add(Chapter chapter) {
        Connection conn = util.getConnection();

        String sql = "INSERT INTO chapter(courseId, description) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, chapter.getCourseId());
            pst.setString(2, chapter.getDescription());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? exist(chapter.getCourseId(), chapter.getDescription()) : null;

    }

    @Override
    public void delete(int id) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM chapter WHERE id = ?";
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
    }

    @Override
    public Chapter update(Chapter chapter) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  chapter SET courseId = ?, description = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, chapter.getCourseId());
            pst.setString(2,chapter.getDescription());
            pst.setInt(3, chapter.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? chapter : null;
    }

    @Override
    public Chapter get(int id) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM chapter WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Chapter chapter = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            rs =  pst.executeQuery();
            if (rs.next()) {
                chapter = buildChapter(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return chapter;
    }

    @Override
    public List<Chapter> getByCourse(int courseId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM chapter WHERE courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Chapter> chapterList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                chapterList.add(buildChapter(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return chapterList;
    }

    public Chapter exist(int courseId, String description) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM chapter WHERE courseId = ? AND description = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Chapter chapter = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            pst.setString(2, description);
            rs =  pst.executeQuery();
            if (rs.next()) {
                chapter = buildChapter(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return chapter;
    }

    private Chapter buildChapter(ResultSet rs) throws SQLException {
        return new Chapter(rs.getInt("id"), rs.getInt("courseId"),
                rs.getString("description"));
    }
}
