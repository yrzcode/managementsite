package com.test.managementsite.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.test.managementsite.data.MemberForm;

@Mapper
public interface AddMember {
	public void addMember(MemberForm memberForm);
}
