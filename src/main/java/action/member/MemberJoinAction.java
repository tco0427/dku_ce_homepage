package action.member;

import action.Action;
import dao.MemberRepository;
import dao.MemberRepositoryImpl;
import dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MemberJoinAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<String> list=new ArrayList<>();

        Enumeration<String> parameters=request.getParameterNames();

        while(parameters.hasMoreElements()){
            list.add(request.getParameter(parameters.nextElement()));
        }

        Member member=Member.createMember(list);
        if(member==null){
            request.setAttribute("registerErrorCode",-1);
        }else{
            MemberRepository memberRepository= MemberRepositoryImpl.getInstance();
            int check=memberRepository.save(member);
            request.setAttribute("registerErrorCode",check);
        }
    }
}
