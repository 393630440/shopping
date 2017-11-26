package tianrui.work.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoTest {
//	47.91.240.215
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	
	private static final String host = "47.91.240.215";  
	private static final int port = 27017;  
	private static final String userName = "mydb";  
	private static final String password = "123456";  
	private static final String dataBaseName = "mydb";  
	private static final String tableName = "test";  
	
	public static void main(String[] args) throws FileNotFoundException {
//		connectMongoDB();
		File in=new File("F:/xxxx.png");
		SaveFile("fs",in,"xxxx.png","xxxx","xxxx.png");
	}
	
//	public void sss(){
//		gridFsTemplate.store(
//	}
	
	public static void SaveFile(String collectionName, File file, String fileid, String companyid, String filename) {
        try {
        	MongoClient mongoClient = new MongoClient(host,port);  
  	        DB db = mongoClient.getDB(dataBaseName);  
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSInputFile gfs = gridFS.createFile(file);
            gfs.put("aliases", companyid);
            gfs.put("filename", fileid);
            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
            gfs.save();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }
    }
	
	public static void connectMongoDB(){  
	    try{  
	        MongoClient mongoClient = new MongoClient(host,port);  
	        DB db = mongoClient.getDB(dataBaseName);  
	        DBCollection dbCollection = db.getCollection(tableName);  
	        DBCursor dbCursor = dbCollection.find();  
	        while(dbCursor.hasNext()){  
	            System.out.println(dbCursor.next());  
	        }  
	    }catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}  
}
