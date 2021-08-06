package hello.core.member.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements  DiscountPolicy{
    int discountPercent = 10;

    //테스트 코드 작성 단축키 ctrl + shift + t
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return  price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
