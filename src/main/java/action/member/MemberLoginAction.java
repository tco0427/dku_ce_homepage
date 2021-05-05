package action.member;

import action.Action;
import dao.MemberRepository;
import dao.MemberRepositoryImpl;
import dto.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginAction implements Action {
    private String flag;
    public MemberLoginAction(String flag) {
        this.flag=flag;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        MemberRepository memberRepository= MemberRepositoryImpl.getInstance();
        if(flag.equals("login")){
            Member member=memberRepository.findOne(request.getParameter("id"),request.getParameter("password"));
            if(member!=null){
                session.setAttribute("login","success");
                session.setAttribute("id",member.getId());
                session.setAttribute("name",member.getName());
            }else{
                request.setAttribute("loginFail",true);   //로그인 실패
            }

        }else if(flag.equals("logout")){
            session.invalidate();
        }
    }
}
