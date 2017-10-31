package com.tianrui.admin.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tianrui.web.util.FileUtils;

import tianrui.work.api.IAdInfoService;
import tianrui.work.api.IGoodsClassifyService;
import tianrui.work.api.IGoodsInfoService;
import tianrui.work.req.ad.AdInfoReq;
import tianrui.work.req.goods.GoodsClassifyReq;
import tianrui.work.req.goods.GoodsInfoReq;

@Controller
public class CommonalityAction {

	@Autowired
	IGoodsInfoService goodsInfoService;

	@Autowired
	IAdInfoService adInfoService;

	@Autowired
	IGoodsClassifyService goodsClassifyService;

	/** 添加图片 */
	@RequestMapping("/addimg")
	@ResponseBody
	public void addImg(HttpServletRequest request) throws Exception {
		StringBuilder sb = new StringBuilder();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String type = multipartRequest.getParameter("type");// 图片类型：1-商品图片(新增),2-商品图片(修改),3-广告图片,4-分类图标
		String id = multipartRequest.getParameter("id");// 图片路径中的ID：(type==1)-商品ID
		String mark = multipartRequest.getParameter("mark");// 图片名称标志

		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		path = path.substring(6, path.indexOf("WEB-INF"));
		if (path.indexOf(":") == -1)
			path = "/" + path;
		// String path = "C:/Users/Administrator/Desktop/test/";
		if (type.equals("1") || type.equals("2"))
			path += "goodsInfo/" + id + "/";
		else if (type.equals("3"))
			path += "adInfo/";
		else if (type.equals("4"))
			path += "goodsClassify/" + id + "/";
		else
			path += "temp/" + id + "/";
		File f = new File(path);
		if (!f.isDirectory())
			f.mkdirs();

		String name = multipartRequest.getParameter("name");
		String[] nameArr = name.split("[|]");
		for (int i = 0; i < nameArr.length; i++) {
			Long timeMillis = System.currentTimeMillis();// 当前的时间戳
			MultipartFile file = multipartRequest.getFile(nameArr[i]);// 获取上传文件名
			String imgSuffix = file.getOriginalFilename();// 图片后缀
			imgSuffix = imgSuffix.substring(imgSuffix.indexOf("."), imgSuffix.length());
			String newPath = mark + "_" + timeMillis + "_" + i + imgSuffix;
			sb.append(newPath).append("|");
			newPath = path + newPath;

			InputStream is = null;
			try {
				is = file.getInputStream();
				int len = is.available();
				byte[] b = new byte[len];
				is.read(b);

				FileUtils.writeFileAll(newPath, b, 0, len);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
						is = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);

		if (type.equals("1") || type.equals("2")) {
			if (type.equals("2")) {
				String old = multipartRequest.getParameter("old");// 原图片名称标志
				if (!old.equals("") && old != null)
					sb.append("|").append(old);
			}

			GoodsInfoReq req = new GoodsInfoReq();
			req.setGoodsId(id);
			if (mark.equals("goodsImg"))
				req.setGoodsImg(sb.toString());
			else if (mark.equals("goodsDetails"))
				req.setGoodsDetails(sb.toString());
			goodsInfoService.editGoodsInfo(req);
		} else if (type.equals("3")) {
			AdInfoReq req = new AdInfoReq();
			req.setId(Integer.valueOf(id));
			req.setImg(sb.toString());
			adInfoService.editAdInfo(req);
		} else if (type.equals("4")) {
			GoodsClassifyReq req = new GoodsClassifyReq();
			req.setClassifyId(id);
			req.setIcon(sb.toString());
			goodsClassifyService.editGoodsClassify(req);
		}
	}

	/** 获取图片 */
	@RequestMapping("/getimg")
	public void getImg(HttpServletResponse response, String imgPath) throws Exception {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		path = path.substring(6, path.indexOf("WEB-INF"));
		if (path.indexOf(":") == -1)
			path = "/" + path;
		path += imgPath;

		File f = new File(path);
		if (!f.exists())
			return;

		OutputStream os = null;
		try {
			byte[] b = FileUtils.readFileBytes(path);

			response.reset();
			response.setContentType("application/x-png");
			os = response.getOutputStream();
			os.write(b, 0, b.length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
					os = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
