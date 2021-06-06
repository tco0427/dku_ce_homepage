package action.post;

import action.Action;
import com.oreilly.servlet.MultipartRequest;
import dao.PostRepository;
import dao.PostRepositoryImpl;
import dto.Post;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostCreateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String savePath = request.getSession().getServletContext().getRealPath("/");
        List<String> list=new ArrayList<>();
        String memberId = null;
        String title = null;
        String content = null;
        String classification = null;
        String attachFileName=null;
        String filePath=null;
        int size=2*1024*1024*1024-1;

        try{
            //MultipartRequest에서 파일의 크기는 int의 범위인 2GB가 최대
            MultipartRequest multipartRequest=new MultipartRequest(request,savePath,size,"UTF-8");
            memberId=multipartRequest.getParameter("memberId");
            title=multipartRequest.getParameter("title");
            content=multipartRequest.getParameter("content");
            classification=multipartRequest.getParameter("classification");
            attachFileName = multipartRequest.getFilesystemName("attachFile");
            filePath=savePath+multipartRequest.getFilesystemName("attachFile");
        }catch(IOException e){
            e.printStackTrace();
        }

        /*
        File file=new File(filePath);
        try(BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file))){
            attachFile=bufferedInputStream.readAllBytes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        list.add(memberId);
        list.add(title);
        list.add(content);
        list.add(classification);
        list.add(attachFileName);
        list.add(filePath);
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