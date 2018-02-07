package tianrui.work.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import tianrui.work.api.IMemberReleteService;
import tianrui.work.bean.MemberInfo;
import tianrui.work.bean.MemberRelated;
import tianrui.work.mapper.java.MemberInfoMapper;
import tianrui.work.mapper.java.MemberRelatedMapper;
import tianrui.work.req.related.MemberRelatedReq;
import tianrui.work.resp.related.MemberRelatedResp;
import tianrui.work.vo.PageTool;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class MemberReleteService implements IMemberReleteService {

	@Autowired
	MemberRelatedMapper memberRelatedMapper;
	@Autowired
	MemberInfoMapper memberInfoMapper;

	@Override
	public PageTool<MemberRelatedResp> select(MemberRelatedReq req) throws Exception {
		PageTool<MemberRelatedResp> page = new PageTool<MemberRelatedResp>();
		MemberRelated query = new MemberRelated();
		if(req.getPageNo()!=null){
			query.setPageNo(req.getPageNo()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNo());
			page.setPageSize(req.getPageSize());
		}
		query.setMember(req.getMember());
		query.setMemberFather(req.getMemberFather());
		long a = memberRelatedMapper.selectByCount(query);
		page.setTotal(a);
		List<MemberRelated> list = memberRelatedMapper.selectByCoudition(query);
		page.setList(copyProperties2(list));
		return page;
	}
	private List<MemberRelatedResp> copyProperties2(List<MemberRelated> list)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<MemberRelatedResp> resp = new ArrayList<MemberRelatedResp>();
		for(MemberRelated rel : list){
			MemberRelatedResp sp = new MemberRelatedResp();
			PropertyUtils.copyProperties(sp, rel);
			resp.add(sp);
		}
		return resp;
	}
	@Override
	public Result saveMemberRelete(String fatherId, String memberId) {
		Result rs = Result.getSuccessful();
		if(!StringUtils.equals(memberId, fatherId)){
			MemberInfo f = memberInfoMapper.selectByPrimaryKey(fatherId);
			if(f != null){
				//删除用户原有关系
				deleteMemberRelete(memberId);
				MemberInfo m = memberInfoMapper.selectByPrimaryKey(memberId);
				
				MemberRelated save = new MemberRelated();
				save.setId(UUIDUtil.getUUID());
				save.setCreatetime(System.currentTimeMillis());
				//子类
				save.setMember(memberId);
				if(m!=null){
					save.setMemberImg(m.getWechatImg());
					save.setMemberName(m.getWechatName());
				}
				//父类
				save.setMemberFather(fatherId);
				save.setFatherImg(f.getWechatImg());
				save.setFatherName(f.getWechatName());
				memberRelatedMapper.insertSelective(save);
			}
		}
		return rs;
	}
	private void deleteMemberRelete(String memberId) {
		MemberRelated query = new MemberRelated();
		query.setMember(memberId);
		List<MemberRelated> list = memberRelatedMapper.selectByCoudition(query);
		for(MemberRelated bean : list){
			memberRelatedMapper.deleteByPrimaryKey(bean.getId());
		}
	}
	@Override
	public Result getFatherMember(String id) {
		Result rs = Result.getSuccessful();
		MemberRelated query = new MemberRelated();
		query.setMember(id);
		List<MemberRelated> list = memberRelatedMapper.selectByCoudition(query);
		MemberInfo info = new MemberInfo();
		if(list.size() == 1){
			MemberRelated rel = list.get(0);
			info = memberInfoMapper.selectByPrimaryKey(rel.getMemberFather());
			rs.setData(info);
		}else{
			rs.setCode("1");
			rs.setError("未找到父级");;
		}
		return rs;
	}

}
