package tianrui.work.mongo.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import tianrui.work.mongo.BaseDao;

@Repository("mongoBaseDao")
public class BaseDaoImp<T extends Serializable, ID extends Serializable> implements BaseDao<T,ID>  {

	private Class<T> type; 
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(t);
	}
	@Override
	public List<T> getAll(){
		return mongoTemplate.findAll(type);
	}

}
