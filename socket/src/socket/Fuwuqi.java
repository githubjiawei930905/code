package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Fuwuqi {

	public static void main(String[] args) {
	
		
		Socket socket=null;
		  //BufferedReader br=null;
		  PrintWriter pw=null;
		  try {
			  System.out.println("等待连接。。。。");
		   //创建服务器,并开放3081端口
		   ServerSocket server=new ServerSocket(8885);
		   while(true){
		    
			
		    //监听服务器端口，一旦有数据发送过来，那么就将数据封装成socket对象
		    //如果没有数据发送过来，那么这时处于线程阻塞状态，不会向下继续执行
		    socket=server.accept();
		    System.out.println("客户端信息："+socket.getRemoteSocketAddress());
		    //从socket中得到读取流，该流中有客户端发送过来的数据
		    //InputStream in=socket.getInputStream();
		    //InputStreamReader将字节流转化为字符流
		  //  br=new BufferedReader(new InputStreamReader(in));
		    //行读取客户端数据
		  //  String info=br.readLine();
		    //System.out.println(info);
		    
		    
		    OutputStream out=socket.getOutputStream();
		    pw=new PrintWriter(out);
		    pw.println("服务器说：我扁死你");
		    pw.print("234673264376");
		    pw.flush();
		   }
		   
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally{
		   
		   try {
		    pw.close();
		   // br.close();
		    socket.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
	
	}
}
