package kr.co.dong;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject   //홈서비스 링크 
	// spring전용으로 @Autowired 이것도 사용할수있음
	//HomeService homeService = new HomeService();
	HomeService homservice;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "testpage", method = RequestMethod.GET)
	public String testpage (Model model) {
		model.addAttribute("msg", "스프링은 처음이지???");
		return "testpage";
    }
	
	@RequestMapping(value = "returnhome", method = RequestMethod.GET)
	public String returnhome (Model model) {
		return "home";
    }
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		//정보를 전송하는 model과 view페이지를 설정하는 클래스
		ModelAndView mav = new ModelAndView();
		
		String name = homservice.testM2();
		mav.addObject("name", "호로롤롤로로로롤로롤 : " + name);
		mav.setViewName("main"); //리턴주소
		return mav;
	}
	
}
