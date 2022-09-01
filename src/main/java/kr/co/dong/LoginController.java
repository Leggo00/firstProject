package kr.co.dong;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "login/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		logger.info("로그인폼입니다.");
		System.out.println("==========================================================");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("test", "test Model");
		mav.setViewName("login/loginForm");
		return mav;
	}
	
	//1. request 파라미터 전달 받는 방법 : HttpServletRequest
	@RequestMapping(value = "login/login", method = RequestMethod.POST)
	public ModelAndView loginResult(HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("utf-8");
		logger.info("로그인확인폼1입니다.");
		System.out.println("==========================================================");
		
		ModelAndView mav = new ModelAndView();
		
		String u_id = req.getParameter("userId");
		String u_name = req.getParameter("userName");
		
		mav.addObject("userId", u_id);
		mav.addObject("userName", u_name);
		//db호출 여기서하면댐
		
		mav.setViewName("login/result");
		return mav;
		
	}
	
	//2. request 파라미터 전달 받는 방법 : @RequestParam 로 처리하는법
	@RequestMapping(value = "login/login2", method = RequestMethod.POST)
	public ModelAndView loginResult2(@RequestParam("userId") String userId,
									@RequestParam("userName") String userName,
			                         HttpServletRequest req) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		logger.info("로그인확인폼2입니다.");
		System.out.println("==========================================================");

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("userId", userId);
		mav.addObject("userName", userName);
		//db호출 여기서하면댐
		
		mav.setViewName("login/result");
		return mav;
		
	}
	
	//3. request 파라미터 전달 받는법 : Map<String, Object> map
	@RequestMapping(value = "login/login3", method = RequestMethod.POST)
	public ModelAndView loginResult3(@RequestParam Map<String,String> info) {
		
		logger.info("로그인확인폼3333입니다.");
		System.out.println("==========================================================");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("info", info);
		//db호출 여기서하면댐
		
		mav.setViewName("login/result");
		return mav;
	}
	
	//4. request 파라미터 전달 받는법 : BeanClass
	
	@RequestMapping(value = "login/login4" , method = RequestMethod.POST)
	public ModelAndView loginResult4(@ModelAttribute("info") UserVO uservo) {
//		public ModelAndView loginResult4(UserVO uservo) {  //위와같음.
		logger.info("로그인확인폼4입니다.");
		System.out.println("==========================================================");
		ModelAndView mav = new ModelAndView();
		
//		mav.addObject("info", uservo);  //써도되고 필요없음
		mav.setViewName("login/result");
		return mav;
	}
		

}
