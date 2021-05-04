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

        int size=postList.size();

        String page=request.getParameter("page");

        if(page==null){
            page="1";
        }else if(Integer.parseInt(page)>((size/10)+1)){
            page= Paging.getCurrentPage();
        }else if(Integer.parseInt(page)<=0){
            page="1";
        }

        Paging.setCurrentPage(page);

        String currentPageStr=Paging.getCurrentPage();
        Integer currentPage=null;
        try{
            currentPage=Integer.parseInt(currentPageStr);
        }catch(NumberFormatException e){
            currentPage=null;
        }

        int blockNum=Paging.getBlockNum(currentPage);

        List<Post> resultList=new ArrayList<>();

        int startIndex=(currentPage-1)*10;
        int checkSize=Integer.parseInt(Paging.getCurrentPage())*Paging.getPageCount();
        int showPageCount;

        if((size/checkSize)==0){
            int buf=Integer.parseInt(Paging.getCurrentPage())-1;
            buf=buf*Paging.getPageCount();
            if(buf==0){
                showPageCount=0;    //일단은 이렇게 해뒀음...
            }else {
                showPageCount = (size % buf);
            }
        }else{
            //마지막 페이지가 아니라면 if문에서 걸리지 않을 것이고 getPageCount()로 반환되는 10의 값이 넘어올 것이다.
            showPageCount=Paging.getPageCount();
        }

        for(int i=startIndex;i<(startIndex+showPageCount);i++){
            resultList.add(postList.get(i));
        }
        request.setAttribute("postList",resultList);
        request.setAttribute("blockNum", blockNum);
        request.setAttribute("classification",request.getParameter("classification"));
    }
}
