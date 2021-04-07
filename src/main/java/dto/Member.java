package dto;

public class Member {

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
}
