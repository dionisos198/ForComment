package MyfirstProject.ForComment.Repository;

import MyfirstProject.ForComment.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){
        Member member=new Member();
        member.setID("dionisos1");
        member.setName("이진우");
        member.setPassword("harar");
        memberRepository.save(member);
        Member findMember=memberRepository.findOne(member.getID());
        Assertions.assertThat(findMember.getID()).isEqualTo(member.getID());
        System.out.println(memberRepository.findAll());
    }


}