package com.tianrui.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;
import com.tianrui.web.util.LoggerUtils;

import tianrui.work.api.ICashBackService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/cashback")
public class CashBackAction {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	ICashBackService cashBackService;

	/**  */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/index]");
		MemberInfo info = SessionManage.getSessionManage(request);
		String memberId = info.getMemberId();

		CashBackInfoReq cashBackInfo = new CashBackInfoReq();
		cashBackInfo.setMemberId(memberId);
		cashBackInfo.setPageNo(0);
		cashBackInfo.setPageSize(10);
		cashBackInfo.setPageSort("create_time desc");
		List<CashBackInfoResp> dataList = cashBackService.queryCashBackInfoList(cashBackInfo);

		String totalEarnings = cashBackService.getTotalEarnings(memberId);
		String todayEarnings = cashBackService.getTodayEarnings(memberId);

		ModelAndView view = new ModelAndView();
		view.addObject("balance", info.getBalance());// 账户余额
		view.addObject("totalEarnings", totalEarnings);// 累计收益
		view.addObject("todayEarnings", todayEarnings);// 今日收益
		view.addObject("dataList", dataList);// 列表信息
		view.setViewName("shop/cashback/cashback");
		return view;
	}

	/** 我的返现 */
	@RequestMapping("mycashback")
	public ModelAndView myCashBack(HttpServletRequest request) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/mycashback]");
		MemberInfo info = SessionManage.getSessionManage(request);

		CashBackReq cashBack = new CashBackReq();
		cashBack.setCashMember(info.getMemberId());
		cashBack.setPageNo(0);
		cashBack.setPageSize(10);
		cashBack.setPageSort("create_time desc");
		List<CashBackResp> dataList = cashBackService.queryCashBackList(cashBack);

		ModelAndView view = new ModelAndView();
		view.addObject("dataList", dataList);
		view.setViewName("shop/cashback/mycashback");
		return view;
	}

	/** 列表页面 */
	@RequestMapping("cashbacklist")
	public ModelAndView cashBackList(HttpServletRequest request, String cashBackId) throws Exception {
		LoggerUtils.info(log, "---------- [/wechat/shop/cashback/cashbacklist]");
		MemberInfo info = SessionManage.getSessionManage(request);

		CashBackInfoReq cashBackInfo = new CashBackInfoReq();
		cashBackInfo.setMemberId(info.getMemberId());
		cashBackInfo.setCashBackId(cashBackId);
		cashBackInfo.setPageNo(0);
		cashBackInfo.setPageSize(10);
		cashBackInfo.setPageSort("create_time desc");
		List<CashBackInfoResp> dataList = cashBackService.queryCashBackInfoList(cashBackInfo);

		ModelAndView view = new ModelAndView();
		view.addObject("cashBackId", cashBackId);
		view.addObject("dataList", dataList);
		view.setViewName("shop/cashback/cashbacklist");
		return view;
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
