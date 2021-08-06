package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.discount.DiscountPolicy;
import hello.core.member.discount.FixDiscountPolicy;
import hello.core.member.discount.RateDiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//AppConfig는 애플리케이션의 실제동작에 필요한 구현객체를 생성한다.
//AppConfig는 생성한 객체 인스턴즈의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.

//리팩토링 단축키 ctrl + alt + m
//제어의역전 IoC Inversion of Control


//설정 정보를 담당하는 뜻을가진 어노테이션
@Configuration
public class AppConfig {

    //Bean 어노테이션이 있는 메서드는 다 스프링컨테이너에 등록이된다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    } //생성자를 통한 의존성주입 (생성자주입)

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
        //return new FixDiscountPolicy();
    }
}
