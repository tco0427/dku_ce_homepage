package action.post;

import action.Action;
import dao.CommentRepository;
import dao.CommentRepositoryImpl;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Comment;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PostFindAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id=null;
        try{
            id=Integer.parseInt(request.getParameter("id"));
        }catch(NumberFormatException e){
            id=null;
        }

        PostRepository postRepository= PostRepositoryImpl.getInstance();
        Post post = postRepository.findOne(id);


        CommentRepository commentRepository= CommentRepositoryImpl.getInstance();
        List<Comment> commentList = commentRepository.findByPost(id);

        request.setAttribute("post",post);
        request.setAttribute("commentList",commentList);
        request.setAttribute("postId",id);
    }
}