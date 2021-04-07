package dao;

import dto.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository{
    private static final String PROPERTIES="?useSSL=false";
    private static final String DB_SCHEMAS="ceHomepage";
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/"+DB_SCHEMAS+PROPERTIES+"&allowPublicKeyRetrieval=true";
    private static final String USER="root";
    private static final String PASSWORD="admin";

    private MemberRepositoryImpl(){}
    private static MemberRepositoryImpl instance=new MemberRepositoryImpl();
    public static MemberRepositoryImpl getInstance(){
        return instance;
    }

    @Override
    public int save(Member member) {
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            String sql="insert into member values (?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,member.getId());
            pstmt.setString(2,member.getPassword());
            pstmt.setString(3,member.getEmail());
            pstmt.setString(4,member.getName());
            pstmt.setString(5,member.getNickname());
            pstmt.setString(6,member.getPassword());
            pstmt.setInt(7,member.getStudentID());
            return pstmt.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e){
            //PK에 대한 잘못된 접근으로 예외 발생시에는 -10을 반환하도록하였다.(일종의 에러코드라고 생각하면된다.)
            return -10;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //리소스 반환하는 메소드 호출
            resourceClose(conn,pstmt);
        }
        return -1;
    }

    @Override
    public int delete(String id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=getConnection();
            //SQL문을 미리 준비하고 이를 String으로 저장
            String sql="delete from member where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //리소스 반환하는 메소드 호출
            resourceClose(conn,pstmt);
        }
        return -1;
    }

    @Override
    public int editMail(Member member) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="update member set email=? where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,member.getEmail());
            pstmt.setString(2,member.getId());
            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //리소스 반환하는 메소드 호출
            resourceClose(conn,pstmt, rs);
        }
        return -1;
    }

    @Override
    public int editPassword(Member member) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="update member set password=? where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,member.getPassword());
            pstmt.setString(2,member.getId());
            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt, rs);
        }
        return -1;
    }

    @Override
    public Member findOne(String id, String password) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from member where id=?, password=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if(rs.next()){
                return createFromResultSet(rs);
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt, rs);
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            //SQL문을 미리 준비하고 이를 String으로 저장
            String sql="select * from member order by id";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Member> list=new ArrayList<>();
            while(rs.next()){
                list.add(createFromResultSet(rs));
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //리소스 반환하는 메소드 호출
            resourceClose(conn,pstmt, rs);
        }
        return null;
    }

    @Override
    public List<Member> findByHint(String passwordHint) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from member where passwordHint=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,passwordHint);
            rs=pstmt.executeQuery();
            List<Member> list=new ArrayList<>();
            while(rs.next()){
                list.add(createFromResultSet(rs));
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt, rs);
        }
        return null;
    }

    public Member createFromResultSet(ResultSet rs) {
        String id=null;
        String password=null;
        String email=null;
        String name=null;
        String nickname=null;
        String passwordHint=null;
        Integer studentID=null;
        try{
            id=rs.getString("id");
            password=rs.getString("password");
            email=rs.getString("email");
            name=rs.getString("name");
            nickname=rs.getString("nickname");
            passwordHint=rs.getString("passwordHint");
            studentID=rs.getInt("studentID");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Member(id,password,email,name,nickname,passwordHint,studentID);
    }

    private static Connection getConnection() throws SQLException {
        try{
            /**
             * JDBC 드라이버 로딩
             */
            Class.forName(JDBC_DRIVER);
        }catch(ClassNotFoundException e){
            e.getMessage();
        }
        /**
         * 데이터베이스 커넥션 생성 및 반환
         */
        return DriverManager.getConnection(DB_URL,USER,PASSWORD);
    }

    private void resourceClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void resourceClose(Connection conn, PreparedStatement pstmt){
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
