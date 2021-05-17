package action.post;

import action.Action;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Classification;
import dto.Post;
import paging.Paging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PostListAction implements Action {
    private String classification;

    public PostListAction(String classification) {
        this.classification = classification;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository= PostRepositoryImpl.getInstance();
        Classification classification=Classification.valueOf(this.classification);
        List<Post> postList=postRepository.findByClassification(classification);
        List<Post> resultList=new ArrayList<>();

        int blockNum = Paging.getPage(postList, request.getParameter("page"), resultList);
        request.setAttribute("postList",resultList);
        request.setAttribute("blockNum", blockNum);
        request.setAttribute("classification",request.getParameter("classification"));
    }
}
