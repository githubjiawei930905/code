package com.epeibao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;

import sun.misc.BASE64Decoder;

/**
 * @Description: 上传图片工具类
 * @author Administrator
 * @date 2015年7月11日 上午10:50:15
 */
public class PicUploadUtil {

	/**
	 * @Title: saveOrUpdatePictrue
	 * @Description: base64上传图片
	 * @param imgStr
	 * @param path
	 * @param imgName
	 *            void
	 * @throws
	 */
	public static void saveOrUpdatePictrue(String imgStr, String path,
			String imgName) {
		try {
			String img = imgStr.replaceAll(" ", "+");
			String imgPath = path + "/" + imgName;
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bytes = decoder.decodeBuffer(img);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {
					// 调整异常数据
					bytes[i] += 1024;
				}
			}
			OutputStream out = new FileOutputStream(imgPath);
			out.write(bytes);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title: uploadPic
	 * @Description: 单文件上传
	 * @param path
	 * @param name
	 * @param pic
	 *            void
	 * @throws
	 */
	public static void uploadPic(String path, String name, File pic) {
		OutputStream os = null;
		InputStream is = null;
		try {
			 os = new FileOutputStream(new File(path, name));
			// 输入流
			 is = new FileInputStream(pic);

			byte[] buf = new byte[1024];
			int length = 0;

			while (-1 != (length = is.read(buf))) {
				os.write(buf, 0, length);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: uploadPics
	 * @Description: 多文件上传
	 * @param path
	 * @param names
	 * @param pics
	 *            void
	 * @throws
	 */
	public static void uploadPics(String path, String[] names, File[] pics) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			for (int i = 0; i < pics.length; i++) {
				File savefile = new File(file, names[i]);
				FileUtils.copyFile(pics[i], savefile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
