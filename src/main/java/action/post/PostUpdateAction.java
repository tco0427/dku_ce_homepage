package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Classification;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class PostUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository= PostRepositoryImpl.getInstance();
        Post post=postRepository.findOne(Integer.parseInt(request.getParameter("id")));

        List<String> list=new ArrayList<>();


        Enumeration<String> parameters=request.getParameterNames();
        parameters.nextElement();

        while(parameters.hasMoreElements()){
            list.add(request.getParameter(parameters.nextElement()));
        }

        String title=list.get(0);
        post.setTitle(title);
        String content=list.get(1);
        post.setContent(content);
        String classification=list.get(2);
        post.setClassification(Classification.valueOf(classification));


        int code=postRepository.update(post);
        request.setAttribute("errorCode",code);
    }
}
