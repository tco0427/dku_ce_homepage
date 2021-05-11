package action;

import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;
import paging.Paging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SearchAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository= PostRepositoryImpl.getInstance();
        List<Post> postList=postRepository.findBySearch(request.getParameter("query"));
        List<Post> resultList=new ArrayList<>();

        int blockNum = Paging.getPage(postList, request.getParameter("page"),resultList);


        request.setAttribute("postList",resultList);
        request.setAttribute("blockNum", blockNum);
    }
}
