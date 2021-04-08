<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Member" %>
<%@ page import="dao.MemberRepository" %>
<%@ page import="dao.MemberRepositoryImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    Enumeration<String> parameterNames = request.getParameterNames();

    List<String> list=new ArrayList<>();
    while(parameterNames.hasMoreElements()){
        list.add(request.getParameter(parameterNames.nextElement()));
    }

    Member member=Member.createMember(list);

    if(member==null){
        out.println("<script>alert('정상적으로 처리되지 않았습니다.');history.go(-1)</script>");
    }else{
        MemberRepository memberRepository=MemberRepositoryImpl.getInstance();
        int check=memberRepository.save(member);
        if(check==-1){
            out.println("<script>alert('정상적으로 처리되지 않았습니다.');history.go(-1)</script>");
        }else if(check==-10){
            out.println("<script>alert('이미 존재하는 아이디입니다.');history.go(-1)</script>");
        }else{
            response.sendRedirect("/view/home.jsp");
        }
    }
%>
