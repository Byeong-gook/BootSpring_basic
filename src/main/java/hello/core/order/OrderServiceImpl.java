package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.discount.DiscountPolicy;
import hello.core.member.discount.FixDiscountPolicy;
import hello.core.member.discount.RateDiscountPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
/*@RequiredArgsConstructor //필드변수에 final이 붙은걸 파악해서 생성자를 만들어주는 어노테이션*/
public class OrderServiceImpl implements  OrderService {
    //필드 주입

    private final MemberRepository memberRepository; // private final 값을 지정해줘
    private final DiscountPolicy discountPolicy;


    //초기값을 넣어주지 않는 이상 final 키워드를 부여하면 생성자주입을 통해서만 값을 부여할수있다.
    //final 키워드는 초기단계에 반드시 값을 투입해줘야한다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy  DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //수정자 주입(setter 주입)
    //setter라 불리는 필드의 값을 변경하는 수정자 메서드를 통해서 의존관계를 주입하는 방법이다.
    //특징 : 선택 , 변경 가능성이 있는 의존관계에 사용 , 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법이다.
    //필수값이 아닐시 의존성 주입할 대상이 없어도 오류가 발생하지않도록 @Autowired 어노테이션 옆에 (required = false) 옵션값을 부여해준다.
 /*  @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
*/

  /*  //메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
*/
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문데이터 반환환
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}