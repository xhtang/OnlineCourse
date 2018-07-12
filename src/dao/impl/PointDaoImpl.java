package dao.impl;

import dao.PointDao;
import entity.Point;
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
public class PointDaoImpl implements PointDao {
    private JdbcUtil util;

    public PointDaoImpl() {
        util = new JdbcUtil();
    }
    @Override
    public Point add(Point point) {
        Point tmp = exist(point.getChapterId(), point.getDescription());
        if (tmp != null)
            return null;
        Connection conn = util.getConnection();

        String sql = "INSERT INTO point(chapterId, description) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, point.getChapterId());
            pst.setString(2, point.getDescription());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? exist(point.getChapterId(), point.getDescription()) : null;
    }

    @Override
    public void delete(int pointId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM point WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pointId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public Point update(Point point) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  point SET chapterId = ?, description = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, point.getChapterId());
            pst.setString(2,point.getDescription());
            pst.setInt(3, point.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? point : null;
    }

    @Override
    public Point get(int pointId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM point WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Point point = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pointId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                point = buildPoint(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return point;
    }

    @Override
    public List<Point> getPointsByChapter(int chapterId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM point WHERE chapterId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Point> pointList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, chapterId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                pointList.add(buildPoint(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return pointList;
    }

    public Point exist(int chapterId, String description) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM point WHERE chapterId = ? AND description = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Point point = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, chapterId);
            pst.setString(2, description);
            rs =  pst.executeQuery();
            if (rs.next()) {
                point = buildPoint(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return point;
    }

    private Point buildPoint(ResultSet rs) throws SQLException {
        return new Point(rs.getInt("id"), rs.getInt("chapterId"), rs.getString("description"));
    }
}
