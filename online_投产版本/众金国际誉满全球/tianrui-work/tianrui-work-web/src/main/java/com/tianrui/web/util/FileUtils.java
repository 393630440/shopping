package com.tianrui.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/** 文件工具类 */
public abstract class FileUtils {
	private static Logger log = Logger.getLogger(FileUtils.class);

	/**
	 * 保存图片
	 * 
	 * @param folder
	 *            图片路径标志：格式=[路径/路径/……]，以"/"结尾
	 * @param prefix
	 *            图片名称前缀
	 * @param index
	 *            图片名称下标
	 * @param suffix
	 *            图片名称后缀：如果为空，默认为[.png]格式的
	 * @param imgData
	 *            图片数据
	 * @return
	 * @throws Exception
	 */
	public static String saveImgFile(String folder, String prefix, Integer index, String suffix, String imgData)
			throws Exception {
		StringBuffer imgPath = new StringBuffer();
		imgPath.append(FileUtils.getSysPath(1));
		imgPath.append(folder);
		File f = new File(imgPath.toString());
		if (!f.isDirectory())
			f.mkdirs();

		if (StringUtils.isNull(suffix))
			suffix = ".png";

		Long timestamp = System.currentTimeMillis();
		imgPath.append(prefix).append(timestamp).append("_").append(index).append(suffix);
		boolean mark = FileUtils.convertStrByImg(imgPath.toString(), imgData);
		if (!mark)
			return "";

		StringBuffer imgName = new StringBuffer();
		// imgName.append(folder).append(prefix).append(timestamp).append("_").append(index).append(suffix);
		imgName.append(prefix).append(timestamp).append("_").append(index).append(suffix);

		return imgName.toString();
	}

	/**
	 * 转换图片数据为图片文件
	 * 
	 * @param imgPath
	 *            图片路径
	 * @param imgData
	 *            图片数据
	 */
	public static boolean convertStrByImg(String imgPath, String imgData) {
		// Integer size = imgData.length();// 图片数据的总长度
		// Integer index = imgData.indexOf("base64,") + 7;// 图片数据的开始下标
		// String data = imgData.substring(index, size);// 图片数据：因默认数据头为[]
		// if (data.equals(""))
		// return false;

		byte[] b = Base64.decode(imgData);
		boolean mark = writeFileAll(imgPath, b, 0, b.length);

		return mark;
	}

	/**
	 * 获取图片路径
	 * 
	 * @param folder
	 *            图片路径标志：格式=[路径/路径/……]，以"/"结尾
	 * @param index
	 *            图片名称下标
	 * @param suffix
	 *            图片后缀：如果为"null"，默认为".png"
	 * @return 系统路径/resources/file/"mark"/时间戳_图片下标.图片后缀
	 */
	public static String getImgPath(String folder, Integer index, String suffix) {
		StringBuffer imgPath = new StringBuffer();
		imgPath.append(getSysPath(1));
		imgPath.append(folder);
		File f = new File(imgPath.toString());
		if (!f.isDirectory())
			f.mkdirs();

		if (StringUtils.isNull(suffix))
			suffix = ".png";

		imgPath.append(System.currentTimeMillis()).append("_").append(index).append(suffix);
		return imgPath.toString();
	}

	/**
	 * 获取系统路径
	 * 
	 * @param mark
	 *            路径标志：1-获取图片存放路径；
	 * @return
	 */
	public static String getSysPath(Integer mark) {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		path = path.substring(6, path.indexOf("WEB-INF"));
		if (path.indexOf(":") == -1)
			path = "/" + path;

		if (mark != null) {
			if (mark == 1)
				path += "resources/file/";
		}

		return path;
	}

	/**
	 * 获取文件夹下文件的绝对路径
	 *
	 * @param filePath
	 *            文件夹路径
	 * @param expandName
	 *            文件后缀
	 * @return 文件夹下统一后缀文件的绝对路径的集合
	 */
	public static List<String> fileSelect(String filePath, String expandName) {
		File file = new File(filePath);
		List<String> fileList = new ArrayList<String>();
		File[] subFile = file.listFiles();
		for (File f : subFile) {
			if (!f.isDirectory()) {
				String fileName = f.getName();
				if (fileName.endsWith(expandName))
					fileList.add(f.getAbsolutePath());
			}
		}
		return fileList;
	}

