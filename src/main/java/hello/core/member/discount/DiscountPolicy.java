package hello.core.member.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*
    * return 대상 할인 금액*/

    int discount(Member member, int price);
}
