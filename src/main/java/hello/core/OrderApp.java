package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService= appConfig.memberService();//new MemberServiceImpl();
//        OrderService orderService = appConfig.orderService();//new OrderServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(memberId);
//        System.out.println("main member get id : "+member.getId());
//        System.out.println("find memberId : "+findMember.getId());


        Order order = orderService.createOrder(memberId,"itemA",20000);

        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
