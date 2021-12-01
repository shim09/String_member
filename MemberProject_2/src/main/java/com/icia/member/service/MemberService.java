package com.icia.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;

@Service

public class MemberService {
	
	@Autowired
	private MemberRepository mr;
	@Autowired
	private HttpSession session;
	
	public int insert(MemberDTO member) {
		System.out.println("MemberService.insert() 메서드 호출");
		System.out.println(member);
		int result = mr.insert(member);
		return result;
	}

	public String login(MemberDTO check) {
		MemberDTO loginMember = mr.login(check);
		if(loginMember != null) {
			// 로그인 성공
			session.setAttribute("loginId", check.getM_id());
			session.setAttribute("loginNumber", loginMember.getM_number());
			return "main";
		} else {
			// 로그인 실패
			return "login";
		}
	}
	
	public List<MemberDTO> findAll(){
		List<MemberDTO> mList = mr.findAll();
		return mList;
	}

	public MemberDTO findById(long m_number) {
		MemberDTO member = mr.findById(m_number);
		return member;
	}

	public void delete(long m_number) {
		mr.delete(m_number);
		
	}
	
	public void update(MemberDTO member) {
		mr.update(member);

}

	public String idDuplicate(String m_id) {
		String result = mr.idDuplicate(m_id);
		if(result == null)
			return "ok";
		else
			return "no";
	}
	
}
