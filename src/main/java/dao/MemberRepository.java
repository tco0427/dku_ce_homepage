package dao;

import dto.Member;

import java.util.List;

public interface MemberRepository {
    public int save(Member member);
    public int delete(String id);
    public int editMail(Member member);
    public int editPassword(Member member);
    public Member findOne(String id, String password);
    public Member findOne(String id);
    public List<Member> findAll();
    public List<Member> findByHint(String passwordHint);
    public int updateMember(Member member);
}
