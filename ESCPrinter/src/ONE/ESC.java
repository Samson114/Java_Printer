package ONE;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ESC {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket client=new java.net.Socket(); 
		PrintWriter socketWriter; 
		try {
			//����Ҫ�����ڴ�ӡ����һ�� IP ��ַ��������� 192.168.0.18 ��
			client.connect(new InetSocketAddress("192.168.123.99" , 9100),1000);
			// �����������������
			socketWriter = new PrintWriter(client.getOutputStream());
			//���ӽ�����ϣ�д�����ݾͷǳ����ף�ֻҪʹ�� write ���� println ����д�뼴�ɣ�
			//���� write ������д�����ֻ��ַ���println д��һ���ַ�����
			socketWriter.write(0); 
			//д��һ���ַ���
			socketWriter.println("�ɸ���������������");
			//����һ���ַ��� 
			socketWriter.println("��λ 14 �������� 3");
			//�Ŵ�������Ҫ�õ��������� 0x1c ָ�ʹ�ð�����ָ��ķ����ܼ򵥣�ֻҪ��˿�д��ָ��ɣ�����
			socketWriter.write(0x1c);
			/*ע�� 0x1c���� 16 ���Ƶ����֣���ȻҲ����ת���� 10 ������д��
			 * ��Ҫ˵�����ǣ�ʹ�ð�����ָ��Ŵ����岻������Ŵ���Ϊ������ͼ�λ���ӡ�������ı�����ӡ��
			 * ����������ߺ���ֻ�ܰ��ձ����Ŵ󣬲���ʸ���Ŵ������� POS58 ��ӡ���Ͻ����ɸ���������������ַŴ��ӡ��
			 * ���������·Ŵ󷽷���
			 * һ������£����������������Ŵ�һ���ķ������Ŵ������忴�����е�������壬�Ӿ�Ч��������
			 */
			/* ����Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			/* ����Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			/* �������򶼷Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(12);
			
			
			/*
			 * ����֪����ʹ�ð�����ָ��ķ���������ֻҪ��һ��������ָ���ֲ������
			 * �Ϳ����� Java ���ƴ�ӡ������������ӡ���������������ǣ�ͬ���ǰ�����ָ�
			 * ��ͬ�� pos ��ӡ�����ܲ�һ�������÷Ŵ�������˵��pos58 ��ӡ���� pos80 ��ӡ��ָ��Ͳ�����ͬ��
			 * ��ʱ����ô���أ���μ��ݶ������ʹ�ӡ����
			 * ����˵���еĴ�ӡ��������ʹ�� 0x1c ��Ϊ�Ŵ�ָ�����ʹ�� 0x1b ��Ϊ�Ŵ�ָ���ô�죿���ס�
			 * 
			 * ���������𣿾���д������У���Ϊ��� 0x1b ָ���������ڣ���ӡ���Զ�����������
			 */
			/* ����Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			/* ����Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			/* �������򶼷Ŵ�һ�� */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(12); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(12);
			
			
			
			/*
			 * �������ڸ�����ҵ�������й㷺��Ӧ�ã������ô�ӡ����ӡ�������Ƿǳ���Ҫ�Ĺ��ܣ�
			 * �����㲻��Ҫ�Ѻöྫ��ȥ�о�������֪ʶ����Ϊ������ָ������һ����ӡ������ָ��
			 * ����������Ҫ��ӡ�����롰 091955826335 ����ֻҪʹ����������ɡ�
			 */
			socketWriter.write(0x1d); 
			socketWriter.write(0x68); 
			socketWriter.write(120); 
			socketWriter.write(0x1d); 
			socketWriter.write(0x48); 
			socketWriter.write(0x01); 
			socketWriter.write(0x1d); 
			socketWriter.write(0x6B); 
			socketWriter.write(0x02); 
			socketWriter.println ("091955826335" ); 
			socketWriter.write(0x00);
			
			/*
			 * POS ��ӡ����Ϊ��ֽ����һЩ��ȣ���ӡ���Ϊ�˱���˺���������ݣ�
			 * һ����Ҫ�ʵ���ֽ���У���Ȼ����ʹ�ð�����ָ������ֽ�����������������ף�Ϊʲô�� ?
			 *  ��ΪҪ���� POS ���ļ����ԣ�����һ����ô�ӡ���еķ�ʽʵ����ֽ��
			 */
			for(int i=0;i<10;i++){ 
			    socketWriter.println(" ");// ��ӡ����Զ���ֽ
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ����һ�� socket 
		
		
	}

}
