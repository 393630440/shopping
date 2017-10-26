package com.tianrui.quart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tianrui.work.api.ICashBackService;

/** ϵͳ��ʱ����*/
@Component
public class SystemQuart {
	
	@Autowired
	ICashBackService cashBackService;
	
	@Scheduled(cron="0/5 * * * * ? ")//û��5��ִ��
	public void quartTest() throws Exception{
		System.out.println("��ʱ����ʼ������");
		cashBackService.cashQuart();
	}
}
