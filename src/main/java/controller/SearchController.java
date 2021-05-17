package controller;

import action.Action;
import action.SearchAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchController", value = "/Search/*")
public class SearchController extends HttpServlet {
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
        if(command.equals("/Search/")){
            action=new SearchAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/searchView.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
