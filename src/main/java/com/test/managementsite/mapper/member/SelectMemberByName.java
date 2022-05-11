package com.test.managementsite.mapper.member;

import com.test.managementsite.data.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectMemberByName {
		public List<Member> selectMemberByName(String name) ;
}
