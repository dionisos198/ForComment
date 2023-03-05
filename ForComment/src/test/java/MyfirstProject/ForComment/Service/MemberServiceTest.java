package MyfirstProject.ForComment.Service;

import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        Member member=new Member();
        member.setID("dionisos1");
        member.setName("이진우");
        member.setPassword("hth");
       String tmpid= memberService.join(member);
       assertEquals(member,memberRepository.findOne(tmpid));
    }
    @Test(expected=IllegalStateException.class)
    public void 중복확인() throws Exception{
        Member member1=new Member();
        Member member2=new Member();
        member1.setID("dionisos1");
        member2.setID("dionisos1");
        memberService.join(member1);
        memberService.join(member2);
        fail("예외가 발생해야 한다");
    }

}