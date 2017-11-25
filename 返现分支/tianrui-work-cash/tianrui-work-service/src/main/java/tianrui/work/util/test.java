package tianrui.work.util;

import java.io.*;

/**
 * Created by jyf on 2017/6/2.
 */
public class test {
    public static void main(String[] args) {
        String ftpHost = "47.91.240.215";
        String ftpUserName = "uftp";
        String ftpPassword = "123456";
        int ftpPort = 21;
        String ftpPath = "/data/static/Web/user";
        String localPath = "D:/aaa.txt";
        String fileName = "11.txt";

        //上传一个文件
        try{
            FileInputStream in=new FileInputStream(new File(localPath));
            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,in);
            System.out.println(test);
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(e);
        }

        //在FTP服务器上生成一个文件，并将一个字符串写入到该文件中
//        try {
//            InputStream input = new ByteArrayInputStream("test ftp jyf".getBytes("GBK"));
//            boolean flag = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,input);;
//            System.out.println(flag);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        //下载一个文件
//        FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);
    }
}