package com.test.managementsite.mapper.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelectMemberName {
		public void selectMemberName(String name) ;
}
