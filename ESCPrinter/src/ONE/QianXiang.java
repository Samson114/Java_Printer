package ONE;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QianXiang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String os = System.getProperty("os.name"); 

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
              Logger.getLogger(QianXiang.class.getName()).log(Level.SEVERE, null, ex); 
          } 

	}

}
