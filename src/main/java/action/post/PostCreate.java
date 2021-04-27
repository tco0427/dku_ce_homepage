package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class PostCreate implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> list=new ArrayList<>();
        Enumeration<String> parameters=request.getParameterNames();
        while(parameters.hasMoreElements()){
            list.add(request.getParameter(parameters.nextElement()));
        }
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
