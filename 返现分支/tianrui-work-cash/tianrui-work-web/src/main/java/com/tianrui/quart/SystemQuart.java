package com.tianrui.quart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tianrui.work.api.ICashBackService;

/** 系统定时任务 */
@Component
public class SystemQuart {

	@Autowired
	ICashBackService cashBackService;

	/** 每天0点01执行定时*/
	@Scheduled(cron = "0 1 0 * * ?") 
	public void quartTest() throws Exception {
		System.out.println("---------定时任务开始啦啦啦-------");
		cashBackService.cashQuart();
		System.out.println("---------定时任务执行完毕---------");
	}

}
