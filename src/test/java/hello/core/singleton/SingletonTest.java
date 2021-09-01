package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조
        //soutv + tap (객체 출력문 자동생성)
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 은 memberService 2와 다르다 라는 뜻..
        assertThat(memberService1).isNotSameAs(memberService2);

        //우리가 만들었던 스프링 없는 순수한 DI 컨테이너인 AppConfig는 요청을 할 때마다 객체를 새로 생성한다.
        //고객 트래픽이 초당 100이나오면 초당 100개 객체가 생성되고 소멸된다!. -> 메모리 낭비가 심하다.
        //해결 방안은 해당 객체가 딱 1개만 생성되고, 공유하도록 설게하면 된다. -> 싱글톤 패턴턴

        // 접근지정자 static 과 private를 사용하였기떄문에 외부에서 접근지정자 사용이불가능
        // SingletoneService singletoneService = new SingletoneService(); (오류발생)


        //즉 SingletonService 클래스 객체를 생성하기위해서는 getInstance()메서드를 사용해야만 생성이 가능해진다.
        SingletoneService s1 = SingletoneService.getInstance();
        s1.logic();
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest() {
        // new SingletoneService(); [private 접근지정자를 가진 생성자 때문에 접근이 불가능해진다]
        SingletoneService singletoneService1 = SingletoneService.getInstance();
        SingletoneService singletoneService2 = SingletoneService.getInstance();

        System.out.println("singletoneService2 = " + singletoneService2);
        System.out.println("singletoneService1 = " + singletoneService1);

        assertThat(singletoneService1).isSameAs(singletoneService2);
        //same ==
        //equal java에 equals 메서드 오버라이딩
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        //AppConfig appConfig = new AppConfig();
        //이런식으로 스프링컨테이너를 사용하면 자동적으로 싱글톤패턴이 적용된다.

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 은 memberService 2와 다르다 라는 뜻..
        assertThat(memberService1).isSameAs(memberService2);

    }
}


