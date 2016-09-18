package tool;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epeibao.po.OperatingData;

public class Read {

	/**
	 * @author Administrator 读写a2a9文件的工具类
	 * 
	 */

	// static String filePathString = "D:\\wenjianA2A9\\A2";
	//static String filePathString9 = "D:\\wenjianA2A9\\A9";
	static String wfilePathString = "C:\\Users\\Admin\\Desktop\\lz";

	static String byteString = "04 75 12 00 09 20 16 07 08 16 54 10 11 11 11 03 43 30 00 62 00 04 00 75 12 00 00 75 12 00 09 00 03 00 00 00 00 00 00 00 FF FF FF FF FF FF FF FF 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 6C 20 00 00 20 16 05 28 00 56 00 00 00 00 00 05 00 10 00 75 10 00 00 00 01 19 22 0B 6A 10 27 00 00 01 02 01 00 00 00 78 05 00 00 00 00 00 00 00 00 C7 35 3A 42 00 00 56 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 54 24 00 00 20 16 05 28 01 18 00 52 0D 97 92 56 05 10 00 75 10 00 00 00 10 FE DC DD 06 F8 2A 00 00 01 01 02 00 00 00 A4 06 00 00 00 00 0D 00 00 00 C7 35 3A 42 00 01 18 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 B0 1D 00 00 20 16 05 28 01 19 00 52 0D 97 92 57 05 10 00 75 10 00 00 00 10 3E 86 47 73 54 24 00 00 01 01 03 00 00 00 A4 06 00 00 00 00 0B 00 00 00 C7 35 3A 42 00 01 19 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 C8 19 00 00 20 16 05 28 01 20 00 01 00 00 00 06 00 10 00 75 10 00 00 00 01 B2 A5 94 EA 6C 20 00 00 01 02 04 00 00 00 A4 06 00 00 00 00 03 00 00 00 C7 35 3A 42 00 01 20 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00";
	static String byteString2 = "04751200092016070816541011111103433000620004007512000075120009000300000000000000FFFFFFFFFFFFFFFF06010203040506A4060000040500006C20000020160528005600000000000500100075100000000119220B6A1027000001020100000078050000000000000000C7353A4200005600202020414231323334000000111111E60034000003000054980006010203040506A4060000040500005424000020160528011800520D979256051000751000000010FEDCDD06F82A0000010102000000A406000000000D000000C7353A4200011800202020414231323334000000111111E60034000003000054980006010203040506A406000004050000B01D000020160528011900520D9792570510007510000000103E86477354240000010103000000A406000000000B000000C7353A4200011900202020414231323334000000111111E60034000003000054980006010203040506A406000004050000C8190000201605280120000100000006001000751000000001B2A594EA6C200000010204000000A4060000000003000000C7353A4200012000202020414231323334000000111111E600340000030000549800";

	public String readMethod2(String filePathString2) {
		int sum;
		String str = null;
		int total = 0;
		try {
			byte b[] = new byte[1024 * 1024];
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filePathString2)));
			while ((sum = in.read(b, 0, b.length)) != -1) {
				in.read(b);
				total += sum;
			}
			// System.out.println(total);
			byte b2[] = Arrays.copyOf(b, total);
			// str=BytesUtils.BytesToHex(b2);
			str = (String) BytesUtils.BytesToHex(b2).replace(" ", "");
			System.out.println(BytesUtils.BytesToHex(b2));
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public String readMethod9(String filePathString9) {
		int sum;
		String str = null;
		int total = 0;
		try {
			byte b[] = new byte[1024 * 1024];
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filePathString9)));
			while ((sum = in.read(b, 0, b.length)) != -1) {
				in.read(b);
				total += sum;
			}
			// System.out.println(total);
			byte b2[] = Arrays.copyOf(b, total);
			// str=BytesUtils.BytesToHex(b2);
			str = (String) BytesUtils.BytesToHex(b2).replace(" ", "");
			//System.out.println(str);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 写二进制文件
	 * 
	 * @param file
	 * @throws Exception
	 */
	public void write(File file) throws Exception {
		byte b[] = new byte[0];
		b = BytesUtils.AppendBCDString(b, byteString2);
		System.out.println(BytesUtils.BytesToHex(b));

		OutputStream os = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(os);
		dos.write(b);

		dos.flush();
		os.close();
		dos.close();
	}

	/**
	 * 读二进制文件
	 * 
	 * @param fileName
	 */
	public String readFile(String fileName) {
		String str = null;
		File file = new File(fileName);
		if (file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				@SuppressWarnings("resource")
				DataInputStream dis = new DataInputStream(in);

				byte[] itemBuf = new byte[1024];
				dis.read(itemBuf, 0, 100);
				// dis.readLine();
				// System.out.println(new String(itemBuf, 0, 100));
				str = (String) BytesUtils.BytesToHex(itemBuf).replace(" ", "");
				dis.close();
				in.close();
				// System.out.println(str);
				// System.out.println(BytesUtils.BytesToHex(itemBuf).replace(" ",
				// ""));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// close
			}
		}
		return str;
	}

	/**
	 * A2集合
	 * 
	 * @return
	 */
	public List<OperatingData> readInfoA2(String filePathString2) {
		OparaDataInfo oparaDataInfo = new OparaDataInfo();
		List<OperatingData> list = new ArrayList<OperatingData>();
		String str = readMethod2(filePathString2);
		int len = str.length();
		// System.out.println(str);
		String header = str.substring(0, 96); // 包头
		String ti = str.substring(96, len);
		// 运营记录条数
		int number = 0;
		String tiaoshu = header.substring(42, 46);
		String gaoqianStr = tiaoshu.substring(2, 4) + tiaoshu.substring(0, 2);
		number = EncodingUtils.hexStringToInt(gaoqianStr);
		String[] info = new String[number];
		if ((len - 48 * 2) / number == 196) {
			for (int i = 0; i < number; i++) {
				info[i] = ti.substring(i * 196, 196 * (i + 1));
				OperatingData operatingData = new OperatingData();
				operatingData = oparaDataInfo.infoA2(info[i]);
				list.add(operatingData);
			}
		}
		return list;
	}

	/**
	 * A9集合
	 * 
	 * @return
	 */
	public List<OperatingData> readInfoA9(String filePathString9) {
		OparaDataInfo oparaDataInfo = new OparaDataInfo();
		List<OperatingData> list = new ArrayList<OperatingData>();
		String str = readMethod9(filePathString9);
		int len = str.length();
		String header = str.substring(0, 96); // 包头
		String ti = str.substring(96, len);
		// 运营记录条数
		int number = 0;
		String tiaoshu = header.substring(42, 46);
		String gaoqianStr = tiaoshu.substring(2, 4) + tiaoshu.substring(0, 2);
		number = EncodingUtils.hexStringToInt(gaoqianStr);
		String[] info = new String[number];
		if ((len - 48 * 2) / number == 120) {
			for (int i = 0; i < number; i++) {
				info[i] = ti.substring(i * 120, 120 * (i + 1));
				OperatingData operatingData = new OperatingData();
				operatingData = oparaDataInfo.infoA9(info[i]);
				list.add(operatingData);
			}
		}
		return list;
	}

}
