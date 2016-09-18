package socket;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class Kehuduan {

	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",4701);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
