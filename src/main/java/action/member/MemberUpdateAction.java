package action.member;

import action.Action;
import dao.MemberRepository;
import dao.MemberRepositoryImpl;
import dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String memberId=request.getParameter("memberId");
        Member member=Member.getMember(memberId);

        String password=request.getParameter("password");
        String passwordCheck=request.getParameter("passwordCheck");
        String email=request.getParameter("email");
        String nickname=request.getParameter("nickname");

        if(password.equals(passwordCheck)){
            member.setPassword(password);
            member.setEmail(email);
            member.setNickname(nickname);
            MemberRepository memberRepository= MemberRepositoryImpl.getInstance();
            int check=memberRepository.updateMember(member);
            request.setAttribute("updateErrorCode",check);
        }else{
            request.setAttribute("updateErrorCode",-1);
        }
    }
}
