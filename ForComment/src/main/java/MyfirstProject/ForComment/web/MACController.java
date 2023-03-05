package MyfirstProject.ForComment.web;

import MyfirstProject.ForComment.Domain.Act;
import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Domain.MemberActComment;
import MyfirstProject.ForComment.Service.ActService;
import MyfirstProject.ForComment.Service.MemberActCommentService;
import MyfirstProject.ForComment.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MACController {
    private final MemberService memberService;
    private final ActService actService;
    private final MemberActCommentService memberActCommentService;

    public MACController(MemberService memberService, ActService actService, MemberActCommentService memberActCommentService) {
        this.memberService = memberService;
        this.actService = actService;
        this.memberActCommentService = memberActCommentService;
    }
    @GetMapping("/mac/new")
    public String createForm(Model model){
        List<Member> members=memberService.findMembers();
        List<Act> acts=actService.findActs();
        model.addAttribute("members",members);
        model.addAttribute("acts",acts);
        return "macs/createMACForm";
    }
    @PostMapping("/mac/new")
    public String create(@RequestParam("memberId") String memberId,
                         @RequestParam("actId") Long actId,@RequestParam("comment") String comment,
                         @RequestParam("satisfyLevel") int level){
        memberActCommentService.create(memberId,actId,comment,level);
        return "redirect:/";
    }
    @GetMapping("/macs")
    public String list(Model model){
        List<MemberActComment> macs=memberActCommentService.findMACS();
        model.addAttribute("macs",macs);
        return "macs/macList";
    }

}



