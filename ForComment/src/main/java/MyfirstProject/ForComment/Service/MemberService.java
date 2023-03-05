package MyfirstProject.ForComment.Service;

import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public String join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getID();
    }
    private void validateDuplicateMember(Member member){
        List<Member> findMembers=memberRepository.findById(member.getID());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("아이디가 중복되었습니다");
        }
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findOne(String memberId){
        return memberRepository.findOne(memberId);
    }

}
