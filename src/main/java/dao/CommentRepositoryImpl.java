package dao;

import dto.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionProvider.getConnection;
import static jdbc.ConnectionProvider.resourceClose;

public class CommentRepositoryImpl implements CommentRepository{
    private CommentRepositoryImpl(){}
    private static CommentRepositoryImpl instance=new CommentRepositoryImpl();
    public static CommentRepositoryImpl getInstance(){
        return instance;
    }

    @Override
    public int save(Comment comment) {
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            String sql="insert into comment(memberID,postPK,creationDate,content) values (?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,comment.getMemberID());
            pstmt.setInt(2,comment.getPostID());
            pstmt.setDate(3,comment.getDate());
            pstmt.setString(4,comment.getContent());
            return pstmt.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e){
            return -10;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            resourceClose(conn,pstmt);
        }
        return -1;
    }

    @Override
    public int delete(Integer id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=getConnection();
            String sql="delete from comment where commentPK=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt);
        }
        return -1;
    }

    @Override
    public int editComment(Comment comment) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=getConnection();
            String sql="update comment set content=? where CommentPK=?";
            pstmt=conn.prepareStatement(sql);


            pstmt.setString(1,comment.getContent());
            pstmt.setInt(2,comment.getId());

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
    public Comment findOne(Integer id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from comment where commentPK=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
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
    public List<Comment> findAll() {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from comment";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Comment> list=new ArrayList<>();
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

    @Override
    public List<Comment> findByPost(Integer id){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from comment where postPk=?";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Comment> list=new ArrayList<>();
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

    private Comment createFromResultSet(ResultSet rs) {
        Integer id=null;
        String memberID=null;
        Integer postID=null;
        Date createDate=null;
        String content=null;

        try{
            id=rs.getInt("commentPK");
            memberID=rs.getString("memberID");
            postID=rs.getInt("postPK");
            createDate=rs.getDate("creationDate");
            content=rs.getString("content");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Comment(id,memberID,postID,createDate,content);
    }
}
