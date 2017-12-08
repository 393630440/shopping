package tianrui.work.mongo.imp;

import org.springframework.stereotype.Repository;

import tianrui.work.mongo.FileImgDao;
import tianrui.work.mongo.bean.FileImgReg;

@Repository("FileImgServic")
public class FileImgServiceDao extends BaseDaoImp<FileImgReg,String> implements FileImgDao{


}
