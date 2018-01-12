package com.tianrui.admin.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.web.smvc.AutherWeb;

import tianrui.work.api.ICashBackService;
import tianrui.work.api.IMemberGainService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.api.IMemberReleteService;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.req.cash.MemberCashBackReq;
import tianrui.work.req.gain.MemberGainFindReq;
import tianrui.work.req.member.MemberInfoFindReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.req.member.MemberInfoSaveReq;
import tianrui.work.req.related.MemberRelatedReq;
import tianrui.work.resp.gain.MemberGainResp;
import tianrui.work.resp.member.MemberInfoResp;
import tianrui.work.resp.related.MemberRelatedResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
@Controller
@RequestMapping("/admin/shop/member")
public class MemberInfoAction {

	@Autowired
	IMemberInfoService memberInfoService;
	@Autowired
	IMemberGainService memberGainService;
	@Autowired
	IMemberReleteService memberReleteService;
	@Autowired
	ICashBackService cashBackService;
	
	@RequestMapping("memberInfo")
	@AutherWeb(typeString = "admin")
	public ModelAndView memberInfo(String id) throws Exception{
		MemberRelatedReq req = new MemberRelatedReq();
		req.setMember(id);
		//��ѯ�û�����
		PageTool<MemberRelatedResp> fm = memberReleteService.select(req);
		req.setMember("");
		req.setMemberFather(id);
		//��ѯ�û��Ӽ�
		PageTool<MemberRelatedResp> m = memberReleteService.select(req);
		ModelAndView view = new ModelAndView();
		view.addObject("c_member", m.getList());
		view.addObject("f_member", fm.getList());
		if(fm.getList().size()!=0){
			view.addObject("fathur",memberInfoService.selectByOpenid(fm.getList().get(0).getMemberFather()).getData());
		}
		view.addObject("member", memberInfoService.selectByOpenid(id).getData());
		view.setViewName("/admin/member/member_info");
		return view;
	}
	
	@RequestMapping("page")
	@AutherWeb(typeString = "admin")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/member/page");
		return view;
	}
	@RequestMapping("saveHbaoPage")
	@AutherWeb(typeString = "admin")
	public ModelAndView saveHbaoPage() throws Exception{
		ModelAndView view = new ModelAndView();
		MemberInfoFindReq req = new MemberInfoFindReq();
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		view.addObject("mlist", page.getList());
		view.setViewName("/admin/member/save_hbao");
		return view;
	}
	
	@RequestMapping("uptMemberRank")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result uptMemberRank(String id,String rank,Double rankMoney) throws Exception{
		Result rs = Result.getSuccessful();
		MemberInfoSaveReq req = new MemberInfoSaveReq();
		req.setMemberId(id);
		req.setMemberRank(rank);
		if(rankMoney != null){
			MemberCashBackReq mem = new MemberCashBackReq();
			mem.setId(id);
			mem.setMoney(rankMoney);
			mem.setRank(rank);
			cashBackService.memberCashBack(mem);
			req.setRankMoney(rankMoney);
		}
		memberInfoService.uptMemberInfo(req);
		return rs;
	}
	
	@RequestMapping("select")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result select(MemberInfoFindReq req) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<MemberInfoResp> page = memberInfoService.select(req);
		rs.setData(page);
		return rs;
	}
	
	@RequestMapping("findMemberID")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result findMemberID(String id) throws Exception{
		Result rs = memberInfoService.selectByOpenid(id);
		return rs;
	}
	@RequestMapping("saveHbao")
	@AutherWeb(typeString = "admin")
	@ResponseBody
	public Result saveHbao(MemberInfoHBaoReq req) throws Exception{
		Result rs = Result.getSuccessful();
		rs = memberInfoService.saveHbao(req);
		return rs;
	}
	
	@RequestMapping("find")
	@ResponseBody
	public Result find(MemberGainFindReq req,HttpServletRequest request) throws Exception{
		Result rs = Result.getSuccessful();
		PageTool<MemberGainResp> page = memberGainService.select(req);
		rs.setData(page);
		return rs;
	}
	@RequestMapping("gainPage")
	public ModelAndView gainPage(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/member/hbaoInfo");
		return view;
	}
}
