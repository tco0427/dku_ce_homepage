package dao;

import dto.Classification;
import dto.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdbc.ConnectionProvider.getConnection;
import static jdbc.ConnectionProvider.resourceClose;

public class PostRepositoryImpl implements PostRepository{
    private PostRepositoryImpl(){}
    private static PostRepositoryImpl instance=new PostRepositoryImpl();
    public static PostRepositoryImpl getInstance(){
        return instance;
    }

    @Override
    public int add(Post post) {
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            String sql="insert into post(memberID,title,content,creationDate,classification,attachFileName,filePath) values (?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,post.getMemberID());
            pstmt.setString(2,post.getTitle());
            pstmt.setString(3,post.getContent());
            pstmt.setDate(4,post.getCreationDate());
            pstmt.setString(5,post.getClassification().toString());
            pstmt.setString(6,post.getAttachFileName());
            pstmt.setString(7,post.getFilePath());
            return pstmt.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException e){
            //PK에 대한 잘못된 접근으로 예외 발생시에는 -10을 반환하도록하였다.(일종의 에러코드라고 생각하면된다.)
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
            String sql="delete from post where postPK=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
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
    public Post findOne(Integer id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from post where postPK=?";
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
    public List<Post> findBySearch(String query){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from post where title=? order by creationDate desc";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,query);
            rs=pstmt.executeQuery();
            List<Post> list=new ArrayList<>();
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
    public List<Post> findAll() {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from post order by postPK order by creationDate desc";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            List<Post> list=new ArrayList<>();
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
    public Post findRecentPost(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from post where classification='notice' order by creationDate DESC limit 1";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            rs.next();
            Post post=createFromResultSet(rs);
            return post;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt, rs);
        }
        return null;
    }
    @Override
    public List<Post> findByClassification(Classification classification) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConnection();
            String sql="select * from post where classification=? order by postPK desc";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,classification.toString());
            rs=pstmt.executeQuery();
            List<Post> list=new ArrayList<>();
            while(rs.next()){
                list.add(createFromResultSet(rs));
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            resourceClose(conn,pstmt,rs);
        }
        return null;
    }

    @Override
    public int update(Post post) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            conn=getConnection();
            String sql="update post set content=? where postPK=?";
            pstmt=conn.prepareStatement(sql);


            pstmt.setString(1,post.getContent());
            pstmt.setInt(2,post.getId());

            return pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //리소스 반환하는 메소드 호출
            resourceClose(conn,pstmt);
        }
        return -1;
    }

    private Post createFromResultSet(ResultSet rs) {
        Integer id=null;
        String memberId=null;
        String title=null;
        String content=null;
        Date createDate=null;
        String classificationString;
        Classification classification=null;
        String attachFileName=null;
        String filePath=null;
        try{
            id=rs.getInt("postPK");
            memberId=rs.getString("memberID");
            title=rs.getString("title");
            content=rs.getString("content");
            createDate=rs.getDate("creationDate");
            classificationString=rs.getString("classification");
            classification=Classification.valueOf(classificationString);
            attachFileName=rs.getString("attachFileName");
            filePath=rs.getString("filePath");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Post(id,memberId,title,content,createDate,classification,attachFileName,filePath);
    }
}
