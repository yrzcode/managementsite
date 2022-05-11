package com.test.managementsite.service;

import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;

public interface IMemberManager {

	public void insertMember(MemberForm memberForm);
	public Member selectMember(String name);
	public Member selectMember(String name, String Age);

	
	//public void deleteMember();
	//public void changeMember();

}
