package com.test.managementsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.data.UpdateMemberForm;
import com.test.managementsite.mapper.member.UpdateMember;
import com.test.managementsite.mapper.member.InsertMember;
import com.test.managementsite.mapper.member.SelectMember;
import com.test.managementsite.mapper.member.SelectMemberByName;
import com.test.managementsite.mapper.member.SelectMemberByNameAge;

import lombok.RequiredArgsConstructor;

@Service("memberManager")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemberManager implements IMemberManager {
	
	private final InsertMember insertMemberMapper;
	private final UpdateMember updateMemberMapper;
	private final SelectMember selectMemberMapper;
	private final SelectMemberByName selectMemberByNameMapper;
	private final SelectMemberByNameAge selectMemberByNameAgeMapper;

	@Override
	public void insertMember(MemberForm memberForm) {
		insertMemberMapper.insertMember(memberForm);
	}
	
	@Override
	public void updateMember(UpdateMemberForm updateMemberForm) {
		updateMemberMapper.updateMember(updateMemberForm);
	}
	
	@Override
	public List<Member> selectMember(String name) {
		return selectMemberMapper.selectMember(name);
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
