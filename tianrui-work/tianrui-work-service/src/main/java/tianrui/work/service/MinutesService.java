package tianrui.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tianrui.work.api.IMinutesService;
import tianrui.work.mapper.java.MinutesMapper;
@Service
public class MinutesService implements IMinutesService{

	@Autowired
	MinutesMapper minutesMapper;
}
