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

@WebServlet(name = "ClassificationController", value = "/Classification/*")
public class ClassificationController extends HttpServlet {
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
        if(command.equals("/Classification/Notice")){
            action=new PostListAction("Notice");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/notice.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Classification/Study")){
            action=new PostListAction("Study");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/study.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Classification/Free")){
            action=new PostListAction("Free");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/free.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Classification/Documents")){
            action=new PostListAction("Documents");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/documents.jsp");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Classification/Anonymous")){
            action=new PostListAction("Anonymous");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/post/anonymous.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