	/**
	 * 读取文件每行的数据
	 *
	 * @param fileName
	 *            文件名
	 * @return 文件中每行数据的集合
	 */
	public static List<String> readFileByLines(String fileName) {
		List<String> list = new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.length() > 0)
					list.add(tempString);
			}
			reader.close();
			reader = null;
		} catch (FileNotFoundException e) {
			log.error("读取文件异常", e);
		} catch (UnsupportedEncodingException e) {
			log.error("文件转换", e);
		} catch (IOException e) {
			log.error("读取数据操作文件异常", e);
		} finally {
			if (reader != null)
				try {
					reader.close();
					reader = null;
				} catch (IOException e1) {
				}
		}
		return list;
	}

	/**
	 * 读取文件数据
	 *
	 * @param fileName
	 *            文件名
	 * @param charSet
	 *            字符数编码
	 * @return 文件数据（String）
	 */
	public static String readFileAll(String fileName, String charSet) {
		String msg = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			int len = fis.available();
			byte[] b = new byte[len];
			fis.read(b);
			msg = new String(b, charSet);
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (Exception e) {
				}
		}
		return msg;
	}

	/**
	 * 读取文件数据
	 *
	 * @param fileName
	 *            读取文件数据
	 * @return 文件数据（byte[]）
	 */
	public static byte[] readFileBytes(String fileName) {
		FileInputStream fis = null;
		byte[] b = null;
		try {
			fis = new FileInputStream(fileName);
			int len = fis.available();
			b = new byte[len];
			fis.read(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
		}
		return b;
	}

	/**
	 * 文件写入数据
	 *
	 * @param fileName
	 *            文件名
	 * @param context
	 *            内容
	 * @return
	 */
	public static boolean writeFileAll(String fileName, String context) {
		return writeFileAll(fileName, context, "UTF-8");
	}

	/**
	 * 文件写入数据
	 *
	 * @param fileName
	 *            文件名
	 * @param context
	 *            内容
	 * @param charSet
	 *            字符数编码
	 * @return
	 */
	public static boolean writeFileAll(String fileName, String context, String charSet) {
		try {
			byte[] b = context.getBytes(charSet);
			return writeFileAll(fileName, b, 0, b.length);
		} catch (UnsupportedEncodingException e) {
			log.error("", e);
		}
		return false;
	}

	/**
	 * 文件写入数据
	 *
	 * @param fileName
	 *            文件名
	 * @param b
	 *            写入的数据
	 * @param off
	 *            开始写入数据的位置（数据中的起始偏移量）
	 * @param len
	 *            要写入的字节数
	 * @return
	 */
	public static boolean writeFileAll(String fileName, byte[] b, int off, int len) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			fos.write(b, off, len);
			fos.flush();
			fos.close();
			fos = null;
			return true;
		} catch (FileNotFoundException e) {
			log.error("读取文件异常", e);
		} catch (IOException e) {
			log.error("写入数据操作文件异常", e);
		} finally {
			if (fos != null)
				try {
					fos.flush();
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	/**
	 * 文件处理
	 *
	 * @param path
	 *            文件路径
	 * @param mark
	 *            操作标识： 1-判断文件是否存在，不存在创建一个空文件； 2-判断是否是一个目录；3-判断文件是否存在
	 * @return
	 * @throws IOException
	 */
	public static boolean isFile(String path, String mark) {
		boolean flag = true;
		try {
			File file = new File(path);
			if (mark.equals("1")) {
				if (!file.exists())
					file.createNewFile();
			} else if (mark.equals("2")) {
				if (!file.isDirectory())
					file.mkdirs();
			} else if (mark.equals("3")) {
				if (!file.exists())
					flag = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
