package dao;

import dto.Classification;
import dto.Post;

import java.util.List;

public interface PostRepository {
    public int add(Post post);
    public int delete(Integer id);
    public Post findOne(Integer id);
    public List<Post> findAll();
    public List<Post> findByClassification(Classification classification);
    public int update(Post post);
}
