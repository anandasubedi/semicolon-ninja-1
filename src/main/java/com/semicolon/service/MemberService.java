package com.semicolon.service;

import java.util.List;

import com.semicolon.domain.Member;

public interface MemberService {

	public Member addMember(Member member);
	public List<Member> getAllDirectors();
	List<Member> getAllProducers();
	public List<Member> getAllStars();
	public Member getMemberById(Long id);
	public List<Member> getAllMembers();
}
