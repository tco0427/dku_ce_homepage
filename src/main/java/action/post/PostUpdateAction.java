package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PostUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository= PostRepositoryImpl.getInstance();
        Post post=postRepository.findOne(Integer.parseInt(request.getParameter("postId")));

        String content=request.getParameter("content");
        post.setContent(content);

        int code=postRepository.update(post);
        request.setAttribute("deleteErrorCode",code);
    }
}
