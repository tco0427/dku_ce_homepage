package dao;

import java.sql.*;

public class RdbmsDAO {
    private static final String PROPERTIES = "?useSSL=false";
    private static final String DB_SCHEMAS = "ceHomepage";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_SCHEMAS + PROPERTIES + "&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            /**
             * JDBC 드라이버 로딩
             */
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        /**
         * 데이터베이스 커넥션 생성 및 반환
         */
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static void resourceClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resourceClose(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
