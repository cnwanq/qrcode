package net.fansit;

import net.glxn.qrgen.javase.QRCode;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.rmi.server.ExportException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Start Generate QR Image");
        System.out.println(System.getProperty("user.dir"));

        // 二维码
        String qrcodeValue = "Hello QRCode";
        // 目标路径
        String destPath = ".";
        // 目标文件名称
        String fileName = "image.jpg";

        if (args.length >= 1) {
            qrcodeValue = args[0];
        }
        if (args.length >= 2) {
            destPath = args[1];
        }
        if (args.length == 3) {
            fileName = args[2];
        }

        File file = QRCode.from(qrcodeValue).file();

        try {
            File dir = new File(destPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            if (!destPath.endsWith(File.separator)) {
                destPath = destPath + File.separator;
            }
            File targetFile = new File(destPath + fileName);
            FileUtils.copyFile(file, targetFile);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
