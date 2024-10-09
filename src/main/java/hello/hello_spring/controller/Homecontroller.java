package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
    @GetMapping("/")
    public String home(){
        return "home";
        //사이트에 들어갈시 홈페이지가 바로 나옴
        //GetMapping 라우트 설정과 비슷함
        //요청이 오면 ->컨트롤러->없으면 스태틱파일을 찾음
    }
}
