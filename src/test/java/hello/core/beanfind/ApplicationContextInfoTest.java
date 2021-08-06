package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    //이전파일 돌아가기 Ctrl+E

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() { //junit 5부터 접근지정자 public 선언안해줘도됨
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //빈에 정의된이름을 String배열에 등록해준다.

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
        //iter 하고 tab키를 누르면 for문이 자동으로 완성된다.
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() { //junit 5부터 접근지정자 public 선언안해줘도됨
        //빈에 정의된이름을 String배열에 등록해준다.
        //ac.getBeanDefinitinitionNames() // 스프링에 등록된 모든 빈이름을 조회한다.
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();


        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //ac.getBean() : 빈이름으로 빈객체(인스턴스)를 조회한다.
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
        //iter 하고 tab키를 누르면 for문이 자동으로 완성된다.
    }
}
