package com.webprj.project_green.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import oracle.jdbc.proxy.annotation.Post;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;
import com.webprj.project_green.service.BoardService;

import ch.qos.logback.classic.Logger;

@Controller
public class GreenController {
    
	private static final CustomDto CustomDto = null;
	@Autowired
	private BoardService boardService;
	
    //硫붿씤�솕硫�
    @GetMapping("/index")
    public String welcomeMain(Model model, HttpSession session){
    	model.addAttribute("sess_id", (String) session.getAttribute("id"));
        return "index";
    }


    //�냼媛쒗솕硫�
    @GetMapping("/intro")
    public String goIntroduction(){

        return "redirect:/index#introduction";
    }
    
    //�옲�궧寃뚯떆�뙋
    @GetMapping("/rank")
    public String goToRank(){
        
        return "rank/rank";
    }

    //로그인 화면
	@PostMapping("/login/join")
	public String login(@ModelAttribute CustomDto customDto) {
		System.out.println(customDto);
		boardService.join(customDto);
		
		return "login/joinOk";
	}
	//회원가입 성공
	@GetMapping("/joinOk")
	public String gojoinOk(){
		return "/login/joinOk";
	}
	
    @GetMapping("/login")
    public String sign() {
    	return "login/login";
    }
    
    // 로그인 하기
    @PostMapping("/login/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session) {
		return boardService.logins(id, password, session);
	}
 
    //�쉶�썝媛��엯
    @GetMapping("/join")
    public String goJoin(){

        return "login/join";
    }
    
//    //중복확인1********************************************************************************
//    @RequestMapping("/idcheck/boardDao")
//    @ResponseBody
//    public Map<Object, Object> idcheck(@RequestBody String userid) {
//        
//    	int	count = 0;
//        Map<Object, Object> map = new HashMap<Object, Object>();
// 
//        count = boardService.idCheck(CustomDto);
//        map.put("cnt", count);
// 
//        return map;
//        
//        
//    }
    
    //자유게시판 이동
	@GetMapping("/b_freetalk")
	public String letsGoFreeTalk(){
		
		return "/board/b_freetalk";
	}
    
    @GetMapping("/board/new")
    public void new_board() {
    	System.out.println("Create board Page");
    }
    
    @PostMapping("/board/new")
	public String createBoard(@ModelAttribute BoardDto boardDto, HttpSession session) {
		System.out.println(boardDto);
		boardDto.setUserId((String) session.getAttribute("id"));
		boardService.createBoard(boardDto);
		return "redirect:/board/b_freetalk";
	}
//    @GetMapping("/login")
//    public void login(Model model, HttpSession session) {
//    	System.out.println("login");
//    	session.setAttribute("id", "mosang");
//    }
    
    @GetMapping("/board/detail/{boardnum}")
	public ModelAndView detail(@PathVariable int boardnum, Model model, HttpSession session) {
		System.out.println(boardnum);
		ModelAndView mv = new ModelAndView("/board/detail");
		BoardDto board = boardService.getBoardData(boardnum);
		mv.addObject("board", board);
		System.out.println(board);
		model.addAttribute("sess_id", (String)session.getAttribute("id"));
		return mv;
	}
}
