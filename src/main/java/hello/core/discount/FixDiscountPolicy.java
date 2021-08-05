package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //천원 할인

    @Override
    public int discount(Member member, int price) {
        System.out.println(member.getGrade());
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
