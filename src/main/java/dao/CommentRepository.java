package dao;

import dto.Comment;

import java.util.List;

public interface CommentRepository {
    public int save(Comment comment);
    public int delete(Integer id);
    public int editComment(Comment comment);
    public Comment findOne(Integer id);
    public List<Comment> findAll();
    public List<Comment> findByPost(Integer id);
}
