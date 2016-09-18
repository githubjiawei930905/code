package tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编码处理类
 * 
 * @author 周璇 wing V 1.0.3 付瀚
 * 
 */
public final class EncodingUtils {

	/************
	 * 将十进制整数转为byte数组（双字节）
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] intToTwoByte(int value) {
		String str = Integer.toHexString(value);

		String s = "";
		if (str.length() < 4) {
			for (int i = 0; i < 4 - str.length(); i++) {
				s += "0";
			}
			str = s + str;
		}

		String s1 = str.substring(0, 2);
		String s2 = str.substring(2, 4);

		int i1 = hexStringToInt(s1);
		int i2 = hexStringToInt(s2);
		byte b[] = { (byte) i1, (byte) i2 };
		return b;
	}

	/************
	 * 将十进制整数转为byte数组（三字节）
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] intToThreeByte(int value) {
		String str = Integer.toHexString(value);

		String s = "";
		if (str.length() < 6) {
			for (int i = 0; i < 6 - str.length(); i++) {
				s += "0";
			}
			str = s + str;
		}

		String s1 = str.substring(0, 2);
		String s2 = str.substring(2, 4);
		String s3 = str.substring(4, 6);

		int i1 = hexStringToInt(s1);
		int i2 = hexStringToInt(s2);
		int i3 = hexStringToInt(s3);
		byte b[] = { (byte) i1, (byte) i2, (byte) i3 };
		return b;
	}

	/******************
	 * 将十进制整数转为byte数组（四字节）
	 */
	public static byte[] intToFourByte(int value) {
		String str = Integer.toHexString(value).toUpperCase();
		String s = "";
		if (str.length() < 4) {
			for (int i = 0; i < 4 - str.length(); i++) {
				s += "0";
			}
			str = s + str;
		}
		// return stringToByte(str);
		return null;
	}

