package com.tianrui.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 算法
 */
public class MD5 {
	
	 private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
         "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String code(String strObj) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = Base64.encode(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	/**
	 * 红包MD5
	 * @Description :
	 * @param 
	 * @return 
	 * ---------------
	 * @throws Exception 
	 * @Author  : My
	 * @CreateData : 2016-1-29
	 */
	public static String hbMD5(String strObj) throws Exception {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			 resultString = byteToString(md.digest(strObj.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString.toString();
	}
	
	// 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
}