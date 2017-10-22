package tianrui.work.mapper.java;

import tianrui.work.bean.WeChatPay;

public interface WeChatPayMapper {
    int deleteByPrimaryKey(String id);

    int insert(WeChatPay record);

    int insertSelective(WeChatPay record);

    WeChatPay selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WeChatPay record);

    int updateByPrimaryKey(WeChatPay record);
}