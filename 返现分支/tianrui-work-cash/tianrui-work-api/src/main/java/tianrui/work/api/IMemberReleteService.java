package tianrui.work.api;

import tianrui.work.vo.Result;

public interface IMemberReleteService {

	/** 建立用户关系*/
	Result saveMemberRelete(String fatherId,String memberId);
}
