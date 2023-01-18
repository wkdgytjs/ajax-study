package org.spring.ajax.controller;

import lombok.RequiredArgsConstructor;
import org.spring.ajax.dto.AjaxMemberDto;
import org.spring.ajax.service.AjaxMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    private final AjaxMemberService ajaxMemberService;

    @GetMapping("/index")
    public String index(){
        return "ajax_index";
    }

    @GetMapping("/ajax1")
    public @ResponseBody String ajax1(){
        System.out.println("서버 console 출력: ajax1");
        return "ajax1";
    }

    @PostMapping("/ajax2")
    public @ResponseBody String ajax2(){
        System.out.println("서버 console 출력: ajax2");
        return "ajax2";
    }

    @PostMapping("/ajax3")
    public @ResponseBody String ajax3(// form 키:value& userName=m1$userPw=11
                                      @RequestParam("userName") String userName,
                                      @RequestParam("userPw") String userPw
                                      ){
        System.out.println("ajax3");

        System.out.println("userName: "+userName);
        System.out.println("userPw: "+userPw);

        return "userName: "+userName+", userPw: "+userPw;
    }

    @PostMapping("/ajax4")
    public @ResponseBody AjaxMemberDto ajax4(@ModelAttribute AjaxMemberDto ajaxMemberDto){

        System.out.println("ajax4");

        ajaxMemberDto.setId(0L);
        System.out.println("ajaxMember: "+ ajaxMemberDto);

        return ajaxMemberDto;
    }

    @GetMapping("/memberJoin")
    public String memberJoin1(){
        return "ajax_join";
    }
    //회원가입
    @PostMapping("/memberJoin")
    public @ResponseBody int memberJoin2(@ModelAttribute AjaxMemberDto ajaxMemberDto){
        int rs=ajaxMemberService.insertMember(ajaxMemberDto);
        return rs;
    }

    // 아이디 중복 검사
    @PostMapping("/nameChecked")
    public @ResponseBody int nameChecked(@RequestParam String userName){

        int rs=ajaxMemberService.findByUserNameDo(userName);

        return rs;
    }
    // 회원조회

    @GetMapping("/memberList")
    public String memberList(){
        return "ajax_list";
    }

    @GetMapping("/memberList2")
    public @ResponseBody List<AjaxMemberDto> memberList2(){

        List<AjaxMemberDto> memberLists=ajaxMemberService.memberListDo();

        return memberLists;
    }

    @GetMapping("/detail")
    public String detail(){
        return "ajax_detail";
    }

    @PostMapping("/detail")
    public @ResponseBody AjaxMemberDto detail2(@RequestParam Long id){

        AjaxMemberDto ajaxMemberDto=ajaxMemberService.findByIdDo(id);

        if(ajaxMemberDto!=null){
            System.out.println("Success");
        }else{
            System.out.println("Fail");
        }

        return ajaxMemberDto;
    }
}
