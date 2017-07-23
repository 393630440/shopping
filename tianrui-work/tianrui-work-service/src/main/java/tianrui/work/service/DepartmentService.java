package tianrui.work.service;

import org.springframework.beans.factory.annotation.Autowired;

import tianrui.work.api.IDepartmentService;
import tianrui.work.mapper.java.DepartmentMapper;

public class DepartmentService implements IDepartmentService{

	@Autowired
	DepartmentMapper departmentMapper;
}
