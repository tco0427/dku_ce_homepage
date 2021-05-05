package controller;

import action.Action;
import action.member.MemberJoinAction;
import action.member.MemberLoginAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberController", value = "/Member/*")
public class MemberController extends HttpServlet {
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
        if(command.equals("/Member/MemberLogin")){
            action=new MemberLoginAction("login");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/CEHome/Main");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Member/MemberLogout")){
            action=new MemberLoginAction("logout");
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/CEHome/Main");
            requestDispatcher.forward(request,response);
        }else if(command.equals("/Member/MemberJoin")){
            action=new MemberJoinAction();
            action.execute(request,response);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("/CEHome/Main");
            requestDispatcher.forward(request,response);
        }
    }
}