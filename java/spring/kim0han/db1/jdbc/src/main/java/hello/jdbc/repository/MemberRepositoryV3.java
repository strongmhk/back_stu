package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
 * 트랜잭션 - 트랜잭션 매니저
 * DataSourceUtils.getConnection()
 * DataSourceUtils.releaseConnection()
 */
@Slf4j
public class MemberRepositoryV3 {

    private final DataSource dataSource;

    public MemberRepositoryV3(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);

            rs = pstmt.executeQuery();// select는 executeUpdate가 아니고 executeQuery사용
            if (rs.next()){
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else { // 데이터가 없음
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }

        } catch (SQLException e){
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }


    }



    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money); // ?에 들어갈 파라미터 바인딩
            pstmt.setString(2, memberId);
            int resultSize = pstmt.executeUpdate();// 쿼리가 DB에 실행
            log.info("resultSize={}",resultSize); // 0 이나 1이 나옴
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally { // 커넥션을 끊기 위함
            close(con, pstmt, null);
        }
    }


    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId); // ?에 들어갈 파라미터 바인딩
            int resultSize = pstmt.executeUpdate();// 쿼리가 DB에 실행
            log.info("resultSize={}",resultSize); // 0 이나 1이 나옴
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally { // 커넥션을 끊기 위함
            close(con, pstmt, null);
        }


    }


    private void close(Connection con, Statement stmt, ResultSet rs){ // Statement는 PreparedStatement의 부모

        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야한다.
        DataSourceUtils.releaseConnection(con, dataSource);

    }

    private Connection getConnection() throws SQLException {
        // 주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야한다.
        Connection con = DataSourceUtils.getConnection(dataSource);
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }
}
