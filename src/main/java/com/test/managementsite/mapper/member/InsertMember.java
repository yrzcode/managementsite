package com.test.managementsite.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.test.managementsite.data.MemberForm;

@Mapper
public interface InsertMember {
	public void insertMember(MemberForm memberForm);
}
