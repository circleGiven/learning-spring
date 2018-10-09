package biz.user.impl;

import biz.common.JDBCUtil;
import biz.user.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DAO
 */
public class UserDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어
    private final String USER_GET = "select * from USERS where ID=? and PASSWORD=?";

    // CRUD
    // 회원 조회
    public UserVO getUser(UserVO vo) {
        UserVO result = null;

        try {
            System.out.println("===> JDBC로 getUser() 기능 처리");
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            // 쿼리 싪행
            rs = stmt.executeQuery();

            if (rs.next()) {
                result = new UserVO();
                result.setId(rs.getString("ID"));
                result.setPassword(rs.getString("PASSWORD"));
                result.setName(rs.getString("NAME"));
                result.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return result;
    }
}
