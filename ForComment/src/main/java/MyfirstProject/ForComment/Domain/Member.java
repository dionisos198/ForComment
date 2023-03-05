package MyfirstProject.ForComment.Domain;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id @Column(name="member_id")
    private String ID;
    private String name;
    private String password;
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberActComment> MAComment=new ArrayList<>();


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MemberActComment> getMAComment() {
        return MAComment;
    }

    public void setMAComment(List<MemberActComment> MAComment) {
        this.MAComment = MAComment;
    }
}
