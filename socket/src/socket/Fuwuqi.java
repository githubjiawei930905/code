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
			  System.out.println("�ȴ����ӡ�������");
		   //����������,������3081�˿�
		   ServerSocket server=new ServerSocket(8885);
		   while(true){
		    
			
		    //�����������˿ڣ�һ�������ݷ��͹�������ô�ͽ����ݷ�װ��socket����
		    //���û�����ݷ��͹�������ô��ʱ�����߳�����״̬���������¼���ִ��
		    socket=server.accept();
		    System.out.println("�ͻ�����Ϣ��"+socket.getRemoteSocketAddress());
		    //��socket�еõ���ȡ�����������пͻ��˷��͹���������
		    //InputStream in=socket.getInputStream();
		    //InputStreamReader���ֽ���ת��Ϊ�ַ���
		  //  br=new BufferedReader(new InputStreamReader(in));
		    //�ж�ȡ�ͻ�������
		  //  String info=br.readLine();
		    //System.out.println(info);
		    
		    
		    OutputStream out=socket.getOutputStream();
		    pw=new PrintWriter(out);
		    pw.println("������˵���ұ�����");
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
