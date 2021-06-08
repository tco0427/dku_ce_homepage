package action.post;

import action.Action;
import com.oreilly.servlet.MultipartRequest;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class PostUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository= PostRepositoryImpl.getInstance();

        Post post=null;

        String savePath = request.getSession().getServletContext().getRealPath("/");
        String content = null;
        String attachFileName=null;
        String filePath=null;
        int size=2*1024*1024*1024-1;
        try{
            //MultipartRequest에서 파일의 크기는 int의 범위인 2GB가 최대
            MultipartRequest multipartRequest=new MultipartRequest(request,savePath,size,"UTF-8");
            post=postRepository.findOne(Integer.parseInt(multipartRequest.getParameter("postId")));
            content=multipartRequest.getParameter("content");
            attachFileName = multipartRequest.getFilesystemName("attachFile");
            filePath=savePath+multipartRequest.getFilesystemName("attachFile");
        }catch(IOException e){
            e.printStackTrace();
        }
        post.setContent(content);
        post.setCreationDate(new Date(System.currentTimeMillis())); //수정한 날짜로 업데이트
        if(attachFileName!=null){
            post.setAttachFileName(attachFileName);
            post.setFilePath(filePath);
        }

        int code=postRepository.update(post);
        request.setAttribute("deleteErrorCode",code);
    }
}
