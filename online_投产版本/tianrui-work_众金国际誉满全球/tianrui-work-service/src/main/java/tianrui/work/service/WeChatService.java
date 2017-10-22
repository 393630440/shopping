package tianrui.work.service;


import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IWeChatPayService;
import tianrui.work.bean.WeChatPay;
import tianrui.work.comm.Constant;
import tianrui.work.mapper.java.WeChatPayMapper;
import tianrui.work.req.WeChatPayReq;
import tianrui.work.resp.WeChatPayResp;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class WeChatService implements IWeChatPayService{

	@Autowired
	WeChatPayMapper weChatPayMapper;
	
	@Override
	public Result save(WeChatPayReq req) throws Exception{
		// TODO Auto-generated method stub
		WeChatPay save = new WeChatPay();
		PropertyUtils.copyProperties(save, req);
		save.setMchid(Constant.WEIXIN_SHANGPU);
		save.setAppid(Constant.WEIXIN_APPID);
		save.setId(req.getOuttradeno());
		save.setPaynum(req.getPayNum());
		save.setPaystatus("0");
		save.setCreatetime(System.currentTimeMillis());
		weChatPayMapper.insert(save);
		return null;
	}

	@Override
	public WeChatPayResp select(String id) throws Exception {
		WeChatPayResp resp = new WeChatPayResp(); 
		WeChatPay pay = weChatPayMapper.selectByPrimaryKey(id);
		PropertyUtils.copyProperties(resp, pay);
		return resp;
	}

	@Override
	public void uptPayStatus(String id) {
		// TODO Auto-generated method stub
		WeChatPay upt = new WeChatPay();
		upt.setId(id);
		upt.setPaystatus("1");
		weChatPayMapper.updateByPrimaryKeySelective(upt);
	}

}