	/*********
	 * 每个以空格分割
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] hex2byte(String value) {
		String[] str = value.split(" ");
		byte[] b = new byte[str.length];
		for (int i = 0; i < str.length; i++) {
			b[i] = (byte) hexStringToInt(str[i]);
		}
		return b;
	}

	/******************
	 * 将多个byte值转为int
	 */
	public static int byteToInt(byte[] b) {
		if (b != null) {
			if (b.length > 0) {
				String s = "";
				for (int i = 0; i < b.length; i++) {
					String v = Integer.toHexString(b[i] & 0xFF);
					if (v.length() == 1) {
						v = "0" + v;
					}
					s += v;
				}
				return hexStringToInt(s);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	/******************
	 * 将两个byte值转为int
	 */
	public int byteToInt(byte b1, byte b2) {
		String s1 = Integer.toHexString(b1 & 0xFF);
		String s2 = Integer.toHexString(b2 & 0xFF);
		if (s1.length() == 1) {
			s1 = "0" + s1;
		}
		if (s2.length() == 1) {
			s2 = "0" + s2;
		}
		return hexStringToInt(s1 + s2);
	}

	/****************
	 * 16进制字符串转为十进制整数 如 将0E转为十进制的14
	 */
	public static int hexStringToInt(String value) {
		return Integer.valueOf(value, 16);
	}

	/*********
	 * 每个以空格分割
	 * 
	 * @param value
	 * @return
	 */
	public byte[] hexStringToIntSZ(String value) {
		String[] str = value.split(" ");
		byte[] b = new byte[str.length];
		for (int i = 0; i < str.length; i++) {
			b[i] = (byte) hexStringToInt(str[i]);
		}
		return b;
	}

	/****************
	 * 16进制字符转为字符串 如 将02转为十进制的2
	 */
	public static String hexStringToString(byte b) {
		return Integer.toHexString(0xFF & b);
	}

	/********************
	 * 将CRC十六进制字符转为byte数组
	 */
	@SuppressWarnings("static-access")
	public byte[] crcToByte(String crc) {
		if (crc.equals("")) {
			return this.intToTwoByte(0);
		} else {
			if (crc.length() < 4) {
				String s = "";
				for (int i = 0; i < 4 - crc.length(); i++) {
					s += "0";
				}
				crc = s + crc;
			}
			String s1 = crc.substring(0, 2);
			String s2 = crc.substring(2, 4);

			int i1 = hexStringToInt(s1);
			int i2 = hexStringToInt(s2);

			byte b[] = { (byte) i1, (byte) i2 };
			return b;
		}
	}

	/**
	 * 将byte数组转换为十进制 string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToString(byte[] bytes) {
		try {
			return new String(bytes, "gb2312");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * 将byte数组转换为 十六进制 string
	 * 
	 * @param bArray
	 * @return
	 */
	public static String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2) {
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}

		return sb.toString();
	}

	/**
	 * 把字符串转化成byte数组
	 * 
	 * @param value
	 *            需要转化的值
	 * @param encoding
	 *            编码格式
	 * @return
	 */
	// public static byte[] stringToByte(String value) {
	// try {
	// if (StringUtils.removeNull(value).equals("")) {
	// return null;
	// } else {
	// return value.getBytes("gb2312");
	// }
	// } catch (UnsupportedEncodingException e) {
	// return null;
	// }
	// }

	/************
	 * hex字符串转对应的char字符
	 */
	public static char hexStringToChar(String hex) {
		int v = hexStringToInt(hex);
		return (char) v;
	}

	/*******************
	 * 把时间转成四字节 yyyy-MM-dd HH:mm:ss 08:30:05 (8*60+30)*60+5=30605 0x0000778D
	 */
	@SuppressWarnings("deprecation")
	public static byte[] timeToByte(String time) {
		// System.out.println(time);
		Date date = stringToDate(time, "yyyy-MM-dd HH:mm:ss");
		int as = (date.getHours() * 60 + date.getMinutes()) * 60
				+ date.getSeconds();
		String hex = Integer.toHexString(as);
		String h = "";
		if (hex.length() < 8) {
			for (int i = 0; i < 8 - hex.length(); i++) {
				h += "0";
			}
		}
		hex = h + hex;
		int j = 0;
		byte b[] = new byte[4];
		for (int i = 0; i <= 6; i = i + 2) {
			b[j] = (byte) hexStringToInt(hex.substring(i, i + 2));
			j++;
		}
		return b;
	}

	/*****************
	 * 日期转三字节 yyyy-MM-dd HH:mm:ss
	 */
	public static byte[] dateToByte(String d) {
		String sYear = d.substring(0, d.indexOf("-"));
		sYear = sYear.substring(2, 4);
		int year = Integer.parseInt(sYear);
		int month = Integer.parseInt(d.substring(d.indexOf("-") + 1,
				d.lastIndexOf("-")));
		int day = Integer.parseInt(d.substring(d.lastIndexOf("-") + 1,
				d.length()));
		byte[] b = new byte[3];
		b[0] = (byte) (year);
		b[1] = (byte) (month);
		b[2] = (byte) (day);
		return b;
	}

	/*****************
	 * 日期转三字节 yyyy-MM-dd HH:mm:ss
	 */
	@SuppressWarnings("deprecation")
	public static byte[] dateToByte(Date d) {
		int year = d.getYear() % 100;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		byte[] b = new byte[3];
		b[0] = (byte) (year);
		b[1] = (byte) (month);
		b[2] = (byte) (day);
		return b;
	}

	private static Date stringToDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 处理Get请求产生的乱码
	 * 
	 * @param temp
	 *            乱码
	 * @return 正确编码的字符串
	 */
	public static String convertEncoding(String temp) {
		try {
			// return new String(temp.getBytes("iso-8859-1"),"UTF-8");
			byte s[] = temp.getBytes("iso-8859-1");
			return new String(s, "GBK");
			// return temp;

		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * @函数功能: BCD码转为10进制串(阿拉伯数据)
	 * @输入参数: BCD码
	 * @输出结果: 10进制串
	 */
	public static String bcdToStr(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();
	}

	/** */
	/**
	 * @函数功能: 10进制串转为BCD码
	 * @输入参数: 10进制串
	 * @输出结果: BCD码
	 */
	public static byte[] strToBcd(String asc) {
		int len = asc.length();
		int mod = len % 2;

		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}

		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;

		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}

			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (charToByte(achar[pos]) << 4 | charToByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte charToByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	/*
	 * 把char转成HexString
	 */
	public static final String charArrayToHexString(char[] c) {
		String resultStr = "";
		String tempStr = "";
		for (int i = 0; i < c.length; i++) {
			tempStr = Integer.toHexString(c[i]).toUpperCase();
			if (c[i] < 16) {
				tempStr = "0" + tempStr;
			}
			resultStr = resultStr + tempStr + " ";
		}

		return resultStr;
	}

	public static char OneHexStrToOnechar(String hex) {
		byte[] ByteArray = new byte[2];
		ByteArray[0] = charToByte(hex.charAt(0));
		ByteArray[1] = charToByte(hex.charAt(1));

		char resultchar = (char) (ByteArray[0] << 4 | ByteArray[1]);
		return resultchar;
	}

	public static final String objectToHexString(Serializable s)
			throws IOException {
		return bytesToHexString(objectToBytes(s));
	}

	public static final Object hexStringToObject(String hex)
			throws IOException, ClassNotFoundException {
		return bytesToObject(hexStringToByte(hex));
	}

	/**
	 * 把可序列化对象转换成字节数组
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static final byte[] objectToBytes(Serializable s) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ot = new ObjectOutputStream(out);
		ot.writeObject(s);
		ot.flush();
		ot.close();
		return out.toByteArray();
	}

	/**
	 * 把字节数组转换为对象
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static final Object bytesToObject(byte[] bytes) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream oi = new ObjectInputStream(in);
		Object o = oi.readObject();
		oi.close();
		return o;
	}

	// 16进制工具
	static final char digits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',

	'9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/**
	 * 10进制转16进制
	 * 
	 * @param num
	 * @return
	 */
	public static final String desToHex(int num) {
		int Num = num;// 要转换的数字

		int length = 32;

		char[] result = new char[length];

		do {

			result[--length] = digits[Num & 15];

			Num >>>= 4;

		} while (Num != 0);
		String str = "";
		for (int i = length; i < result.length; i++) {

			str += result[i];
		}
		return str;
	}

	/**
	 * 16进制转ASC转十进制
	 * 
	 * @param args
	 * @return
	 */
	public static String getAsc(String... args) {
		String str = "";
		for (int i = 0; i < args.length; i++) {
			if (!args[i].equals("00")) {
				str += (char) EncodingUtils.hexStringToInt(args[i]);
			}
		}
		return str;
	}

	/**
	 * 线路保护报文
	 * 
	 * @param strXlJiaMi
	 *            16位线路保护密钥
	 * @param content
	 *            内容 例 20 12 02 02 00 00 00 00 00 00
	 * @param fhfourRandom
	 *            4位随即数 FF FF FF FF
	 * @param pianyi
	 *            偏移量 30
	 * @return 结果报文
	 */
	public static String getBWXLBH(String strXlJiaMi, String content,
			String fhfourRandom, int pianyi) {
		// 基础报文 自己拼 看内容而定
		// content = "04 D6 00 " + EncodingUtils.desToHex(pianyi) + " "
		// + EncodingUtils.desToHex(content.split(" ").length + 4) + " "
		// + content;
		// byte[] key = EncodingUtils.hex2byte(strXlJiaMi);
		// // 分散因子转换为byte
		// byte[] value = EncodingUtils.hex2byte(content);
		// // 4位因子
		// byte[] suijishu = EncodingUtils.hex2byte(fhfourRandom);

		// 加密结果为8位
		// byte[] result = DessUtils.mac(value, suijishu, key);
		// // 获取前4位报文拼成字符串
		// String mac = Integer.toHexString(result[0] & 0xff) + " "
		// + Integer.toHexString(result[1] & 0xff) + " "
		// + Integer.toHexString(result[2] & 0xff) + " "
		// + Integer.toHexString(result[3] & 0xff);
		// System.out.println("mac:" + mac);
		// 结果报文
		// String neirong = "08 " + content + " " + mac;
		// content = "BC DE "
		// + EncodingUtils.desToHex(neirong.split(" ").length + 1) + " 08 "
		// + content + " " + mac + " " + yihuo(neirong);
		// String arges[]=content.split(" ");
		// content="";
		// for(int i=0;i<arges.length;i++)
		// {
		// content+=EncodingUtils.addzero(arges[i],2)+" ";
		// }
		return content;
	}

	/**
	 * 非接触式卡线路保护报文
	 * 
	 * @param strXlJiaMi
	 *            16位线路保护密钥
	 * @param content
	 *            内容 例 20 12 02 02 00 00 00 00 00 00
	 * @param fhfourRandom
	 *            4位随即数 FF FF FF FF
	 * @param pianyi
	 *            偏移量 30
	 * @return 结果报文
	 */
	public static String getFJCBWXLBH(String strXlJiaMi, String content,
			String fhfourRandom, int pianyi) {
		// 基础报文 自己拼 看内容而定
		// content = "04 D6 00 " + EncodingUtils.desToHex(pianyi) + " "
		// + EncodingUtils.desToHex(content.split(" ").length + 4) + " "
		// + content;
		// byte[] key = EncodingUtils.hex2byte(strXlJiaMi);
		// // 分散因子转换为byte
		// byte[] value = EncodingUtils.hex2byte(content);
		// // 4位因子
		// byte[] suijishu = EncodingUtils.hex2byte(fhfourRandom);
		//
		// // 加密结果为8位
		// byte[] result = DessUtils.mac(value, suijishu, key);
		// // 获取前4位报文 拼成字符串
		// String mac = Integer.toHexString(result[0] & 0xff) + " "
		// + Integer.toHexString(result[1] & 0xff) + " "
		// + Integer.toHexString(result[2] & 0xff) + " "
		// + Integer.toHexString(result[3] & 0xff);
		// System.out.println("mac:" + mac);
		// // 结果报文
		// String neirong = "22 " + content + " " + mac;
		// content = "BC DE "
		// + EncodingUtils.desToHex(neirong.split(" ").length + 1) + " 22 "
		// + content + " " + mac + " " + yihuo(neirong);
		// String arges[]=content.split(" ");
		// content="";
		// for(int i=0;i<arges.length;i++)
		// {
		// content+=EncodingUtils.addzero(arges[i],2)+" ";
		// }
		return content;
	}

	/**
	 * 异或运算 字符串每16进制字节以空格分开
	 * 
	 * @return
	 */
	public static String yihuo(String str) {

		String[] arges = str.split(" ");
		int shijinzhi = Integer.parseInt(arges[0], 16);
		for (int i = 1; i < arges.length; i++) {
			shijinzhi = shijinzhi ^ Integer.parseInt(arges[i], 16);
		}
		String result = Integer.toHexString(shijinzhi);
		return result;
	}

	/**
	 * 更改字符串格式（每两个字符加空格,如"00 19 22"）
	 * 
	 * @return
	 */
	public static String change(String content) {
		String str = "";
		for (int i = 0; i < content.length(); i++) {
			if (i % 2 == 0) {
				str += " " + content.substring(i, i + 1);
			} else {
				str += content.substring(i, i + 1);
			}
		}
		return str.trim();
	}

	/**
	 * 字符串前面补0
	 * 
	 * @return
	 */
	public static String addzero(String str, int num) {
		String s = "";
		for (int i = 0; i < num; i++) {
			s += "0";
		}
		s = s.substring(0, s.length() - str.length());
		s += str;
		return s;
	}

	/**
	 * 字符串后面补0
	 * 
	 * @return
	 */
	public static String addzero2(String str, int num) {
		String s = "";
		for (int i = 0; i < num; i++) {
			s += "0";
		}
		s = s.substring(0, s.length() - str.length());
		s = str + s;
		return s;
	}

	/**
	 * 将字符串变为16进制asc格式 1-33 A-41
	 * 
	 * @return
	 */
	public static String getasc(String str) {
		String s = "";
		byte numbers[] = null;
		numbers = str.getBytes();
		int num;
		for (int j = 0; j < numbers.length; j++) {
			num = numbers[j];
			s += EncodingUtils.desToHex(num);
		}
		return s;
	}

	/**
	 * ascii转字符串
	 * 
	 * @param value
	 *            要转码的字符串 每个以空格分隔
	 * @return
	 */
	public static String asciiToString(String value) {
		String content = "";
		String[] chars = value.split(" ");
		for (int i = 0; i < chars.length; i++) {
			content += (char) Integer.parseInt(chars[i]);
		}
		return content;
	}

	/**
	 * 写非线路保护表的暴文
	 * 
	 * @param content
	 *            以空格分隔
	 * @param pianyi
	 *            2个字节
	 * @type 接触式还是非接触式的 1，接触式 2 非接触式
	 * @return
	 */
	public static String getNotBaoWen(String content, String pianyi, int type) {
		if (type == 1) {
			String baowen = "08 00 D6 "
					+ pianyi
					+ " "
					+ EncodingUtils.addzero(
							Integer.toHexString(content.split(" ").length), 2)
					+ " " + content;
			baowen = baowen + " " + EncodingUtils.addzero(yihuo(baowen), 2);
			baowen = "BC DE "
					+ EncodingUtils.addzero(
							Integer.toHexString(baowen.split(" ").length), 2)
					+ " " + baowen;
			return baowen;
		} else {
			String baowen = "22 00 D6 "
					+ pianyi
					+ " "
					+ EncodingUtils.addzero(
							Integer.toHexString(content.split(" ").length), 2)
					+ " " + content;
			baowen = baowen + " " + EncodingUtils.addzero(yihuo(baowen), 2);
			baowen = "BC DE "
					+ EncodingUtils.addzero(
							Integer.toHexString(baowen.split(" ").length), 2)
					+ " " + baowen;
			return baowen;
		}

	}

	/**
	 * 中文轉asicc 此方法 才是无敌的ascii转换，可以转换中文，在网上查的都是骗子，明明是unicode编码，非说是GB2312，这个是正确的。
	 * 
	 * @param c
	 * @return
	 */
	public static String getAscii(String c) {
		String s = String.valueOf(c);
		byte[] bytes = s.getBytes();
		String dd = "";
		for (int i = 0; i < bytes.length; i++)
			dd += Integer.toHexString(bytes[i] & 0xff);
		return dd;

	}

	/**
	 * Asc转字符
	 * 
	 * @return
	 */
	public static String AsctoString(String value) {
		return new String(EncodingUtils.hex2byte(value));
	}

	/**
	 * 16进制的ascii码转字符串
	 * 
	 * @param asc_Str
	 * @return
	 */
	public static String asciiTo2String(String asc_Str) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(
				asc_Str.length() / 2);
		String hexString = "0123456789ABCDEF";
		for (int i = 0; i < asc_Str.length(); i += 2)
			baos.write((hexString.indexOf(asc_Str.charAt(i)) << 4 | hexString
					.indexOf(asc_Str.charAt(i + 1))));
		return new String(baos.toByteArray());
	}
}
