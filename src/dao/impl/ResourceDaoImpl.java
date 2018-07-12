package dao.impl;

import dao.ResourceDao;
import entity.Resource;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator: DreamBoy
 * Date: 2018/7/12.
 */
public class ResourceDaoImpl implements ResourceDao {
    private JdbcUtil util = new JdbcUtil();
    @Override
    public Resource add(Resource resource) {
        Resource tmp = exist(resource.getCourseId(), resource.getName());
        if (tmp != null)
            return null;
        Connection conn = util.getConnection();

        String sql = "INSERT INTO resource(courseId, name) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, resource.getCourseId());
            pst.setString(2, resource.getName());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? exist(resource.getCourseId(), resource.getName()) : null;
    }

    @Override
    public void delete(int resourceId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM resource WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, resourceId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public Resource update(Resource resource) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  resource SET courseId = ?, name = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, resource.getCourseId());
            pst.setString(2,resource.getName());
            pst.setInt(3, resource.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? resource : null;
    }

    @Override
    public Resource get(int resourceId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM resource WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Resource resource = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, resourceId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                resource = buildResource(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return resource;
    }

    @Override
    public List<Resource> getByCourse(int courseId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM resource WHERE courseId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Resource> resourceList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                resourceList.add(buildResource(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return resourceList;
    }

    @Override
    public Resource exist(int courseId, String name) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM resource WHERE courseId = ? AND name = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Resource resource = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            pst.setString(2, name);
            rs =  pst.executeQuery();
            if (rs.next()) {
                resource = buildResource(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return resource;
    }

    private Resource buildResource(ResultSet rs) throws SQLException {
        return new Resource(rs.getInt("id"), rs.getInt("courseId"),
                rs.getString("name"));
    }
}
