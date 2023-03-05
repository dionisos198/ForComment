package MyfirstProject.ForComment.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Act {
    @Id @GeneratedValue
    @Column(name="act_id")
    private Long id;

    private String name;

    private String status;
    @OneToMany(mappedBy = "act",cascade = CascadeType.ALL)
    private List<MemberActComment> MAComment=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MemberActComment> getMAComment() {
        return MAComment;
    }

    public void setMAComment(List<MemberActComment> MAComment) {
        this.MAComment = MAComment;
    }
}
