package tianrui.work.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IWeChatPayService;
import tianrui.work.bean.WeChatPay;
import tianrui.work.comm.Constant;
import tianrui.work.mapper.java.WeChatPayMapper;
import tianrui.work.req.WeChatPayReq;
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
		save.setCreatetime(System.currentTimeMillis());
		weChatPayMapper.insert(save);
		return null;
	}

	@Override
	public Result select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
