package MyfirstProject.ForComment.web;

import MyfirstProject.ForComment.Domain.Act;
import MyfirstProject.ForComment.Domain.GoodStatus;
import MyfirstProject.ForComment.Domain.Member;
import MyfirstProject.ForComment.Service.ActService;
import MyfirstProject.ForComment.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
@Controller
public class ActController {
    private final ActService actService;
    @Autowired
    public ActController(ActService actService) {
        this.actService=actService;
    }
    @GetMapping("/activities/new")
    public String createForm(Model model){
        model.addAttribute("activityForm",new ActivityForm());
        return "activities/createActivityForm";
    }
    @PostMapping("/activities/new")
    public String create(@Valid ActivityForm form, BindingResult result){
        if(result.hasErrors()){
            return "activities/createActivityForm";
        }
        Act act=new Act();
        act.setName(form.getName());
        act.setStatus(form.getStatus());
        actService.join(act);
        return "redirect:/";
    }
    @GetMapping(value="/activities")
    public String list(Model model){
        List<Act> acts=actService.findActs();
        model.addAttribute("acts",acts);
        return "activities/activityList";
    }
}
