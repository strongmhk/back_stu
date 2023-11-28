package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

//        "insert into member(member_id, money) values (insert into ..., select a from ...)"

        Connection con = null;
        PreparedStatement pstmt = null;


        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId()); // ?에 들어갈 파라미터 바인딩
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate(); // 쿼리가 DB에 실행
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally { // 커넥션을 끊기 위함
            close(con, pstmt, null);
        }


    }

    private void close(Connection con, Statement stmt, ResultSet rs){ // Statement는 PreparedStatement의 부모
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (con != null){
            try {
                con.close();
            } catch (SQLException e){
                log.info("error", e);
            }
        }


    }

    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
