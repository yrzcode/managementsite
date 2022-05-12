package com.test.managementsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.mapper.member.InsertMember;
import com.test.managementsite.mapper.member.SelectMemberByName;
import com.test.managementsite.mapper.member.SelectMemberByNameAge;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service("memberManager")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemberManager implements IMemberManager {
	
	private final InsertMember insertMemberMapper;
	private final SelectMemberByName selectMemberByNameMapper;
	private final SelectMemberByNameAge selectMemberByNameAgeMapper;

	@Override
	public void insertMember(MemberForm memberForm) {
		insertMemberMapper.insertMember(memberForm);
	}

	@Override
	public List<Member> selectMember(String name, String sex) {
		return selectMemberByNameMapper.selectMemberByName(name, sex);
	}

	@Override
	public List<Member> selectMember(String name, String sex,  String age) {
		return selectMemberByNameAgeMapper.selectMemberByNameAge(name, sex, age);
	}
	
}
