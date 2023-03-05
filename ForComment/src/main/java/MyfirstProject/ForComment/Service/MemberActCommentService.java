package MyfirstProject.ForComment.Service;

import MyfirstProject.ForComment.Domain.Act;
import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Domain.MemberActComment;
import MyfirstProject.ForComment.Repository.ActRepository;
import MyfirstProject.ForComment.Repository.MemberActCommentRepository;
import MyfirstProject.ForComment.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberActCommentService {
    private final MemberRepository memberRepository;

    private final ActRepository actRepository;
    private final MemberActCommentRepository memberActCommentRepository;

    public MemberActCommentService(MemberRepository memberRepository, ActRepository actRepository, MemberActCommentRepository memberActCommentRepository) {
        this.memberRepository = memberRepository;
        this.actRepository = actRepository;
        this.memberActCommentRepository = memberActCommentRepository;
    }

    @Transactional
    public void create(String memberId, Long actId,String comment,int SatisfyLevel){
        Member member= memberRepository.findOne(memberId);
        Act act= actRepository.findOne(actId);
        MemberActComment mac=new MemberActComment();
        mac.setMember(member);
        mac.setAct(act);
        mac.setSatisfyLevel(SatisfyLevel);
        mac.setComment(comment);
        mac.setLocalDate(LocalDate.now());
        memberActCommentRepository.save(mac);
    }
    public List<MemberActComment> findMACS(){
        return memberActCommentRepository.findAll();
    }
    public MemberActComment findOne(Long macId){
        return memberActCommentRepository.findOne(macId);
    }
}
