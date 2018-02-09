package com.tianrui.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.ICashBackService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/cashback")
public class CashBackAction {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	ICashBackService cashBackService;
	@Autowired
	IMemberInfoService memberInfoService;
	
	/**  */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/index]");
		MemberInfo info = SessionManage.getSessionManage(request);
		Result rs = memberInfoService.selectByOpenid(info.getMemberId());
		
		MemberInfo upt = (MemberInfo) rs.getData();
		SessionManage.uptSessionManage(request,upt);
		String memberId = info.getMemberId();
//		String totalEarnings = cashBackService.getTotalEarnings(memberId);
		String todayEarnings = cashBackService.getTodayEarnings(memberId);
		if(StringUtils.isBlank(todayEarnings)){
			todayEarnings = "0.00";
		}
		ModelAndView view = new ModelAndView();
		view.addObject("info", upt);
//		view.addObject("balance", upt.getBalance());// 账户余额
//		view.addObject("totalEarnings", upt.getCashMoney());// 累计收益
//		view.addObject("redParkEarnings", upt.getRedPacket());//积分
		view.addObject("todayEarnings", todayEarnings);// 今日收益
		view.setViewName("shop/cashback/cashback");
		return view;
	}

	/** 我的补贴 */
	@RequestMapping("mycashback")
	public ModelAndView myCashBack(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/mycashback]");
		ModelAndView view = new ModelAndView();
		view.setViewName("shop/cashback/mycashback");
		return view;
	}

	/** 列表页面 */
	@RequestMapping("cashbacklist")
	public ModelAndView cashBackList(HttpServletRequest request, String cashBackId) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/cashbacklist]");
		ModelAndView view = new ModelAndView();
		view.addObject("cashBackId", cashBackId);
		view.setViewName("shop/cashback/cashbacklist");
		return view;
	}

	@RequestMapping("findList")
	@ResponseBody
	public Result findList(HttpServletRequest request,CashBackInfoReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
		String time = smp.format(new Date());
		if("0".equals(req.getType())){
			//当天
			req.setTimeBegin(smp.parse(time).getTime());
		}
		if("1".equals(req.getType())){
			//历史
			req.setTimeEnd(smp.parse(time).getTime());
		}
		PageTool<CashBackInfoResp> page = cashBackService.queryCashBackInfo(req);
		rs.setData(page);
		return rs;
	}
	@RequestMapping("queryBackList")
	@ResponseBody
	public Result queryBackList(HttpServletRequest request,CashBackReq req) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setCashMember(info.getMemberId());
		PageTool<CashBackResp> page = cashBackService.queryCashBack(req);
		rs.setData(page);
		return rs;
	}
	
	/** 查询列表数据 */
	@RequestMapping("querylist")
	@ResponseBody
	public Result queryList(HttpServletRequest request, String type, Integer pageNo, Integer pageSize)
			throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/querylist]");
		MemberInfo info = SessionManage.getSessionManage(request);
		Result rs = Result.getSuccessful();

		if (type.equals("0")) {
			CashBackReq cashBack = new CashBackReq();
			cashBack.setCashMember(info.getMemberId());
			cashBack.setPageNo(pageNo);
			cashBack.setPageSize(pageSize);
			cashBack.setPageSort("create_time desc");
			List<CashBackResp> dataList = cashBackService.queryCashBackList(cashBack);
			rs.setData(dataList);
		} else if (type.equals("1") || type.equals("2")) {
			CashBackInfoReq cashBackInfo = new CashBackInfoReq();
			cashBackInfo.setMemberId(info.getMemberId());
			cashBackInfo.setPageNo(pageNo);
			cashBackInfo.setPageSize(pageSize);
			cashBackInfo.setPageSort("create_time desc");

			if (type.equals("2")) {
				String cashBackId = request.getParameter("cashBackId");
				cashBackInfo.setCashBackId(cashBackId);
			}

			List<CashBackInfoResp> dataList = cashBackService.queryCashBackInfoList(cashBackInfo);
			rs.setData(dataList);
		} else {
			throw new Exception("999990");
		}

		return rs;
	}

}
