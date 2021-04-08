package dto;

import java.util.Arrays;
import java.util.List;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", findPasswordAnswer='" + passwordHint + '\'' +
                ", studentID=" + studentID +
                '}';
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

        return new Member(id,password,email,name,nickname,passwordHint,studentID);
    }
}
