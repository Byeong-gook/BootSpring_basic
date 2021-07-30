package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given 이런이런게 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 이렇게했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게된다.
        Assertions.assertThat(member).isEqualTo(findMember);
        //검증은 Assertions API를 이용하면 편하게 할수있음.
    }
}
