package MyfirstProject.ForComment.Repository;

import MyfirstProject.ForComment.Domain.Act;
import MyfirstProject.ForComment.Domain.GoodStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ActRepositoryTest {
    @Autowired
    ActRepository actRepository;
    @Test
    @Rollback(false)
    public void ActTest(){
        Act act=new Act();
        act.setName("게임");
        act.setStatus("Good");
        actRepository.save(act);
        Act findAct=actRepository.findOne(act.getId());
        org.assertj.core.api.Assertions.assertThat(findAct.getId()).isEqualTo(act.getId());


    }

}