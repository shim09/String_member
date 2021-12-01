package com.icia.member.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService ms;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		return "insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute MemberDTO member) {
		
		System.out.println(member);
		int save = ms.insert(member);
		
		if(save > 0) {
			return "index";
		}else {
			
			return "insert";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO member) {
		String resultPage = ms.login(member);
		
		return resultPage;	
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return"index";
		
	}
	
	@RequestMapping(value="/findAll", method= RequestMethod.GET)
	public String findAll(Model model) {
		List<MemberDTO> mList = ms.findAll();
		model.addAttribute("mList",mList);
		return"findAll";
	}
	
	// 상세조회 처리
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String findById(@RequestParam("m_number") long m_number, Model model) {
		MemberDTO member = ms.findById(m_number);
		model.addAttribute("member", member);
		return "detail";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("m_number")long m_number, Model model) {
		ms.delete(m_number);
		return "redirect:/findAll";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(@RequestParam("m_number")long m_number, Model model) {
		
		MemberDTO member = ms.findById(m_number);
		model.addAttribute("member",member);
		
		return "update";
		
	}
	
	@RequestMapping (value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute MemberDTO member) {
		
		ms.update(member);
		return "redirect:/detail?m_number=" + (member.getM_number());
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/idDuplicate", method=RequestMethod.POST)
	public @ResponseBody String idDuplicate(@RequestParam("m_id") String m_id){
		System.out.println("MainController.idDuplicate(): " + m_id);
		String result = ms.idDuplicate(m_id);
//		System.out.println(result);
		return result; // "ok" or "no"
	}
	
	// ajax로 상세조회
	@RequestMapping(value="/detailAjax", method=RequestMethod.POST)
	public @ResponseBody MemberDTO detailAjax(@RequestParam("m_number")long m_number) {
		MemberDTO member = ms.findById(m_number);
		return member;
	}
	
	
	
}
