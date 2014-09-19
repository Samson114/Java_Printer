package ONE;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EscPrint {

	private boolean print(String ip, int port, String str,String code,int skip) 
			throws Exception{ 
			    Socket client=new java.net.Socket(); 
			    PrintWriter socketWriter; 
			    client.connect(new InetSocketAddress(ip,port),1000); // 创建一个 socket 
			    socketWriter = new PrintWriter(client.getOutputStream());// 创建输入输出数据流
			    /* 纵向放大一倍 */ 
			    socketWriter.write(0x1c); 
			    socketWriter.write(0x21); 
			    socketWriter.write(8); 
			    socketWriter.write(0x1b); 
			    socketWriter.write(0x21); 
			    socketWriter.write(8); 
			    socketWriter.println(str); 
			    // 打印条形码
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
			        socketWriter.println(" ");// 打印完毕自动走纸
			    } 
			    boolean result=socketWriter.checkError();
			    System.out.print("result="+result);
			    return result;
			 }
	public static void main(String[] args) {
		EscPrint esc=new EscPrint();
		try {
			boolean result=esc.print("127.0.0.1",9100, "巧富餐饮软件后厨单据", "091955826335", 2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
