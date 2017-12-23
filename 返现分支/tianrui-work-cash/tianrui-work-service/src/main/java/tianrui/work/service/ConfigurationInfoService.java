package tianrui.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IConfigurationInfoService;
import tianrui.work.bean.ConfigurationInfo;
import tianrui.work.mapper.java.ConfigurationInfoMapper;
import tianrui.work.req.configuration.ConfigurationInfoReq;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

@Service
public class ConfigurationInfoService implements IConfigurationInfoService {

	@Autowired
	ConfigurationInfoMapper configurationInfoMapper;

	@Override
	public Result addConfigurationInfo(ConfigurationInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		ConfigurationInfo record = new ConfigurationInfo();
		PropertyUtils.copyProperties(record, req);
		configurationInfoMapper.insertSelective(record);
		return rs;
	}

	@Override
	public Result editConfigurationInfo(ConfigurationInfoReq req) throws Exception {
		Result rs = Result.getSuccessful();
		ConfigurationInfo record = new ConfigurationInfo();
		PropertyUtils.copyProperties(record, req);
		configurationInfoMapper.updateByPrimaryKeySelective(record);
		return rs;
	}

	@Override
	public ConfigurationInfoResp queryConfigurationInfoByOne(String paramkey) throws Exception {
		ConfigurationInfo record = configurationInfoMapper.selectByPrimaryKey(paramkey);
		ConfigurationInfoResp resp = new ConfigurationInfoResp();
		PropertyUtils.copyProperties(resp, record);
		return resp;
	}

	@Override
	public PageTool<ConfigurationInfoResp> queryConfigurationInfoByList(ConfigurationInfoReq req) throws Exception {
		PageTool<ConfigurationInfoResp> page = new PageTool<ConfigurationInfoResp>();
		ConfigurationInfo find = new ConfigurationInfo();
		if (req.getPageNo() != null) {
			find.setPageNo(req.getPageSize() * req.getPageNo());
			find.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}

		find.setFlag(req.getFlag());

		List<ConfigurationInfo> list = configurationInfoMapper.selectByConfigurationInfo(find);
		long a = configurationInfoMapper.selectBycount(find);

		List<ConfigurationInfoResp> resp = new ArrayList<ConfigurationInfoResp>();
		for (ConfigurationInfo bean : list) {
			ConfigurationInfoResp sp = new ConfigurationInfoResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		page.setList(resp);
		page.setTotal(a);

		return page;
	}

	@Override
	public List<ConfigurationInfoResp> getConfigurationInfoList(ConfigurationInfoReq req) throws Exception {
		ConfigurationInfo record = new ConfigurationInfo();
		PropertyUtils.copyProperties(record, req);
		List<ConfigurationInfo> list = configurationInfoMapper.selectList(record);

		List<ConfigurationInfoResp> resp = new ArrayList<ConfigurationInfoResp>();
		for (ConfigurationInfo bean : list) {
			ConfigurationInfoResp sp = new ConfigurationInfoResp();
			PropertyUtils.copyProperties(sp, bean);
			resp.add(sp);
		}

		return resp;
	}

	@Override
	public Result selectMembreRankConf(String membreRank) throws Exception {
		Result rs = Result.getSuccessful();
		ConfigurationInfo info = configurationInfoMapper.selectByPrimaryKey(memberRank(membreRank));
		if(info != null){
			rs.setData(info);
		}else{
			rs.setCode("1");
			rs.setError("未查到数据");
		}
		return rs;
		
	}
	
	private String memberRank(String rank){
		String rs = "";
		switch (rank) {
		case "A":
			rs = "CASH_BACK_A";
			break;
		case "B":
			rs = "CASH_BACK_B";	
			break;
		case "C":
			rs = "CASH_BACK_C";
			break;
		case "S":
			rs = "CASH_BACK_S";
			break;
		default:
			break;
		}
		return rs;
	}

}
