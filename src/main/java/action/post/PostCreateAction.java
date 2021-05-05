package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PostCreateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> list=new ArrayList<>();
        String memberId = request.getParameter("memberId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String classification = request.getParameter("classification");

        list.add(memberId);
        list.add(title);
        list.add(content);
        list.add(classification);

        Post post=Post.createPost(list);

        if(post==null){
            request.setAttribute("errorCode",-1);
        }else{
            PostRepository postRepository= PostRepositoryImpl.getInstance();
            int check=postRepository.add(post);
            request.setAttribute("errorCode",check);
        }
    }
}