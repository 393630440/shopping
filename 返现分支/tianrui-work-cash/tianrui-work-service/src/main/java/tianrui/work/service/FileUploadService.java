package tianrui.work.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import tianrui.work.api.IFileUploadService;
import tianrui.work.vo.Result;
import tianrui.work.vo.UUIDUtil;

@Service
public class FileUploadService implements IFileUploadService{

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Override
	public Result saveImg(String base64Str) {
		Result rs = Result.getSuccessful();
		try {
			if(StringUtils.isNotBlank(base64Str)){
				String imgName = UUIDUtil.getUUID()+".png";
				byte[] out = Base64.decodeBase64(base64Str);
				InputStream input = new ByteArrayInputStream(out);
				gridFsTemplate.store(input, imgName);
				rs.setData(imgName);
			}else{
				rs.setCode("1");
				rs.setError("图片不能为空");
			}
		} catch (Exception e) {
			rs.setCode("1");
			rs.setError("图片上传失败");
		}
		return rs;
	}
}
