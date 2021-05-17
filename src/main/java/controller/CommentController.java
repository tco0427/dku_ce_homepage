package controller;

import action.Action;
import action.comment.CommentCreateAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommentController", value = "/Comment/*")
public class CommentController extends HttpServlet {
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
        if(command.equals("/Comment/Create")){
            action=new CommentCreateAction();
            action.execute(request,response);
            String url = "/Post/PostDetail".concat("?id="+request.getParameter("postId"));
            RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
            requestDispatcher.forward(request,response);
        }
    }
}
