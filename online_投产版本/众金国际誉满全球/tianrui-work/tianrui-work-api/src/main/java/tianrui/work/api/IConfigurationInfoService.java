package tianrui.work.api;

import java.util.List;

import tianrui.work.req.configuration.ConfigurationInfoReq;
import tianrui.work.resp.configuration.ConfigurationInfoResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IConfigurationInfoService {

	Result addConfigurationInfo(ConfigurationInfoReq req) throws Exception;

	Result editConfigurationInfo(ConfigurationInfoReq req) throws Exception;

	ConfigurationInfoResp queryConfigurationInfoByOne(String paramkey) throws Exception;

	PageTool<ConfigurationInfoResp> queryConfigurationInfoByList(ConfigurationInfoReq req) throws Exception;

	List<ConfigurationInfoResp> getConfigurationInfoList(ConfigurationInfoReq req) throws Exception;

}
