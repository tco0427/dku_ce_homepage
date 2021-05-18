package dto;

import dao.MemberRepository;
import dao.MemberRepositoryImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {
    public static final List<String> passwordHintQuestion= Arrays.asList("다른 이메일 주소는?", "나의 애완동물 이름은?","나의 아버지 성함은?", "나의 어머니 성함은?", "나의 별명은?", "나의 좌우명은?");
    private String id;
    private String password;
    private String email;
    private String name;
    private String nickname;
    private String passwordHint;
    private Integer studentID;

    public Member(){
        this(null,null,null,null,null,null,null);
    }
    public Member(String id, String password, String email, String name, String nickname, String passwordHint, Integer studentID) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.passwordHint = passwordHint;
        this.studentID = studentID;
    }
	public static Member createMember(List<String> list){
        String id=list.get(0);
        String password=list.get(1);

        String passwordCheck=list.get(2);
        if(password.equals(passwordCheck)){
        }else{
            return null;
        }
        String passwordHint=list.get(4);
        Integer studentID=Integer.parseInt(list.get(5));
        String name=list.get(6);
        String email=list.get(7);
        String nickname=list.get(8);
        if(nickname.equals("")){
            nickname=name;
        }

        return new Member(id,password,email,name,nickname,passwordHint,studentID);
    }

    public static String getNickName(String id){
        MemberRepository memberRepository= MemberRepositoryImpl.getInstance();
        Member member = memberRepository.findOne(id);
        if(member!=null){
            return member.getNickname();
        }else{
            return null;
        }
    }
}
