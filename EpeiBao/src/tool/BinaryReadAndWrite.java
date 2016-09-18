package tool;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class BinaryReadAndWrite {

	/**
	 * @author Administrator 读写a2a9文件的工具类
	 * 
	 */

	static String filePathString = "C:\\Users\\Admin\\Desktop\\75120009201607141644341111114614A2";
	static String wfilePathString = "C:\\Users\\Admin\\Desktop\\A9";

	static String byteString = "04 75 12 00 09 20 16 07 08 16 54 10 11 11 11 03 43 30 00 62 00 04 00 75 12 00 00 75 12 00 09 00 03 00 00 00 00 00 00 00 FF FF FF FF FF FF FF FF 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 6C 20 00 00 20 16 05 28 00 56 00 00 00 00 00 05 00 10 00 75 10 00 00 00 01 19 22 0B 6A 10 27 00 00 01 02 01 00 00 00 78 05 00 00 00 00 00 00 00 00 C7 35 3A 42 00 00 56 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 54 24 00 00 20 16 05 28 01 18 00 52 0D 97 92 56 05 10 00 75 10 00 00 00 10 FE DC DD 06 F8 2A 00 00 01 01 02 00 00 00 A4 06 00 00 00 00 0D 00 00 00 C7 35 3A 42 00 01 18 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 B0 1D 00 00 20 16 05 28 01 19 00 52 0D 97 92 57 05 10 00 75 10 00 00 00 10 3E 86 47 73 54 24 00 00 01 01 03 00 00 00 A4 06 00 00 00 00 0B 00 00 00 C7 35 3A 42 00 01 19 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00 06 01 02 03 04 05 06 A4 06 00 00 04 05 00 00 C8 19 00 00 20 16 05 28 01 20 00 01 00 00 00 06 00 10 00 75 10 00 00 00 01 B2 A5 94 EA 6C 20 00 00 01 02 04 00 00 00 A4 06 00 00 00 00 03 00 00 00 C7 35 3A 42 00 01 20 00 20 20 20 41 42 31 32 33 34 00 00 00 11 11 11 E6 00 34 00 00 03 00 00 54 98 00";
	static String byteString2 = "04751200092016070816541011111103433000620004007512000075120009000300000000000000FFFFFFFFFFFFFFFF06010203040506A4060000040500006C20000020160528005600000000000500100075100000000119220B6A1027000001020100000078050000000000000000C7353A4200005600202020414231323334000000111111E60034000003000054980006010203040506A4060000040500005424000020160528011800520D979256051000751000000010FEDCDD06F82A0000010102000000A406000000000D000000C7353A4200011800202020414231323334000000111111E60034000003000054980006010203040506A406000004050000B01D000020160528011900520D9792570510007510000000103E86477354240000010103000000A406000000000B000000C7353A4200011900202020414231323334000000111111E60034000003000054980006010203040506A406000004050000C8190000201605280120000100000006001000751000000001B2A594EA6C200000010204000000A4060000000003000000C7353A4200012000202020414231323334000000111111E600340000030000549800";
	static String byteString3 = "047512000920160714164434111111461430003C0001007510000075120001000300FFFFFFFFFFFFFFFFFFFFFFFFFFFF09A40600002016052801180001000000A406000000000A000000C7353A4200011800202020414231323334000000111111E600340000030000549800";

	public static void main(String[] args) {

		readFile(wfilePathString);

		// File file = new File(wfilePathString);
		// if (!file.exists()) {
		// try {
		// file.createNewFile();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// try {
		// write(file);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	/**
	 * 写二进制文件
	 * 
	 * @param file
	 * @throws Exception
	 */
	public static void write(File file) throws Exception {
		byte b[] = new byte[0];
		b = BytesUtils.AppendBCDString(b, byteString3);
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
	public static void readFile(String fileName) {
		int sum;
		int totalLen = 0;

		File file = new File(fileName);
		if (file.exists()) {
			try {
				FileInputStream in = new FileInputStream(file);
				@SuppressWarnings("resource")
				DataInputStream dis = new DataInputStream(
						new BufferedInputStream(in));

				byte[] itemBuf = new byte[1024 * 1024];
				while ((sum = dis.read(itemBuf, 0, itemBuf.length)) != -1) {
					dis.read(itemBuf, 0, itemBuf.length);
					totalLen += sum;
				}
				byte b[] = Arrays.copyOf(itemBuf, totalLen);
				// dis.readLine();
				// System.out.println(new String(itemBuf, 0, 100));

				//System.out.println(BytesUtils.BytesToHex(b));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// close
			}
		}
	}
}
