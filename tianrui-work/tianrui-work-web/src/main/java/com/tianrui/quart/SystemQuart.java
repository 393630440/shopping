package com.tianrui.quart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tianrui.work.api.ICashBackService;

/** 系统定时任务*/
@Component
public class SystemQuart {
	
	@Autowired
	ICashBackService cashBackService;
	
	@Scheduled(cron="0/5 * * * * ? ")//没隔5秒执行
	public void quartTest() throws Exception{
		System.out.println("定时任务开始啦拉拉");
		cashBackService.cashQuart();
	}
}
