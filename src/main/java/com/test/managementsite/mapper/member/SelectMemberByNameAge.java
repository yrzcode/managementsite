package com.test.managementsite.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.test.managementsite.data.Member;

@Mapper
public interface SelectMemberByNameAge {
	public List<Member> selectMemberByNameAge(String name, String age) ;
}
