package com.test.managementsite.service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;

import java.util.List;

public interface IMemberManager {

	public void insertMember(MemberForm memberForm);
	public List<Member> selectMember(String name, String sex);
	public List<Member> selectMember(String name, String sex, String Age);

	
	//public void deleteMember();
	//public void changeMember();

}
