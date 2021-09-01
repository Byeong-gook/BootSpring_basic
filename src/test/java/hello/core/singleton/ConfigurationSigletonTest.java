package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSigletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository =" + memberRepository1);
        System.out.println("orderService -> memberRepository =" + memberRepository2);
        System.out.println("memberRepository =" + memberRepository);
        //3번의 memberRepository 객체를 생성하는 코드가 실행되므로 각기다른 객체가 생성되리라 생가하지만
        //스프링의 GCLIB 내부기술을 통해 스프링 빈이 이미 존재하면 스프링컨테이너에 존재하는 빈을 생성하고 없으면 스프링으빈으로 등록하고 반환하는 코드가 동적으로 만들어져있어서
        //3번 객체를 생성하는코드가 실행되더라도 한번의 객체만 생성한것처럼 되는것이다.

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean= " + bean.getClass());
    }

}
