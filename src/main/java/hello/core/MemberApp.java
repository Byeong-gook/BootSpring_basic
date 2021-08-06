package hello.core;

import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {

    //psvm 입력후 엔터
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링은 모든것이  ApplicationContext라는것으로 시작하는데 (이걸 스프링컨테이너라고 보면된다 객체들을 모두 관리해주는거라고보면됨)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig에있는 환경설정정보를 가지고 (@Configuration @Bean) 관리해주는 역할을함.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //getBean메서드(이름[메서드이름] , 타입)


        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA",Grade.VIP);
        //ctrl + alt+ v

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
     }

}
