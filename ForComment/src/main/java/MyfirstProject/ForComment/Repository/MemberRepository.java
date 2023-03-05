package MyfirstProject.ForComment.Repository;

import MyfirstProject.ForComment.Domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;
     public String save(Member member){
         em.persist(member);
         return member.getID();
     }
     public Member findOne(String id){
         return em.find(Member.class,id);
     }
     public List<Member> findAll(){
         return em.createQuery("select m from Member m",Member.class).getResultList();
     }
     public List<Member> findById(String ID){
         return em.createQuery("select m from Member m where m.ID=:ID",Member.class)
                 .setParameter("ID",ID).getResultList();
     }
}
