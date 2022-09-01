package kr.co.dong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.internal.org.jline.utils.Log;
import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardReply;
import kr.co.dong.board.BoardService;



@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	
	
	@Autowired
	BoardService service;
	
//	로그인 폼으로 가는 매핑 board/login -> login(.jsp)
	@GetMapping(value="board/login")
	public String login() {
		
		return "login";
	}
	
//	로그인 처리하기 (DAO)  : 성공하면 redirect:/ (또는 home.jsp)
//	                           세션부여함.
	@PostMapping(value="board/login")
	public String login(@RequestParam Map<String,Object> map,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(map);
		// 서비스 호출
		Map user = service.login(map);
		
		if(user == null) {  // 로그인 실패
			
			return "redirect:login";
		}else {   // 로그인 성공
			// 세션 부여
			session.setAttribute("user", user);
			return "redirect:/";
		}		
	}
	
	@GetMapping(value="board/logout")
	public String logout() {
		
		return "logout";
	}
	
	@PostMapping(value="board/logout1")
	public String logout(HttpSession session) throws Exception {
		logger.info("로그@PostMapping(value=\"board/logout\")");
		
		session.invalidate();
		logger.info("로그아웃 성공======================================");
		return "redirect:/";
		//return "redirect:login";
		
	}
	
	
	
	@RequestMapping(value="board/list", method = RequestMethod.GET)
	public ModelAndView list() throws Exception {
		logger.info("=========list==========");
		ModelAndView mav = new ModelAndView();
		
		List<BoardDTO> list = service.list();
		mav.addObject("list", list);
		mav.setViewName("list");
		return mav;
	}
	
	@GetMapping(value="board/detail")
	public String detail(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardDTO board = service.getDetail(bno);
		model.addAttribute("board", board);
		
		List<BoardReply> list = service.getDetail1(bno);
		model.addAttribute("list", list);
		
		return "detail";

	}

	
//	글쓰기폼
	@GetMapping(value="board/register")
	public String register() {
		
		return "register";
	}
//	글쓰기 저장
	@RequestMapping(value="board/register", method = RequestMethod.POST)
	public String register(BoardDTO boardDTO, HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("내용 : " + boardDTO);
		
		int r = service.register(boardDTO);
		
		return "redirect:list";
	}
	
	
//	글 수정 폼(기존데이터 전송- 글읽기)
	@RequestMapping(value="board/update", method = RequestMethod.GET)
	public String update(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardDTO board = service.getDetail(bno);
		model.addAttribute("board", board);		
		return "update";
	}	
//	글 수정 저장
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rttr,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = service.update(boardDTO);
		// 수정에 성공하면 목록보기로 이동
		if (r > 0) {
			rttr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
			return "redirect:list";
		}
		// 수정에 실패하면 수정보기 화면으로 이동
		return "redirect:update?bno=" + boardDTO.getBno();
	}
	
	@GetMapping(value="board/delete")
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		int r = service.delete(bno);
		
		if(r > 0) {
			rttr.addFlashAttribute("msg","글삭제에 성공하였습니다.");
			return "redirect:list";
		}
		return "redirect:detail?bno=" + bno;
	}
	
   @GetMapping(value="board/reply")
   public String reply() {
      return "reply";
   }
   
   @PostMapping(value="board/reply")
   public String reply(BoardReply boardReply) throws Exception {
      int r = service.reply(boardReply);
      if(r>0) {
         return "redirect:detail?bno=" + boardReply.getBno();
      }
      return "reply";
   }
   
   // 댓글 수정폼
   @GetMapping(value="board/replyupdate")
   public ModelAndView replyupdate(@RequestParam("reno") int reno) throws Exception {
	   logger.info("댓글 수정폼으로 가기");
	   ModelAndView mav =  new ModelAndView();
	   BoardReply boardReply =  service.detailreply(reno);
	   mav.addObject("boardReply", boardReply);
	   mav.setViewName("replyupdate");
	   return mav;
   }
   
   // 댓글 수정후 리스트로 돌아가기
   @PostMapping(value="board/replyupdate")
   public String replyupdate(BoardReply boardReply) throws Exception {
	  logger.info("댓글 수정후 리스트로 돌아가기");
      int r = service.replyupdate(boardReply);
      if(r>0) {
         return "redirect:detail?bno=" + boardReply.getBno();
      }
      return "replyupdate";
   }
   
   //ajax 매핑과 메소드를 구현
   // json처리를 위한 라이브러리가 필요함 => jackson-databind, jackson-core
   @ResponseBody
   @RequestMapping(value="board/test", method = RequestMethod.POST)
   public Map<String, Object> test(@RequestParam("msg") String msg) throws Exception {
       logger.info("msg : " + msg);
       
       Map<String, Object> result = new HashMap<String, Object>();
       result.put("status", "OK");
       return result;
   }
   
   //ajax 댓글에 대한 매핑 메소드 구현
   @ResponseBody
   @RequestMapping(value = "board/replylist" , method = RequestMethod.POST)
   public List<BoardReply> replylist(@RequestParam("bno") int bno) throws Exception{
		return service.getDetail1(bno);  
   }
   //ajax 댓글 쓰기
   @ResponseBody
   @RequestMapping(value = "board/reply2" , method = RequestMethod.POST)
   public int reply2(BoardReply boardReply) throws Exception{
	   return service.reply(boardReply);  
   }
   
   //ajax 댓글 수정
   @ResponseBody
   @RequestMapping(value = "board/replyupdate2" , method = RequestMethod.POST)
   public int replyupdate2(BoardReply boardReply) throws Exception{
	   return service.replyupdate(boardReply);  
   }
   
   //ajax 댓글 수정
   @ResponseBody
   @RequestMapping(value = "board/replydelete2" , method = RequestMethod.POST)
   public int replydelete2(@RequestParam("reno") int reno) throws Exception{
	   return service.replyDelete(reno);  
   }
   	
	
}






