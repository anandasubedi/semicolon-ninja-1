package com.semicolon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semicolon.domain.Member;
import com.semicolon.domain.Movie;
import com.semicolon.domain.Role;
import com.semicolon.repository.MemberRepository;
import com.semicolon.repository.MovieRepository;
import com.semicolon.service.MemberService;
import com.semicolon.service.MovieService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Override
	public List<Member> getAllDirectors() {
		return memberRepository.findMemberByRole(Role.DIRECTOR);
	}

	@Override
	public List<Member> getAllProducers() {
		return memberRepository.findMemberByRole(Role.PRODUCER);
	}
	
	@Override
	public Member addMember(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public List<Member> getAllStars() {
		return memberRepository.findMemberByRole(Role.STARS);
	}

	@Override
	public Member getMemberById(Long id) {
		
		return memberRepository.findOne(id);
	}

	@Override
	public List<Member> getAllMembers() {
		return (List<Member>) memberRepository.findAll();
	}

}
