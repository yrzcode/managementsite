package com.test.managementsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.mapper.member.InsertMember;
import com.test.managementsite.mapper.member.SelectMemberName;

@Service("memberManager")
public class MemberManager implements IMemberManager {
	
	private final InsertMember insertMemberMapper;
	private final SelectMemberName selectMemberNameMapper;

	@Autowired
	public MemberManager(
			InsertMember insertMemberMapper, 
			SelectMemberName selectMemberNameMapper) {
		this.insertMemberMapper = insertMemberMapper;
		this.selectMemberNameMapper = selectMemberNameMapper;
	}

	@Override
	public void insertMember(MemberForm memberForm) {
		insertMemberMapper.insertMember(memberForm);
	}

	@Override
	public Member selectMember(String name) {
		selectMemberNameMapper.selectMemberName(name);
		return null;
	}

	@Override
	public Member selectMember(String name, String Age) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
