package printer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class TestPrint implements Printable {

	
//	���Գɹ� �ܹ���ӡ    ��ӡ��ʽ���Բο� TicketTest��java
	
//	����ֻ��дһ��javaʵ�ִ�ӡСƱ������Ĺ��ܣ�����ס��ÿһ�в�����̫��������,����Ҫ�����߽磩
	/**
	* ����* @param Graphicָ����ӡ��ͼ�λ��� ����* @param
	* PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ���1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��842�㣩 ����* @param
	* pageIndexָ��ҳ��
	**/
	public int print(Graphics gra, PageFormat pf, int pageIndex)
	    throws PrinterException {
	   System.out.println("pageIndex=" + pageIndex);
	   Component c = null;
	   // print string
	   String str = "���ܲ���";
	   // ת����Graphics2D
	   Graphics2D g2 = (Graphics2D) gra;
	   // ���ô�ӡ��ɫΪ��ɫ
	   g2.setColor(Color.red);
	   // ��ӡ�������
	   double x = pf.getImageableX();
	   double y = pf.getImageableY();
	   switch (pageIndex) {
	   case 0:
	    // ���ô�ӡ���壨�������ơ���ʽ�͵��С�����������ƿ�������������߼����ƣ�
	    // Javaƽ̨���������������ϵ�У�Serif��SansSerif��Monospaced��Dialog �� DialogInput
	    Font font = new Font("������", Font.PLAIN, 9);
	    g2.setFont(font); // ��������
	    // BasicStroke bs_3=new BasicStroke(0.5f);
	    float[] dash1 = { 2.0f };
	    // ���ô�ӡ�ߵ����ԡ�
	    // 1.�߿� 2��3����֪����4���հ׵Ŀ�ȣ�5�����ߵĿ�ȣ�6��ƫ����
	    g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
	      BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
	    // g2.setStroke(bs_3);//�����߿�
	    float heigth = font.getSize2D(); // ����߶�
	    System.out.println("x=" + x);
	    // -1- ��Graphics2Dֱ�����
	    // ���ַ��Ļ���(���²�)λ���û��ռ��е� (x, y) λ�ô�
	    // g2.drawLine(10,10,200,300);
	    Image src = Toolkit
	      .getDefaultToolkit()
	      .getImage(
	        "D:\\Aotori\\javaPic.jpg");
	    g2.drawImage(src, (int) x, (int) y, c);
	    int img_Height = src.getHeight(c);
	    int img_width = src.getWidth(c);
	    //System.out.println("img_Height="+img_Height+"img_width="+img_width
	    // ) ;
	    g2.drawString(str, (float) x, (float) y + 1 * heigth + img_Height); //��һ��
	    g2.drawString("oooooooooooo", (float) 50, (float) 60 + 1 * heigth + img_Height); //�ڶ���
	    g2.drawString("22222222222ddddddddddddddddddddddddddd222222222222", (float) 80, (float) 90 + 1 * heigth + img_Height); //������
	    g2.drawLine((int) x, (int) (y + 1 * heigth + img_Height + 10),
	      (int) x + 200, (int) (y + 1 * heigth + img_Height + 10));
	    g2.drawImage(src, (int) x,
	      (int) (y + 1 * heigth + img_Height + 11), c);
	    return PAGE_EXISTS;
	   default:
	    return NO_SUCH_PAGE;
	   }
	}

	public static void test() {
		PrintService[    ] services = PrintServiceLookup.lookupPrintServices(null, null);    
		for (int i = 0; i < services.length; i++) {    
		           ;
		 System.out.println("��ӡ���б�="+services[i].getName());    
		} 
		
	   //ReadData();
	   // ͨ���������顢�ĵ�
	   Book book = new Book();
	   // ���ó�����
	   PageFormat pf = new PageFormat();
	   pf.setOrientation(PageFormat.PORTRAIT); // LANDSCAPE��ʾ����;PORTRAIT��ʾ���;REVERSE_LANDSCAPE��ʾ��ӡ�հ�
	   // ͨ��Paper����ҳ��Ŀհױ߾�Ϳɴ�ӡ���򡣱�����ʵ�ʴ�ӡֽ�Ŵ�С�����
	   Paper p = new Paper();
	   p.setSize(590, 840); // ֽ�Ŵ�С(590, 840)��ʾA4ֽ
	   p.setImageableArea(10, 10, 260, 343); // A4(595 X
	   // 842)���ô�ӡ������ʵ0��0Ӧ����72��72
	   // ����ΪA4ֽ��Ĭ��X,Y�߾���72
	  
	   pf.setPaper(p);
	   // �� PageFormat �� Printable ��ӵ����У����һ��ҳ��
	   book.append(new TestPrint(), pf);
	   // ��ȡ��ӡ�������
	   PrinterJob job = PrinterJob.getPrinterJob();
	   // ���ô�ӡ��
	   job.setPageable(book);
	   
	   try {
	    // ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
		   
	    boolean a=job.printDialog();
	    if(a)
	    {
	     job.print();
	    }
	   } catch (PrinterException e) {
	    e.printStackTrace();
	   }
	}

	public static void main(String[] args) {
		TestPrint testPrint = new TestPrint();
		testPrint.test();
	}
	
}

	
	

