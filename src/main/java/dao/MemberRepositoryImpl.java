package dao;

import dto.Member;
import dto.Permission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionProvider.getConnection;
import static jdbc.ConnectionProvider.resourceClose;

public class MemberRepositoryImpl implements MemberRepository{

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
            String sql="insert into member values (?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,member.getId());
            pstmt.setString(2,member.getPassword());
            pstmt.setString(3,member.getEmail());
            pstmt.setString(4,member.getName());
            pstmt.setString(5,member.getNickname());
            pstmt.setString(6,member.getPassword());
            pstmt.setInt(7,member.getStudentID());
            pstmt.setString(8,member.getPermission().toString());
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
            String sql="select * from member where id=? AND `password`=?";
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
    public Member findOne(String id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from member where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
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

    private Member createFromResultSet(ResultSet rs) {
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
        return new Member(id,password,email,name,nickname,passwordHint,studentID, Permission.Normal);
    }

}
