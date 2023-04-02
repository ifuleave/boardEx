package org.zerock.boardex.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mock.web.MockAsyncContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.boardex.dto.TodoDTO;
import org.zerock.boardex.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다. 새로운 필드를 추가할 때 다시 생성자를 만들어서 관리해야하는 번거로움을 없애준다. (@Autowired를 사용하지 않고 의존성 주입)
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(Model model){

        log.info("todo 리스트");
        model.addAttribute("dtoList",todoService.getAll() );
        // model에는 dtoList라는 이름으로 목록데이터를 담았기 때문에 jsp에서 jstl을 이용해서 목록을 축력함
    }

    @GetMapping("/register")
    public void registerGET(){
        log.info("GET todo register..........");
    }

    @PostMapping("/register") //TodoDTO로 바로 전달되 ㄴ파라미터의 값들을 수집.
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        log.info("!!!!!!!!!!!POST TODO register!!!!!!!!!!!!");

        if (bindingResult.hasErrors()){ //hasErrors를 이용해서 검증에 문제가 있다면 다시 입력화면으로 // 여기 dueDate 에러가 난다면 formatter 처리해줘야함
            log.info("!!!!!에러++제목: 빈값안됨, 날짜 : 현재보다미래, 작성자 : 빈값안됨!!!!!!");
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);
        return "redirect:/todo/list"; //post방식으로 처리한 후 list로 돌아가야 하기때문에 문자열을 반활 할 수 있도록 처리
    }

    //한개 조회
    @GetMapping("/read")
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto",todoDTO);
    }


}
