package tianrui.work.mongo;

import java.io.Serializable;
import java.util.List;

public interface BaseDao <T extends Serializable, ID extends Serializable>{

	public void insert(T t);
	
	public List<T> getAll();
}
