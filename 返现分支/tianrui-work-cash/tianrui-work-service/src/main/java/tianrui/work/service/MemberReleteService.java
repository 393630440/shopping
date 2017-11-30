package tianrui.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMemberReleteService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.MemberRelated;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.MemberRelatedMapper;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberReleteService implements IMemberReleteService {

	@Autowired
	MemberRelatedMapper memberRelatedMapper;
	@Autowired
	MemberInfoMapper memberInfoMapper;
	
	@Override
	public Result saveMemberRelete(String fatherId, String memberId) {
		Result rs = Result.getSuccessful();
		MemberInfo m = memberInfoMapper.selectByPrimaryKey(memberId);
		MemberInfo f = memberInfoMapper.selectByPrimaryKey(fatherId);
		MemberRelated save = new MemberRelated();
		save.setId(UUIDUtil.getUUID());
		save.setCreatetime(System.currentTimeMillis());
		//子类
		save.setMember(memberId);
		save.setMemberImg(m.getWechatImg());
		save.setMemberName(m.getWechatName());
		//父类
		save.setMemberFather(fatherId);
		save.setFatherImg(f.getWechatImg());
		save.setFatherName(f.getWechatName());
		memberRelatedMapper.insertSelective(save);
		return rs;
	}

}
