import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.tianrui.web.util.FileUtils;

public class Test {

	public static void main(String[] args) {

//		List<String> list = FileUtils.readFileByLines("D:/123.xml");
		 List<String> list = FileUtils.readFileByLines("D:/456.xml");

		StringBuffer imgData = new StringBuffer();
		for (String data : list) {
			imgData.append(data);
		}
//		String imgPath = "D:/123.pdf";
		 String imgPath = "D:/456.pdf";

		System.out.println(imgData.length());

		Base64 base64 = new Base64();

		byte[] b = base64.decode(imgData.toString());
		FileUtils.writeFileAll(imgPath, b, 0, b.length);

	}
}
