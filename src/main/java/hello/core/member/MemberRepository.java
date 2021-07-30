package hello.core.member;

public interface MemberRepository {

    void save(Member member); // 회원을 저장하는기능

    Member findById(Long memberId); // 회원 아이디찾기

}
