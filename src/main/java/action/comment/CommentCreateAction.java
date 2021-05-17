package action.comment;

import action.Action;
import dao.CommentRepository;
import dao.CommentRepositoryImpl;
import dto.Comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CommentCreateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> list=new ArrayList<>();
        String memberId = request.getParameter("memberId");
        String postId = request.getParameter("postId");
        String content = request.getParameter("content");

        list.add(memberId);
        list.add(postId);
        list.add(content);

        Comment comment= Comment.createComment(list);


        if(comment==null){
            request.setAttribute("errorCode",-1);
        }else{
            CommentRepository commentRepository= CommentRepositoryImpl.getInstance();
            int check=commentRepository.save(comment);
            request.setAttribute("errorCode",check);
        }
    }
}
