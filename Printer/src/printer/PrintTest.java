package printer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintTest {

	/**zyp����   û��lpt1�ӿ�  û�в��Գɹ�
	 * ��Ǯ��ĺ���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String os = System.getProperty("os.name");
	        if(os.contains("Windows")){
	            //Windows
	            try {
	                PrintWriter pw = new PrintWriter("lpt1");
	                //��ͨ��ӡ
	                pw.write("English-Windows"+"\n");
	                pw.write("����-Windows"+"\n");
	                //��ӡ����Ǯ��ָ��
	                char[] c = {27,'p',0,60,240};
	                pw.write(c);
	                pw.write("\n");
	                pw.flush();
	            } catch (FileNotFoundException ex) {
	                Logger.getLogger(PrintTest.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }else{
	            //Linux
	            try {
	                FileOutputStream fos = new FileOutputStream("/dev/lp0");
	                //��ͨ��ӡ
	                fos.write("English-Linux\n".getBytes());
	                fos.write("����-Linux\n".getBytes("GBK"));
	                //��ӡ����Ǯ��ָ��
	                char[] c = {27,'p',0,60,240};
	                for(int i=0;i<c.length;i++){
	                    fos.write(c[i]);
	                }
	                fos.write("\n".getBytes());
	                fos.flush();
	            } catch (IOException ex) {
	                Logger.getLogger(PrintTest.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        } 
		
		
	}

}
