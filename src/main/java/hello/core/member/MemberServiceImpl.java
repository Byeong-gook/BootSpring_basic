package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //memberRepository(추상화) 도 의존하고 MemoryMemberRepository(구체화)도 의존함으로 DIP 규칙에 위배된다.

    @Override
    public void join(Member member) {
            memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
