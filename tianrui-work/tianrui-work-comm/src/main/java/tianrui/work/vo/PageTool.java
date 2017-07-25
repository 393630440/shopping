package tianrui.work.vo;

import java.util.List;
/** 分页查询返回数据类型*/
public class PageTool<T> {

	private List<T> list;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	private Long total;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
}
