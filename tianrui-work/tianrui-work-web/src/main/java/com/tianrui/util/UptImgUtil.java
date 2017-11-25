package com.tianrui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.tianrui.web.util.Base64;

public class UptImgUtil {

	public static void main(String[] args) {
//		File file = new File("H:\\6bba6b5db167426c85109dc58b5741dd (2).png");
//		http://www.da156.cn/uploadimgs/6bba6b5db167426c85109dc58b5741dd.png
		File file = new File("http://www.da156.cn/uploadimgs/6bba6b5db167426c85109dc58b5741dd.png");
		fileToBase64(file);
		
	}
	
	public static String fileToBase64(File file) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            int length = in.read(bytes);
            base64 = Base64.encode(bytes);
            System.out.println(base64);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return base64;
    }

	
}
