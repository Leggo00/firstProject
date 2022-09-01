/*
 * 1. 요청한 정보를 매핑
 * 2. 해당서비스 호출
 * 3. 결과값을 모델에 저장후 .view에 리턴
 * 
 * controller 서비스 호출 
 */

package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	@Inject
	private EmpService service;  //주입(new생성)
	
	//@RequestMapping => @GetMapping => @PostMapping 세분화해서 쓸수있음.
	@RequestMapping(value="/empcount")
	public String empCount(Model model) throws Exception {
		logger.info("전체사원조회");
//		서비스 호출하여 결과값 저장.
		
		int cnt = service.empCount(); 
		model.addAttribute("cnt", cnt);
		return "home";		
	}
	
	@RequestMapping(value="listAll")
	public ModelAndView listAll() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = service.listAll();
		mav.addObject("list", list);
		mav.setViewName("listall");
		return mav;
	}
	
	//사원추가 폼으로 이동.
	@RequestMapping(value="addEmp", method = RequestMethod.GET)
	public ModelAndView addEmp() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addEmp");
		return mav;
	}
	
	//사원추가 폼으로 이동.
	@RequestMapping(value="addEmp", method = RequestMethod.POST)
	public String addEmpDao(EmpVO empVo) throws Exception {
		ModelAndView mav = new ModelAndView();
		service.insert(empVo);
		
		return "redirect:listAll";
	}


}






