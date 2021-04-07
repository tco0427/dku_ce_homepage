<%@ page import="dto.Member" %>
<%@ page import="dao.MemberRepository" %>
<%@ page import="dao.MemberRepositoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id=request.getParameter("id");
    String password=request.getParameter("password");

    MemberRepository memberRepository= MemberRepositoryImpl.getInstance();

    Member member=memberRepository.findOne(id,password);

    if(member==null){
        out.println("<script>alert('로그인에 실패하였습니다.');history.go(-1);</script>");
    }else{
        response.sendRedirect("/view/home.jsp");
    }

%>
