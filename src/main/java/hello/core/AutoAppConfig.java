package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.discount.DiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponenetScan @Component 어노테이션이 붙은것들을 다찾아서 컨테이너에 빈 등록을 해준다. @Autowired를 통해 의존관계자동주입을 한다.

//basePackages 탐색할 패키지의 시작위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
//basePackageClasses AutoAppConfig.class의 패키지는 hello.core 패키지 위로 탐색을한다.
//아무 설정도 해주지않으면
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

       /* @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }*/
}
