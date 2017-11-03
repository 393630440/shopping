package tianrui.work.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.ICashBackService;
import tianrui.work.api.IMemberInfoService;
import tianrui.work.bean.CashBack;
import tianrui.work.bean.CashBackInfo;
import tianrui.work.bean.ConfigurationInfo;
import tianrui.work.mapper.java.CashBackInfoMapper;
import tianrui.work.mapper.java.CashBackMapper;
import tianrui.work.mapper.java.ConfigurationInfoMapper;
import tianrui.work.req.cash.CashBackInfoReq;
import tianrui.work.req.cash.CashBackReq;
import tianrui.work.req.member.MemberInfoHBaoReq;
import tianrui.work.resp.cash.CashBackInfoResp;
import tianrui.work.resp.cash.CashBackResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class CashBackService implements ICashBackService {

	@Autowired
	CashBackMapper cashBackMapper;
	@Autowired
	CashBackInfoMapper cashBackInfoMapper;
	@Autowired
	ConfigurationInfoMapper configurationInfoMapper;
	@Autowired
	IMemberInfoService memberInfoService;
	
	@Override
	public Result addCashBack(CashBackReq req) throws Exception {
		Result rs = Result.getSuccessful();
		CashBack save = new CashBack();
		PropertyUtils.copyProperties(save, req);
		save.setId(UUIDUtil.getUUID());
		save.setCashAlre(0.00);// 已反金额
		save.setCashRatio(0.0001);// 配置
		save.setCreateTime(System.currentTimeMillis());
		cashBackMapper.insertSelective(save);
		return rs;
	}

	@Override
	public PageTool<CashBackResp> queryCashBack(CashBackReq req) throws Exception {
		PageTool<CashBackResp> page = new PageTool<CashBackResp>();
		CashBack query = new CashBack();
		if (req.getPageNo() != null) {
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
			query.setPageNo(req.getPageNo() * req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		query.setCashMember(req.getCashMember());
		query.setCashMemberName(req.getCashMemberName());
		query.setCashType(req.getCashType());
		query.setCashRemark(req.getCashRemark());
		List<CashBack> list = cashBackMapper.selectByCondition(query);
		long a = cashBackMapper.selectByCount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}

	protected List<CashBackResp> copyProperties2(List<CashBack> list) throws Exception {
		List<CashBackResp> resp = new ArrayList<CashBackResp>();
		for (CashBack bk : list) {
			CashBackResp sp = new CashBackResp();
			PropertyUtils.copyProperties(sp, bk);
			resp.add(sp);
		}
		return resp;
	}

	@Override
	public PageTool<CashBackInfoResp> queryCashBackInfo(CashBackInfoReq req) throws Exception {
		PageTool<CashBackInfoResp> page = new PageTool<CashBackInfoResp>();
		CashBackInfo query = new CashBackInfo();
		if (req.getPageNo() != null) {
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
			query.setPageNo(req.getPageNo() * req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		query.setCashBackId(req.getCashBackId());
		query.setMemberId(req.getMemberId());
		query.setMemberName(req.getMemberName());
		query.setCreateTimeBegin(req.getTimeBegin());
		query.setCreateTimeEnd(req.getTimeEnd());
		List<CashBackInfo> list = cashBackInfoMapper.selectByCondition(query);
		long a = cashBackInfoMapper.selectByCount(query);
		page.setList(copyPropertieInfo(list));
		page.setTotal(a);
		return page;
	}

	protected List<CashBackInfoResp> copyPropertieInfo(List<CashBackInfo> list) throws Exception {
		List<CashBackInfoResp> resp = new ArrayList<CashBackInfoResp>();
		for (CashBackInfo info : list) {
			CashBackInfoResp sp = new CashBackInfoResp();
			PropertyUtils.copyProperties(sp, info);
			resp.add(sp);
		}
		return resp;
	}

	@Override
	public List<CashBackResp> queryCashBackList(CashBackReq req) throws Exception {
		CashBack query = new CashBack();
		if (req.getPageNo() != null) {
			query.setPageNo(req.getPageNo() * req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		if (req.getPageSort() != null)
			query.setPageSort(req.getPageSort());

		query.setCashMember(req.getCashMember());
		query.setCashMemberName(req.getCashMemberName());
		query.setCashType(req.getCashType());
		query.setCashRemark(req.getCashRemark());
		List<CashBack> list = cashBackMapper.selectByCondition(query);

		return copyProperties2(list);
	}

	@Override
	public List<CashBackInfoResp> queryCashBackInfoList(CashBackInfoReq req) throws Exception {
		CashBackInfo query = new CashBackInfo();
		if (req.getPageNo() != null) {
			query.setPageNo(req.getPageNo() * req.getPageSize());
			query.setPageSize(req.getPageSize());
		}
		if (req.getPageSort() != null)
			query.setPageSort(req.getPageSort());

		query.setCashBackId(req.getCashBackId());
		query.setMemberId(req.getMemberId());
		query.setMemberName(req.getMemberName());
		List<CashBackInfo> list = cashBackInfoMapper.selectByCondition(query);

		return copyPropertieInfo(list);
	}

	@Override
	public String getTotalEarnings(String memberId) throws Exception {
		CashBack record = new CashBack();
		record.setCashMember(memberId);
		String todayEarnings = cashBackMapper.getTotalEarnings(record);
		return todayEarnings;
	}

	@Override
	public String getTodayEarnings(String memberId) throws Exception {
		long createTimeBegin = getMillisecond(1);
		long createTimeEnd = getMillisecond(2);

		CashBackInfo record = new CashBackInfo();
		record.setMemberId(memberId);
		record.setCreateTimeBegin(createTimeBegin);
		record.setCreateTimeEnd(createTimeEnd);
		String todayEarnings = cashBackInfoMapper.getTodayEarnings(record);
		return todayEarnings;
	}

	public static long getMillisecond(int mark) {
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DAY_OF_MONTH);

		if (mark == 1)
			calendar.set(y, m, d, 0, 0, 0);
		else if (mark == 2)
			calendar.set(y, m, d, 23, 59, 59);

		calendar.set(Calendar.MILLISECOND, 0);
		long millisecond = calendar.getTime().getTime();

		return millisecond;
	}

	@Override
	public void cashQuart() throws Exception {
		// 获取系统设置返现比例
		ConfigurationInfo rate = configurationInfoMapper.selectByPrimaryKey("SYSTEM_CASH_BACK_RATE");
		// 获取系统返现比例
		Double rateVal = Double.valueOf(rate.getParamvalue());
		if (rate.getFlag().equals("1")) {
			// 返现功能后台已开启
			CashBack query = new CashBack();
			query.setDesc1("1");// 1-返现中 2-返现成功
			List<CashBack> list = cashBackMapper.selectByCondition(query);
			for (CashBack back : list) {
				CashBack upt = new CashBack();
				upt.setId(back.getId());
				upt.setCashAlre(back.getCashAlre() + (back.getCashAmount() * rateVal));
				upt.setModifyTime(System.currentTimeMillis());
				if (upt.getCashAlre() >= back.getCashAmount()) {
					// 已反金额 大于返现金额 返现完成
					upt.setCashAlre(back.getCashAmount() - back.getCashAlre());
					upt.setDesc1("2");
				}
				CashBackInfo save = new CashBackInfo();
				save.setId(UUIDUtil.getUUID());
				save.setCashBackId(back.getId());
				save.setBackAmount(back.getCashAmount());
				save.setBackMoney(upt.getCashAlre() - back.getCashAlre());// 本次返现金额
				save.setBackRatio(rateVal);
				save.setBackRemark("系统定时返现");
				save.setMemberId(back.getCashMember());
				save.setMemberName(back.getCashMemberName());
				save.setDesc1(back.getCashType());
				save.setCreateTime(System.currentTimeMillis());
				cashBackInfoMapper.insertSelective(save);
				cashBackMapper.updateByPrimaryKeySelective(upt);
				MemberInfoHBaoReq cback = new MemberInfoHBaoReq();
				cback.setMemberId(back.getCashMember());
				cback.setCashMoney(upt.getCashAlre() - back.getCashAlre());
				memberInfoService.cashBackUptMember(cback);
			}
		}
	}

}
