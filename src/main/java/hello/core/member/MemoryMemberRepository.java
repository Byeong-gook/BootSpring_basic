package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //컬렉션 프레임워크의 Hash Map을 사용
    //동시성이슈때문에 Concurrent HashMap을 써야함 실제업무에서는 예제라 HashMap을 썻음

    @Override
    public void save(Member member) {
            store.put(member.getId(), member); //HashMap형태로 회원정보 저장하기
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //회원 번호를 통해 회원정보 가져오기
    }
}
