package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        request.setAttribute("post",postRepository.findOne(id));
        request.setAttribute("postId",id);
    }
}
