package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.nimbus.State;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleTon() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //B 사용자가 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //TheadA: 사용자 A가 주문 금액 조회
        //A가 주문 금액을 요청하고 조회하는사이에 B가 끼어들어왔음
       // int price = statefulService1.getPrice();

        System.out.println("price = " + userAPrice);

    // assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
