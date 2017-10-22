package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.util.LoggerUtils;

@Controller
@RequestMapping("/wechat/shop/returncash")
public class ReturnCashAction {
	Logger log = Logger.getLogger(getClass());

	/** 返现列表 */
	@RequestMapping("returncashlist")
	public ModelAndView returnCashList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/returncash/returncashlist]");

		ModelAndView view = new ModelAndView();
		view.setViewName("shop/returncash/returncashlist");
		return view;
	}

	/** 我的返现 */
	@RequestMapping("myreturncash")
	public ModelAndView myReturnCash(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/returncash/myreturncash]");

		ModelAndView view = new ModelAndView();
		view.setViewName("shop/returncash/myreturncash");
		return view;
	}

	/** 返现明细-购买商品返现 */
	@RequestMapping("purchasereturncashlist")
	public ModelAndView purchaseReturnCashList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/returncash/purchasereturncashlist]");

		ModelAndView view = new ModelAndView();
		view.setViewName("shop/returncash/purchasereturncashlist");
		return view;
	}

	/** 返现明细-后台派送返现 */
	@RequestMapping("deliveryreturncashlist")
	public ModelAndView deliveryReturnCashList(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/returncash/deliveryreturncashlist]");

		ModelAndView view = new ModelAndView();
		view.setViewName("shop/returncash/deliveryreturncashlist");
		return view;
	}

}
