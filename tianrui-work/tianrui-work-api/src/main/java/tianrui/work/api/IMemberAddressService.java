package tianrui.work.api;

import tianrui.work.req.address.AddressFindReq;
import tianrui.work.req.address.AddressSaveReq;
import tianrui.work.resp.address.AddressResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;

public interface IMemberAddressService {

	public Result save(AddressSaveReq req) throws Exception;
	
	public Result delete(String id)throws Exception;
	
	public PageTool<AddressResp> select(AddressFindReq req)throws Exception;
}
