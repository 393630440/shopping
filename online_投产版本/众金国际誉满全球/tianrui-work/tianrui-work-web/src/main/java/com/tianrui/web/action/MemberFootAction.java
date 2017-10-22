package com.tianrui.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.action.session.SessionManage;

import tianrui.work.api.IMemberFootprintService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.req.foot.MemberFootprintFindReq;
import tianrui.work.resp.foot.MemberFootprintResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Controller
@RequestMapping("/wechat/shop/memberFoot")
public class MemberFootAction {

	@Autowired
	IMemberFootprintService memberFootprintService;
	
	@RequestMapping("page")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/shop/fllow/page");
		return view;
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Result find(MemberFootprintFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfo info = SessionManage.getSessionManage(request);
		req.setMemberId(info.getMemberId());
		PageTool<MemberFootprintResp> page = memberFootprintService.select(req);
		rs.setData(page);
		return rs;
	}
}
