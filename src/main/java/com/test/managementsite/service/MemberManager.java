package com.test.managementsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.mapper.member.InsertMember;
import com.test.managementsite.mapper.member.SelectMemberByName;

import java.util.List;

@Service("memberManager")
public class MemberManager implements IMemberManager {
	
	private final InsertMember insertMemberMapper;
	private final SelectMemberByName selectMemberByNameMapper;

	@Autowired
	public MemberManager(
			InsertMember insertMemberMapper, 
			SelectMemberByName selectMemberByNameMapper) {
		this.insertMemberMapper = insertMemberMapper;
		this.selectMemberByNameMapper = selectMemberByNameMapper;
	}

	@Override
	public void insertMember(MemberForm memberForm) {
		insertMemberMapper.insertMember(memberForm);
	}

	@Override
	public List<Member> selectMember(String name) {
		return selectMemberByNameMapper.selectMemberByName(name);
	}

	@Override
	public List<Member> selectMember(String name, String Age) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
