package dao;

import dto.Post;

import java.util.List;

public interface PostRepository {
    public int add(Post post);
    public int delete(Integer id);
    public Post findOne(Integer id);
    public List<Post> findAll();
    public int update(Post post);
}
