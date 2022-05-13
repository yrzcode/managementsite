package com.test.managementsite.service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.data.UpdateMemberForm;

import java.util.List;

public interface IMemberManager {

	public void insertMember(MemberForm memberForm);
	public void updateMember(UpdateMemberForm updateMemberForm);
	
	public List<Member> selectMember(String name);
	public List<Member> selectMember(String name, String sex);
	public List<Member> selectMember(String name, String sex, String Age);

	//public void deleteMember();

}
