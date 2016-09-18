package tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * byte数组工具类 需要协同MsgOffset使用
 * 
 * @author Jiapf
 */
public class BytesUtils {

	public enum Endianness {
		LittleEndian, // 小端
		BigEndian // 大端
	}

	/**
	 * byte数组追加一字节数字(byte)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的数字
	 * @return 追加一字节数字后的数组
	 */
	public static byte[] AppendByte(byte[] bytes, byte value) {
		int iPos = bytes.length;
		byte[] bbts = new byte[bytes.length + 1];
		bbts[iPos + 0] = value;
		System.arraycopy(bytes, 0, bbts, 0, bytes.length);
		return bbts;
	}

	/**
	 * byte数组追加两字节数字(short)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的数字
	 * @param endian
	 *            大小端模式
	 * @return 追加两字节数字后的数组
	 */
	public static byte[] AppendWord(byte[] bytes, short value, Endianness endian) {
		int iPos = bytes.length;
		byte[] bbts = new byte[bytes.length + 2];
		if (endian == Endianness.BigEndian) {
			bbts[iPos + 0] = (byte) (value >> 8);
			bbts[iPos + 1] = (byte) (value >> 0);
		} else {
			bbts[iPos + 0] = (byte) (value >> 0);
			bbts[iPos + 1] = (byte) (value >> 8);
		}
		System.arraycopy(bytes, 0, bbts, 0, bytes.length);
		return bbts;
	}

	/**
	 * byte数组追加四字节数字(int)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的数字
	 * @param endian
	 *            大小端模式
	 * @return 追加四字节数字后的数组
	 */
	public static byte[] AppendInteger(byte[] bytes, int value,
			Endianness endian) {
		int iPos = bytes.length;
		byte[] bbts = new byte[bytes.length + 4];
		if (endian == Endianness.BigEndian) {
			bbts[iPos + 0] = (byte) (value >> 24);
			bbts[iPos + 1] = (byte) (value >> 16);
			bbts[iPos + 2] = (byte) (value >> 8);
			bbts[iPos + 3] = (byte) (value >> 0);
		} else {
			bbts[iPos + 0] = (byte) (value >> 0);
			bbts[iPos + 1] = (byte) (value >> 8);
			bbts[iPos + 2] = (byte) (value >> 16);
			bbts[iPos + 3] = (byte) (value >> 24);
		}
		System.arraycopy(bytes, 0, bbts, 0, bytes.length);
		return bbts;
	}

	/**
	 * byte数组追加byte数组
	 * 
	 * @param bytes
	 *            目标数组
	 * @param append
	 *            追加的数组
	 * @return 追加数组后的数组
	 */
	public static byte[] AppendBytes(byte[] bytes, byte[] append) {
		return AppendBytes(bytes, append, append.length);
	}

	/**
	 * byte数组追加byte数组
	 * 
	 * @param bytes
	 *            目标数组
	 * @param append
	 *            追加的数组
	 * @param len
	 *            追加的字节数
	 * @return 追加数组后的数组
	 */
	public static byte[] AppendBytes(byte[] bytes, byte[] append, int len) {
		byte[] bbts = new byte[bytes.length + append.length];
		System.arraycopy(bytes, 0, bbts, 0, bytes.length);
		System.arraycopy(append, 0, bbts, bytes.length, len);
		return bbts;
	}

	/**
	 * byte数组追加bytes数组
	 * 
	 * @param bytes
	 *            目标数组
	 * @param bytess
	 *            若干追加的数组
	 * @return 追加若干数组后的数组
	 */
	public static byte[] AppendBytes(byte[] bytes, byte[]... bytess) {
		int len = 0;
		int pos = 0;
		for (int i = 0; i < bytess.length; i++) {
			len += bytess[i].length;
		}
		if (len == 0) {
			return bytes;
		}
		byte[] bbts = new byte[bytes.length + len];
		System.arraycopy(bytes, 0, bbts, 0, bytes.length);
		pos = bytes.length;
		for (int i = 0; i < bytess.length; i++) {
			System.arraycopy(bytess[i], 0, bbts, pos, bytess[i].length);
			pos += bytess[i].length;
		}
		return bbts;
	}

