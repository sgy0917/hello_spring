package hello.hello_spring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //회원가입 -> members/new(get방식)->members/createMemberForm으로 이동 static의 view resolve로 인해
    //createMemberForm이 선택이 됨 타임리프템플릿 엔진이 렌더링함
    //form 태그 입력 태그에 값 입력 등록버튼 ->action url에 post 방식으로 넘어감 -> PostMapping이 사용됨
    //데이터를 폼에 담아 전달할 때 POST 사용 ,값을 조회할 때 GET 사용
    //URL은 같지만 포스트매핑으로 인해 create 메소드 호출 -> MemberForm 컨트롤러 내의 name 필드에 setXXX로 인해값이 들어가게 된다.
    //getName으로 값을 꺼냄 membersSerivce.join(member)로 인해 값을 꺼낼 수 있게됨
}
