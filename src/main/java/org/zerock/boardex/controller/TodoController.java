package org.zerock.boardex.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
    @GetMapping({"/read","/modify"}) // 수정과 삭제는 get방식으조회 후 post로 처리,get방식의 내용은 조회화면과 같지만 스프링 mvc에 여러개의 경로를 배열과 같은 표기법을 이용해서 하나의 @getMapping으로 처리할 수 있기 때문에 read(0기능을 수정해서 같은메소드 이용
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto",todoDTO);
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){
        log.info("---------remove-----------");
        log.info("tno:"+tno);

        todoService.remove(tno);
        return "redirect:/todo/list";
    }

    @PostMapping("/modify") //valid를 이용해서 필요한 내용즐 검증, 문제있으면 modify로 이동,todo/modify로 이동시키려면 tno미터가 필요하므로 redirectAttributes를 이용해서 
                               //addattribute()를 이용하고  errors라는 이름으로 bindingResult의 모든 에러들을 전달함     
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            log.info("has errors..........");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno",todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
//        redirectAttributes.addAttribute("tno",todoDTO.getTno());
//        redirectAttributes.addAttribute("size",pageRequestDTO.getSize());

        return "redirect:/todo/list";
    }
}
