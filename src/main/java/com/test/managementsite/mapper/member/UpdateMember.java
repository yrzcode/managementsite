package com.test.managementsite.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.test.managementsite.data.MemberForm;
import com.test.managementsite.data.UpdateMemberForm;

@Mapper
public interface UpdateMember {
	public void updateMember(UpdateMemberForm UpdateMemberForm);
}
