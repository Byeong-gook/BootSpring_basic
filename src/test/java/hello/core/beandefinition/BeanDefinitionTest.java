package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //빈을 설정하는 방법을 크게보면 2가지로나눌수있음
    //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // 팩토리메서드를 쓰는방법
    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); // 직접 스프링 빈을 등록하는방법 xml방식

    @Test
    @DisplayName("빈 설정 메타 정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionname = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}