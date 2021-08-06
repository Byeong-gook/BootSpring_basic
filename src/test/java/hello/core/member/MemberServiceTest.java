package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    //Junit이라는 프레임워크 안에서 테스트를실행하기전 @BeforeEach 어노테이션이 먼저 실행되고 @Test가 실행되는것처럼
    //호출하는 제어권을 넘기는것또한 제어의 역전이라고 지칭한다.

    @BeforeEach //각 테스트 실행전에 반드시 실행되는것을 정의하는 어노테이션
    public void beofreEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
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