	/**
	 * byte数组追加BCD码
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            BCD字符串
	 * @return 追加BCD码后的数组
	 */
	public static byte[] AppendBCDString(byte[] bytes, String value) {
		byte[] abts = new byte[value.length() / 2];
		byte[] bbts = new byte[value.length() / 2 + bytes.length];
		abts = Str2BCD(value);
		bbts = AppendBytes(bytes, abts);
		return bbts;
	}

	/**
	 * byte数组追加字符串(如:北京1号->B1 B1 BE A9 31 BA C5)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串
	 * @return 追加字符串后的数组
	 * @throws Exception
	 */
	public static byte[] AppendString(byte[] bytes, String value,
			String encoding) throws Exception {
		byte[] abts = value.getBytes(encoding);
		byte[] bbts = new byte[bytes.length + abts.length];
		bbts = AppendBytes(bytes, abts);
		return bbts;
	}

	/**
	 * byte数组追加0x00结尾的字符串(如:北京1号->B1 B1 BE A9 31 BA C5 00))
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串(结尾无需包含0x00)
	 * @return 追加字符串后的数组
	 */
	public static byte[] AppendStrWith0End(byte[] bytes, String value) {
		byte[] abts = value.getBytes();
		byte[] bbts = new byte[bytes.length + abts.length + 1];
		bbts = AppendBytes(bytes, abts, new byte[] { 0 });
		return bbts;
	}

	/**
	 * byte数组追加前跟一字节长度的字符串(如:北京1号->07 B1 B1 BE A9 31 BA C5))
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串(前无需包含一字节的长度)
	 * @return 追加字符串后的数组
	 */
	public static byte[] AppendStrWith1BLen(byte[] bytes, String value) {
		byte[] abts = value.getBytes();
		byte[] bbts = new byte[bytes.length + abts.length];
		bbts = AppendBytes(bytes, new byte[] { (byte) abts.length }, abts);
		return bbts;
	}

	/**
	 * byte数组追加前跟一字节长度的字符串(如:北京1号->07 B1 B1 BE A9 31 BA C5))
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串(前无需包含一字节的长度)
	 * @param len
	 *            追加字节 0x00
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 追加字符串后的数组
	 * @throws Exception
	 */
	public static byte[] AppendStrWith1BLenFill(byte[] bytes, String value,
			int len, String encoding) throws Exception {
		byte[] b = new byte[0];
		byte[] lengthbyte = AppendByte(bytes,
				(byte) AppendFixedStr(b, value, 0, encoding).length);
		byte[] messagebyte = AppendFixedStr(lengthbyte, value, len, encoding);
		return messagebyte;
		// return bbts;
	}

	/**
	 * byte数组追加前跟两字节长度的字符串(如:北京1号->00 07 B1 B1 BE A9 31 BA C5))
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串(前无需包含两字节的长度)
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @param endian
	 *            大小端模式
	 * @return 追加字符串后的数组
	 * @throws Exception
	 */
	public static byte[] AppendStrWith2BLen(byte[] bytes, String value,
			String encoding, Endianness endian) throws Exception {
		byte[] abts = value.getBytes(encoding);
		byte[] bbts = new byte[bytes.length + abts.length];
		bbts = AppendWord(bytes, (short) abts.length, endian);
		bbts = AppendBytes(bbts, abts);
		return bbts;
	}

	/**
	 * byte数组追加定长字符串(长度不足,0x00补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串
	 * @param len
	 *            追加的字节数
	 * @param type
	 *            0:不计算长度 1计算长度
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 追加字符串后的数组
	 * @throws Exception
	 */
	public static byte[] AppendFixedStr(byte[] bytes, String value, int len,
			String encoding) throws Exception {
		return AppendFixedStr(bytes, value, len, (byte) 0x00, encoding);
	}

