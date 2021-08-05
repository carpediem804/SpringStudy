package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext(TestConfig.class);


        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //thread a
        int priceA = statefulService1.order("userA",10000);
        //thread b
    int priceB =        statefulService2.order("userB",20000);

        //threadA 사용자 주문 금액 확인
       // int price = statefulService1.getPrice();
       // System.out.println("price = " + price);

        org.assertj.core.api.Assertions.assertThat(priceA).isEqualTo(10000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}