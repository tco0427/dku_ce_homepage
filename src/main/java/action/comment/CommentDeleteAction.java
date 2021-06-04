package action.comment;

import action.Action;
import dao.CommentRepository;
import dao.CommentRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str=request.getParameter("id");
        Integer id=null;

        try{
            id=Integer.parseInt(str);
        }catch(NumberFormatException e){
            id=null;
        }


        int check=-1;
        if(id==null){
            check=-1;
            request.setAttribute("errorCode",check);
        }else{
            CommentRepository commentRepository=CommentRepositoryImpl.getInstance();
            check=commentRepository.delete(id);
            request.setAttribute("errorCode",check);
        }

    }
}
