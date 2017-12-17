package com.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.api.IMainTestService;
import com.work.bean.MemberRelated;
import com.work.mapper.java.MemberRelatedMapper;

@Service
public class MainTestService implements IMainTestService{

	@Autowired
	MemberRelatedMapper memberRelatedMapper;
	
	@Override
	public String mainTest(String id) {
		// TODO Auto-generated method stub
		MemberRelated bean = memberRelatedMapper.selectByPrimaryKey(id);
		return bean.toString();
	}

}
