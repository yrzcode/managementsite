package com.test.managementsite.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.managementsite.data.Member;

@Mapper
public interface SelectMember {
	public List<Member> selectMember(String name);
}
