package tianrui.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IConnectService;
import tianrui.work.mapper.java.ConnectMapper;
@Service
public class ConnectService implements IConnectService{
	@Autowired
	ConnectMapper  connectMapper;
}
