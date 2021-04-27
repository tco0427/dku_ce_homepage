package controller;

import action.Action;
import action.post.PostCreate;
import action.post.PostDelete;
import action.post.PostFind;
import action.post.PostUpdate;

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
        if(command.equals("/Post/PostCreate")){
            action=new PostCreate();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/post.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostDelete")){
            action=new PostDelete();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostRead")){
            action=new PostFind();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/postList.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Post/PostUpdate")){
            action=new PostUpdate();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/post.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}