package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //주문 컨트롤러등등 사용할 수 있다. 따라서 하나 하나 객체를 생성은 별로 좋지 않다
    //Autowired는 스프링 컨테이너에 등록한 빈에게 의존관계 주입이 필요할때 의존성 주입을 도와주는 어노테ㅅ이션이다.
    @GetMapping("/members/new")
    public  String createFrom(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        //모든 멤버를 가지고 올 수 있다.
        model.addAttribute("members",members);
        return "members/memberList";
        //멤버 리스트 자체를 모델에 담아서 화면에 넘길거임
        //템플릿엔진에서 members를 읽어냄 루프를 돌면서 로직을 실행시킴
        //첫번째 객체를 꺼내서 members에 담고 id와 name을 출력함
        //데이터베이스가 아닌 메모리에 저장을 했기 때문에 서버를 내리면 데이터가 사라짐
    }

}

