package th_work.work.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import th_work.work.post.dto.MemberDto;
import th_work.work.post.service.MemberService;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("user/signup")
    public String signUpForm(){
        return "users/signup.html";
    }

    @PostMapping("user/signup")
    public String signUp(MemberDto memberDto)
    {
        memberService.joinUser(memberDto);
        return "redirect:/";
    }

    @GetMapping("user/login")
    public String member()
    {
        return "users/login.html";
    }

    @GetMapping("admin")
    public String list(Model model){

        List<MemberDto> memberDtoList = memberService.getMemberList();
        model.addAttribute("memberList", memberDtoList);
        return "users/admin.html";
    }
}