	/**
	 * byte数组追加定长字符串(长度不足,自定义byte值补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            追加的字符串
	 * @param len
	 *            追加的字节数
	 * @param fill
	 *            一字节补位数值
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 追加字符串后的数组
	 * @throws Exception
	 */
	public static byte[] AppendFixedStr(byte[] bytes, String value, int len,
			byte fill, String encoding) throws Exception {
		byte[] abts = value.getBytes(encoding);
		int diff = len - abts.length;
		if (diff < 0) {
			diff = 0;
			len = abts.length;
		}
		byte[] tbts = new byte[diff];
		for (int i = 0; i < diff; i++) {
			tbts[i] = fill;
		}
		abts = AppendBytes(abts, tbts);
		byte[] bbts = new byte[bytes.length + len];
		bbts = AppendBytes(bytes, abts, len);
		return bbts;
	}

	/**
	 * 从byte数组中读取一字节数字(byte)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @return 读取结果
	 */
	public static int ReadByte(byte[] bytes, MsgOffset offset) {
		int value = bytes[offset.GetOffset()] & 0xFF;
		offset.IncOffset(1);
		return value & 0xFF;
	}

	/**
	 * 从byte数组中读取一字节数字(byte)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @return 读取结果
	 */
	public static int ReadByte(byte[] bytes, int offset) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadByte(bytes, temp);
	}

	/**
	 * 从byte数组中读取两字节数字(short)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static int ReadWord(byte[] bytes, MsgOffset offset, Endianness endian) {
		int value = 0;
		if (endian == Endianness.BigEndian) {
			value = ((bytes[offset.GetOffset()] << 8) & 0xFFFF)
					+ ((bytes[offset.GetOffset() + 1]) & 0xFF);
		} else {
			value = ((bytes[offset.GetOffset()]) & 0xFF)
					+ ((bytes[offset.GetOffset() + 1] << 8) & 0xFFFF);
		}
		offset.IncOffset(2);
		return value & 0xFFFF;
	}

	/**
	 * 从byte数组中读取两字节数字(short)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static int ReadWord(byte[] bytes, int offset, Endianness endian) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadWord(bytes, temp, endian);
	}

	/**
	 * 从byte数组中读取四字节数字(int)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static int ReadInteger(byte[] bytes, MsgOffset offset,
			Endianness endian) {
		int value = 0;
		if (endian == Endianness.BigEndian) {
			value = (bytes[offset.GetOffset() + 0] << 24)
					+ (bytes[offset.GetOffset() + 1] << 16)
					+ (bytes[offset.GetOffset() + 2] << 8)
					+ (bytes[offset.GetOffset() + 3] << 0);
		} else {
			value = (bytes[offset.GetOffset() + 0] << 0)
					+ (bytes[offset.GetOffset() + 1] << 8)
					+ (bytes[offset.GetOffset() + 2] << 16)
					+ (bytes[offset.GetOffset() + 3] << 24);
		}
		offset.IncOffset(4);
		return value & 0xFFFFFFFF;
	}

	/**
	 * 从byte数组中读取四字节数字(int)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static int ReadInteger(byte[] bytes, int offset, Endianness endian) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadInteger(bytes, temp, endian);
	}

	/**
	 * 从byte数组中读取定长字符串(长度不足,0x00补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param @param encoding 编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadFixedStr(byte[] bytes, MsgOffset offset, int len,
			String encoding) throws Exception {
		return ReadFixedStr(bytes, offset, len, (byte) 0x00, encoding);
	}

	/**
	 * 从byte数组中读取定长字符串(长度不足,0x00补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadFixedStr(byte[] bytes, int offset, int len,
			String encoding) throws Exception {
		return ReadFixedStr(bytes, offset, len, (byte) 0x00, encoding);
	}

	/**
	 * 从byte数组读取定长字符串(长度不足,自定义byte值补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param fill
	 *            一字节补位数值
	 * @param encoding
	 *            编码规则 utf-8 或者 GBK
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadFixedStr(byte[] bytes, MsgOffset offset, int len,
			byte fill, String encoding) throws Exception {
		String value = "";
		int i = 0;
		if (bytes.length < offset.GetOffset() + len) {
			len = bytes.length - offset.GetOffset();
		}
		if (len > 0) {
			byte[] abts = new byte[len];
			System.arraycopy(bytes, offset.GetOffset(), abts, 0, len);
			for (i = 0; i < len; i++) {
				if (abts[i] == fill) {
					break;
				}
			}
			if (i > 0) {
				byte[] bbts = new byte[i];
				System.arraycopy(abts, 0, bbts, 0, i);
				value = new String(bbts, encoding);
			}
		}
		offset.IncOffset(len);
		return value;
	}

	/**
	 * 从byte数组中读取定长字符串(长度不足,自定义byte值补位)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param fill
	 *            一字节补位数值
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadFixedStr(byte[] bytes, int offset, int len,
			byte fill, String encoding) throws Exception {
		MsgOffset temp = new MsgOffset(offset);
		return ReadFixedStr(bytes, temp, len, encoding);
	}

	/**
	 * 从byte数组中读取前跟一字节长度的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            偏移量
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadStrWith1BLen(byte[] bytes, MsgOffset offset,
			String encoding) throws Exception {
		String value = "";
		int len = ReadByte(bytes, offset);
		if (len > 0) {
			value = ReadFixedStr(bytes, offset, len, encoding);
		}
		return value;
	}

	/**
	 * 从byte数组中读取前跟一字节长度的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            偏移量
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadStrWith1BLen(byte[] bytes, int offset,
			String encoding) throws Exception {
		MsgOffset temp = new MsgOffset(offset);
		return ReadStrWith1BLen(bytes, temp, encoding);
	}

	/**
	 * 从byte数组中读取前跟两字节长度的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            偏移量
	 * @param endian
	 *            大小端模式
	 * @param encoding
	 *            编码规则
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadStrWith2BLen(byte[] bytes, MsgOffset offset,
			Endianness endian, String encoding) throws Exception {
		String value = "";
		int len = ReadWord(bytes, offset, endian);
		if (len > 0) {
			value = ReadFixedStr(bytes, offset, len, encoding);
		}
		return value;
	}

	/**
	 * 从byte数组中读取前跟两字节长度的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            偏移量
	 * @param endian
	 *            大小端模式
	 * @param encoding
	 *            编码规则 GBK或者utf-8
	 * @return 读取结果
	 * @throws Exception
	 */
	public static String ReadStrWith2BLen(byte[] bytes, int offset,
			Endianness endian, String encoding) throws Exception {
		MsgOffset temp = new MsgOffset(offset);
		return ReadStrWith2BLen(bytes, temp, endian, encoding);
	}

	/**
	 * 从byte数组中读取0x00结尾的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @return 读取结果
	 */
	public static String ReadStrWith0End(byte[] bytes, MsgOffset offset) {
		String value = "";
		int i = 0;
		for (i = offset.GetOffset(); i < bytes.length; i++) {
			if (bytes[i] == 0x00) {
				byte[] bbts = new byte[i - offset.GetOffset()];
				System.arraycopy(bytes, offset.GetOffset(), bbts, 0,
						bbts.length);
				value = new String(bbts);
				break;
			}
		}
		offset.IncOffset(i - offset.GetOffset() + 1);
		return value;
	}

	/**
	 * 从byte数组中读取0x00结尾的字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @return 读取结果
	 */
	public static String ReadStrWith0End(byte[] bytes, int offset) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadStrWith0End(bytes, temp);
	}

	/**
	 * 从byte数组中读取BCD码
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取结果
	 */
	public static String ReadBCDString(byte[] bytes, MsgOffset offset, int len) {
		return ReadBCDString(bytes, offset, len, "");
	}

	/**
	 * 从byte数组中读取BCD码
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取结果
	 */
	public static String ReadBCDString(byte[] bytes, int offset, int len) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadBCDString(bytes, temp, len, "");
	}

	/**
	 * 从byte数组中读取BCD码
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param delimiter
	 *            分隔符
	 * @return 读取结果
	 */
	public static String ReadBCDString(byte[] bytes, MsgOffset offset, int len,
			String delimiter) {
		String value = "";
		value = BytesToHex(bytes, offset.GetOffset(), offset.GetOffset() + len
				- 1, delimiter);
		offset.IncOffset(len);
		return value;
	}

	/**
	 * 从byte数组中读取BCD码并转换为数值(int)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static int ReadBCDInteger(byte[] bytes, MsgOffset offset, int len) {
		return Integer.valueOf(ReadBCDInteger(bytes, offset, len));
	}

	/**
	 * 从byte数组中读取BCD码并转换为数值(int)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static int ReadBCDInteger(byte[] bytes, int offset, int len) {
		return Integer.valueOf(ReadBCDInteger(bytes, offset, len));
	}

	/**
	 * 从byte数组中读取BCD码并转换为数值(long)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static long ReadBCDLong(byte[] bytes, MsgOffset offset, int len) {
		return Long.valueOf(ReadBCDString(bytes, offset, len));
	}

	/**
	 * 从byte数组中读取BCD码并转换为数值(long)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static long ReadBCDLong(byte[] bytes, int offset, int len) {
		return Long.valueOf(ReadBCDString(bytes, offset, len));
	}

	/**
	 * 从byte数组中读取BCD码并转换为时间(默认时间格式yyMMddHHmmss)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static Date ReadBCDDate(byte[] bytes, MsgOffset offset, int len)
			throws ParseException {
		return ReadBCDDate(bytes, offset, len, "yyMMddHHmmss");
	}

	/**
	 * 从byte数组中读取BCD码并转换为时间(默认时间格式yyMMddHHmmss)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @return 读取并转换后的结果
	 */
	public static Date ReadBCDDate(byte[] bytes, int offset, int len)
			throws ParseException {
		return ReadBCDDate(bytes, offset, len, "yyMMddHHmmss");
	}

	/**
	 * 从byte数组中读取BCD码并转换为时间
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param format
	 *            时间格式
	 * @return 读取并转换后的结果
	 * @throws ParseException
	 */
	public static Date ReadBCDDate(byte[] bytes, MsgOffset offset, int len,
			String format) throws ParseException {
		Date date = new SimpleDateFormat(format).parse(ReadBCDString(bytes,
				offset, len));
		return date;
	}

	/**
	 * 从byte数组中读取BCD码并转换为时间
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param len
	 *            读取的字节数
	 * @param format
	 *            时间格式
	 * @return 读取并转换后的结果
	 * @throws ParseException
	 */
	public static Date ReadBCDDate(byte[] bytes, int offset, int len,
			String format) throws ParseException {
		Date date = new SimpleDateFormat(format).parse(ReadBCDString(bytes,
				offset, len));
		return date;
	}

	/**
	 * byte数组转换字符串(默认各字节之间空格分隔,并且是全数组转换)
	 * 
	 * @param bytes
	 *            目标数组
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes) {
		return BytesToHex(bytes, " ");
	}

	/**
	 * byte数组转换字符串(默认各字节之间空格分隔)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param start
	 *            起始位置,默认到数组尾
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes, int start) {
		return BytesToHex(bytes, start, " ");
	}

	/**
	 * 将字符串转换成byte数组
	 * 
	 * @param msg
	 * @return
	 */
	public static byte[] stringToHex(String msg) {
		byte b[] = new byte[0];
		if (msg != null && msg != "") {
			b = AppendBCDString(b, msg);
			return b;
		}
		return null;
	}

	/**
	 * byte数组转换字符串(默认全数组转换)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param delimiter
	 *            各个字节之间的分隔符
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes, String delimiter) {
		return BytesToHex(bytes, 0, bytes.length - 1, delimiter);
	}

	/**
	 * byte数组转换字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param start
	 *            起始位置,默认到数组尾
	 * @param delimiter
	 *            各个字节之间的分隔符
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes, int start, String delimiter) {
		return BytesToHex(bytes, start, bytes.length - 1, delimiter);
	}

	/**
	 * 数组转换字符串(默认各字节之间空格分隔)
	 * 
	 * @param bytes
	 *            目标数组
	 * @param start
	 *            起始位置
	 * @param end
	 *            结束位置
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes, int start, int end) {
		return BytesToHex(bytes, start, end, " ");
	}

	/**
	 * 数组转换字符串
	 * 
	 * @param bytes
	 *            目标数组
	 * @param start
	 *            起始位置
	 * @param end
	 *            结束位置
	 * @param delimiter
	 *            各个字节之间的分隔符
	 * @return 转换后的结果
	 */
	public static String BytesToHex(byte[] bytes, int start, int end,
			String delimiter) {
		String value = "";
		if (start > end) {
			System.exit(0);
		}
		if (bytes.length - 1 < end) {
			end = bytes.length - 1;
		}
		for (int i = start; i <= end; i++) {
			value += String.format("%02x", bytes[i]).toUpperCase() + delimiter;
		}
		return RightTrim(value);
	}

	/**
	 * 字符串转换BCD码
	 * 
	 * @param value
	 *            字符串
	 * @return BCD码的byte数组
	 */
	public static byte[] Str2BCD(String value) {
		int iLen = value.length();
		int iMod = iLen % 2;
		if ((iLen == 0) || (iMod != 0)) {
			return new byte[0];
		}
		if (iMod != 0) {
			value = "0" + value;
			iLen = value.length();
		}
		byte abts[] = new byte[iLen];
		if (iLen >= 2) {
			iLen = iLen / 2;
		}
		byte bbts[] = new byte[iLen];
		abts = value.getBytes();
		int j, k;
		for (int p = 0; p < value.length() / 2; p++) {
			if ((abts[2 * p] >= '0') && (abts[2 * p] <= '9')) {
				j = abts[2 * p] - '0';
			} else if ((abts[2 * p] >= 'a') && (abts[2 * p] <= 'z')) {
				j = abts[2 * p] - 'a' + 0x0a;
			} else {
				j = abts[2 * p] - 'A' + 0x0a;
			}
			if ((abts[2 * p + 1] >= '0') && (abts[2 * p + 1] <= '9')) {
				k = abts[2 * p + 1] - '0';
			} else if ((abts[2 * p + 1] >= 'a') && (abts[2 * p + 1] <= 'z')) {
				k = abts[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abts[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbts[p] = b;
		}
		return bbts;
	}

	/**
	 * 去除字符串右侧空格
	 * 
	 * @param value
	 *            目标字符串
	 * @return 去除空格后的字符串
	 */
	public static String RightTrim(String value) {
		if (value == null || value.trim().length() == 0)
			return null;
		if (value.trim().length() == value.length())
			return value;
		if (!value.startsWith(" ")) {
			return value.trim();
		} else {
			return value.substring(0,
					value.indexOf(value.trim().substring(0, 1))
							+ value.trim().length());
		}
	}

	/**
	 * 去除字符串左侧空格
	 * 
	 * @param value
	 *            目标字符串
	 * @return 去除空格后的字符串
	 */
	public static String LeftTrim(String value) {
		if (value == null || value.trim().length() == 0)
			return null;
		if (value.trim().length() == value.length())
			return value;
		if (!value.startsWith(" ")) {
			return value;
		} else {
			return value.substring(value.indexOf(value.trim().substring(0, 1)));
		}

	}

	/**
	 * 从byte数组中指定偏移量修改一字节byte
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            修改的数值
	 * @param offset
	 *            修改的偏移量
	 */
	public static void ModifyByte(byte[] bytes, byte value, int offset) {
		if (bytes.length > offset) {
			bytes[offset] = value;
		}
	}

	/**
	 * 从byte数组中指定偏移量修改两字节word
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            修改的数值
	 * @param offset
	 *            修改的偏移量
	 * @param endian
	 *            大小端
	 */
	public static void ModifyWord(byte[] bytes, short value, int offset,
			Endianness endian) {
		if (bytes.length > offset + 1) {
			if (endian == Endianness.BigEndian) {
				bytes[offset + 0] = (byte) (value >> 8);
				bytes[offset + 1] = (byte) (value >> 0);
			} else {
				bytes[offset + 0] = (byte) (value >> 0);
				bytes[offset + 1] = (byte) (value >> 8);
			}
		}
	}

	/**
	 * 从byte数组中指定偏移量修改四字节int
	 * 
	 * @param bytes
	 *            目标数组
	 * @param value
	 *            修改的数值
	 * @param offset
	 *            修改的偏移量
	 * @param endian
	 *            大小端
	 */
	public static void ModifyInteger(byte[] bytes, int value, int offset,
			Endianness endian) {
		if (bytes.length > offset + 3) {
			if (endian == Endianness.BigEndian) {
				bytes[offset + 0] = (byte) (value >> 24);
				bytes[offset + 1] = (byte) (value >> 16);
				bytes[offset + 2] = (byte) (value >> 8);
				bytes[offset + 3] = (byte) (value >> 0);
			} else {
				bytes[offset + 0] = (byte) (value >> 0);
				bytes[offset + 1] = (byte) (value >> 8);
				bytes[offset + 2] = (byte) (value >> 16);
				bytes[offset + 3] = (byte) (value >> 24);
			}
		}
	}

	/**
	 * 为数组追加指定字节的指定内容
	 * 
	 * @param bytes
	 *            目标数组
	 * @param len
	 *            追加长度
	 * @param fill
	 *            追加的一字节内容
	 * @return 追加后的数组
	 */
	public static byte[] FillZero(byte[] bytes, int len, byte fill) {
		byte[] abts = new byte[len];
		for (int i = 0; i < abts.length; i++) {
			abts[i] = fill;
		}
		return AppendBytes(bytes, abts);
	}

	/**
	 * 为数组追加指定字节的0x00
	 * 
	 * @param bytes
	 *            目标数组
	 * @param len
	 *            追加长度
	 * @return 追加后的数组
	 */
	public static byte[] FillZero(byte[] bytes, int len) {
		return FillZero(bytes, len, (byte) 0x00);
	}

	/**
	 * 获取指定长度len并且全部填充一字节fill的数组
	 * 
	 * @param len
	 *            指定长度
	 * @param fill
	 *            一字节填充内容
	 * @return 结果数组
	 */
	public static byte[] GetBytes(int len, byte fill) {
		byte[] abts = new byte[len];
		for (int i = 0; i < abts.length; i++) {
			abts[i] = fill;
		}
		return abts;
	}

	/**
	 * 从byte数组中读取四字节数字(int)并转换为四字节HEX
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static String ReadIntegerAsHex(byte[] bytes, MsgOffset offset,
			Endianness endian) {
		String hex = "";
		int temp = offset.GetOffset();
		if (endian == Endianness.BigEndian) {
			hex = String.format("%02x%02x%02x%02x", bytes[temp + 0],
					bytes[temp + 1], bytes[temp + 2], bytes[temp + 3]);
		} else {
			hex = String.format("%02x%02x%02x%02x", bytes[temp + 3],
					bytes[temp + 2], bytes[temp + 1], bytes[temp + 0]);
		}
		offset.IncOffset(4);
		return hex.toUpperCase();
	}

	/**
	 * 从byte数组中读取四字节数字(int)并转换为四字节HEX
	 * 
	 * @param bytes
	 *            目标数组
	 * @param offset
	 *            读取的偏移量
	 * @param endian
	 *            大小端模式
	 * @return 读取结果
	 */
	public static String ReadIntegerAsHex(byte[] bytes, int offset,
			Endianness endian) {
		MsgOffset temp = new MsgOffset(offset);
		return ReadIntegerAsHex(bytes, temp, endian);
	}

	/**
	 * 获取 指定长度len并且全部填充0x00的数组
	 * 
	 * @param len
	 *            指定长度
	 * @return 结果数组
	 */
	public static byte[] GetBytes(int len) {
		return GetBytes(len, (byte) 0x00);
	}

	public static void TestOffset(MsgOffset i) {
		i.IncOffset(5);
	}

	public static byte[] Test(byte[] bytes) {
		bytes[0] = 1;
		return null;
	}

}
