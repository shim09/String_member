package com.icia.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	public int insert (MemberDTO member) {
		System.out.println("RES : " + member);
		return sql.insert("Member.insert", member);
	}

	public MemberDTO login(MemberDTO check) {
		return sql.selectOne("Member.login", check);
	}
	
	public List<MemberDTO> findAll(){
		return sql.selectList("Member.findAll");
	}
	
	public MemberDTO findById(long m_number) {
		return sql.selectOne("Member.findById", m_number);
	}

	public void delete(long m_number) {
		sql.delete("Member.delete", m_number);
		
	}

	public void update(MemberDTO member) {
		sql.update("Member.update", member);
		
	}

	public String idDuplicate(String m_id) {
		return sql.selectOne("Member.idDuplicate", m_id);
	}
}
