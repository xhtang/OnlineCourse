package util;

import java.sql.*;

public class JdbcUtil {

    //    private final static String URL = "jdbc:mysql://127.0.0.1:3306/onlinecourse";
    private final static String URL = "jdbc:mysql://10.131.229.156:3306/onlinecourse";
    private final static String USER = "root";
    private final static String PASSWORD = "123654";

    public static void main(String args[]) {
        new JdbcUtil();
    }

    public JdbcUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 得到连接
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭结果集、语句和连接
    public void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) { rs.close(); }
            if (st != null) { st.close(); }
            if (conn != null) { conn.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
