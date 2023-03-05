package MyfirstProject.ForComment.Domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class MemberActComment {
    @Id @GeneratedValue
    @Column(name="memberActComment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="act_id")
    private Act act;


    private String Comment;
    private int SatisfyLevel;
    private LocalDate localDate;
    public LocalDate getLocalDate(){
        return localDate;
    }
    public void setLocalDate(LocalDate t){
        this.localDate=t;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }


    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getSatisfyLevel() {
        return SatisfyLevel;
    }

    public void setSatisfyLevel(int satisfyLevel) {
        SatisfyLevel = satisfyLevel;
    }
}
