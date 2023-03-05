package MyfirstProject.ForComment.web;

import javax.validation.constraints.NotEmpty;

public class MemberForm {
    @NotEmpty(message="회원 아이디는 필수 입니다")
    private String ID;
    @NotEmpty(message="회원 비밀 번호는 필수 입니다")
    private String password;
    @NotEmpty(message="회원 이름은 필수 입니다")
    private String name;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
