package com.test.managementsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.managementsite.data.MemberForm;
import com.test.managementsite.mapper.member.AddMember;

@Service("memberManager")
public class MemberManager implements IMemberManager {
	
	private final AddMember addMemberMapper;

	@Autowired
	public MemberManager(AddMember addMemberMapper) {
		this.addMemberMapper = addMemberMapper;
	}

	@Override
	public void addMember(MemberForm memberForm) {
		addMemberMapper.addMember(memberForm);
	}
	
}
