package tianrui.work.api;

import tianrui.work.vo.Result;

public interface IFileUploadService {

	Result saveImg(String base64Str);
}
