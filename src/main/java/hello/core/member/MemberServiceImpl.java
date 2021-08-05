package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    //오로지 인터페이스만 있다 !!!!

    @Autowired //ac.getBean(MemberRepository.class) 와 같이 동작 !!!
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    // test용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
