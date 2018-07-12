package dao.impl;

import dao.VideoDao;
import entity.Point;
import entity.Video;
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
public class VideoDaoImpl implements VideoDao {
    private JdbcUtil util;
    public VideoDaoImpl() {
        util = new JdbcUtil();
    }
    @Override
    public Video add(Video video) {
        Video tmp = exist(video.getPointId(), video.getPath());
        if (tmp != null)
            return null;
        Connection conn = util.getConnection();

        String sql = "INSERT INTO video(pointId, path) values (?, ?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, video.getPointId());
            pst.setString(2,video.getPath());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? exist(video.getPointId(), video.getPath()) : null;
    }

    @Override
    public void delete(int videoId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM video WHERE id = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, videoId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public Video update(Video video) {
        Connection conn = util.getConnection();
        String sql = "UPDATE  video SET pointId = ?, path = ? WHERE id = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, video.getPointId());
            pst.setString(2,video.getPath());
            pst.setInt(3, video.getId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }

        return flag ? video : null;
    }

    @Override
    public Video get(int videoId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM video WHERE id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Video video = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, videoId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                video = buildVideo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return video;
    }

    @Override
    public List<Video> getVideoByPoint(int pointId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM video WHERE pointId = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Video> videoList = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pointId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                videoList.add(buildVideo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return videoList;
    }

    public Video exist(int pointId, String path) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM video WHERE pointId = ? AND path = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Video video = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pointId);
            pst.setString(2, path);
            rs =  pst.executeQuery();
            if (rs.next()) {
                video = buildVideo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return video;
    }

    private Video buildVideo(ResultSet rs) throws SQLException {
        return new Video(rs.getInt("id"), rs.getInt("pointId"), rs.getString("path"));
    }
}
