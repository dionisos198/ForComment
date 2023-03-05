package MyfirstProject.ForComment.Repository;

import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Domain.MemberActComment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberActCommentRepository {
    @PersistenceContext
    EntityManager em;

    public void save(MemberActComment mac){
        em.persist(mac);
    }
    public MemberActComment findOne(Long id){
        return em.find(MemberActComment.class,id);
    }
    public List<MemberActComment> findAll(){
        return em.createQuery("select mac from MemberActComment mac", MemberActComment.class).getResultList();
    }


}
