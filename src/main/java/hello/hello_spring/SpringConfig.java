package hello.hello_spring;

import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
        //스프링이 컨피그레이션,빈을 읽고 멤버서비스가 로직을 읽고 스프링 빈에 등록
        //MemberSerivce를 추가
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    //MemberSeivce,MemberRepository를 스프링 빈에 등록,등록되어 있는 리포지토리를 멤버 서비스에 넣어준다.
    //컨트롤러는 스프링이 관리함
    //과거엔 xml  실무에선 거의 자바코드로 설정
    //DI에는 필드 주입, setter주입 생성자주입이 있음, 생성자를 통해서 멤버서비스가 멤버 컨트롤러에 들어가는 것을 생성자주입
    //생정자가 아닌 필드에 @Autowired 의존성 주입을 하면 필드 주입 별로 안좋음 스프링이 뜰대만 넣어주고 이후 코드를 바꿀수 없음
    //setter 주입
    //setXXX 누군가가 멤버 컨트롤러를 호출했을 때 퍼블릭으로 오픈되어있어야함 멤버서비스를 중간에 바꿀일이 없지만
    //만약 잘못 바꾸게되면 문제가 발생,최대한 호출이 안되어야할 코드가 호출이 되지않겠금 막아야한다.
    //생성자 주입을하면 애플리케이션 조립 때 한번 발생하고 맘 생성자 주입 써야함
    //런타임이 떠 있을 때 코드가 바뀔 일이 없음 만약 바껴야한다면 끄고 나서 바꿈
    //실무에서는 주로 정형화된 컨트롤러,서비스,리포지토리 같은 코드는 컴포넌트 스캔을 사용
    //정형화된 코드 ->일반적 컨트롤러,리포지토리
    //정형화 되지않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
    //상황에 따라 구현 클래스 구현 바뀔 일이 많음-> 임시로 인터페이스를 사용하는건데 다른 리포지토리로 바꿔야할 때 기존 멤버서비스나
    //다른 코드를 바꿀 필요 없이 구현 클래스를 바꿀 수 있음 MemberRepository -> DbMemberRepository로 바꿀 때 다른걸 건들필요없음
    //@Autowired를 통한 DI는 helloController,MemberSerivce등과 같이 스프링이 관리하는 객체에서만 동작한다.
    //스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에셔는 동작하지 않는다
    //스프링이 관리 안하면 @Autowired 가 작동하지않음,new로 객체를 생성 했을 때도 @Autowired가 동작되지않음




}

