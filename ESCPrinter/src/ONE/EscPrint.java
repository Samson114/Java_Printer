package ONE;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EscPrint {

	private boolean print(String ip, int port, String str,String code,int skip) 
			throws Exception{ 
			    Socket client=new java.net.Socket(); 
			    PrintWriter socketWriter; 
			    client.connect(new InetSocketAddress(ip,port),1000); // ����һ�� socket 
			    socketWriter = new PrintWriter(client.getOutputStream());// �����������������
			    /* ����Ŵ�һ�� */ 
			    socketWriter.write(0x1c); 
			    socketWriter.write(0x21); 
			    socketWriter.write(8); 
			    socketWriter.write(0x1b); 
			    socketWriter.write(0x21); 
			    socketWriter.write(8); 
			    socketWriter.println(str); 
			    // ��ӡ������
			    socketWriter.write(0x1d); 
			    socketWriter.write(0x68); 
			    socketWriter.write(120); 
			    socketWriter.write(0x1d); 
			    socketWriter.write(0x48); 
			    socketWriter.write(0x01); 
			    socketWriter.write(0x1d); 
			    socketWriter.write(0x6B); 
			    socketWriter.write(0x02); 
			    socketWriter.println(code); 
			    socketWriter.write(0x00); 
			    for(int i=0;i<skip;i++){ 
			        socketWriter.println(" ");// ��ӡ����Զ���ֽ
			    } 
			    boolean result=socketWriter.checkError();
			    System.out.print("result="+result);
			    return result;
			 }
	public static void main(String[] args) {
		EscPrint esc=new EscPrint();
		try {
			boolean result=esc.print("127.0.0.1",9100, "�ɸ���������������", "091955826335", 2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
