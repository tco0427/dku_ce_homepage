package controller;

import action.Action;
import action.post.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostController", value = "/Post/*")
public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI=request.getRequestURI();
        String contextPath=request.getContextPath();
        String command=requestURI.substring(contextPath.length());

        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        Action action=null;
        if(command.equals("/Post")){
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/form/postCreate.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostCreate")){
            action=new PostCreateAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/CEHome/Main");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostDelete")){
            action=new PostDeleteAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/CEHome/Main");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostUpdate")){
            action=new PostUpdateAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/post.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostDetail")){
            action=new PostFindAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/contentDetail.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}