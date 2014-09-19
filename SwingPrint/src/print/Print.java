package print;

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
import java.util.ArrayList;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.OrientationRequested;

import bean.GoodsBean;
import bean.OrderInfo;



public class Print implements Printable{

	public static String toAddress=" ";
	public static String orderCode=" ";
	public static String orderTime=" ";
	public static int totalPrice=0;
	public static String buyerTel=" ";
	public static int count=0;
	public static String  remark=" ";
	public static String shp_id="���˵�";
	public static String gds_name=null;
	public static int gds_price=0;
	public static int size =0;
	public static int getOrderWay;
	public static ArrayList<GoodsBean> goodlist=new ArrayList<GoodsBean>(); 
	
	
	public static ArrayList<GoodsBean> getGoodlist() {
		return goodlist;
	}

	public static void setGoodlist(ArrayList<GoodsBean> goodlist) {
		Print.goodlist = goodlist;
	}

	public static String getToAddress() {
		return toAddress;
	}

	public static void setToAddress(String toAddress) {
		Print.toAddress = toAddress;
	}

	public static String getOrderCode() {
		return orderCode;
	}

	public static void setOrderCode(String orderCode) {
		Print.orderCode = orderCode;
	}

	public static String getOrderTime() {
		return orderTime;
	}

	public static void setOrderTime(String orderTime) {
		Print.orderTime = orderTime;
	}

	
	public static String getBuyerTel() {
		return buyerTel;
	}

	public static void setBuyerTel(String buyerTel) {
		Print.buyerTel = buyerTel;
	}

	public static String getRemark() {
		return remark;
	}

	public static void setRemark(String remark) {
		Print.remark = remark;
	}

	public static int getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(int totalPrice) {
		Print.totalPrice = totalPrice;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Print.count = count;
	}

	public static String getShp_id() {
		return shp_id;
	}

	public static void setShp_id(String shp_id) {
		Print.shp_id = shp_id;
	}


	public static String getGds_name() {
		return gds_name;
	}

	public static void setGds_name(String gds_name) {
		Print.gds_name = gds_name;
	}

	public static int getGds_price() {
		return gds_price;
	}

	public static void setGds_price(int gds_price) {
		Print.gds_price = gds_price;
	}
	
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		Print.size = size;
	}
	
	
	public static int getGetOrderWay() {
		return getOrderWay;
	}

	public static void setGetOrderWay(int getOrderWay) {
		Print.getOrderWay = getOrderWay;
	}

	//	���Գɹ� �ܹ���ӡ    ��ӡ��ʽ���Բο� TicketTest��java
	//	����ֻ��дһ��javaʵ�ִ�ӡСƱ������Ĺ��ܣ�����ס��ÿһ�в�����̫��������,����Ҫ�����߽磩
	/**
	* ����* @param Graphicָ����ӡ��ͼ�λ��� ����* @param
	* PageFormatָ����ӡҳ��ʽ��ҳ���С�Ե�Ϊ������λ��1��Ϊ1Ӣ���1/72��1Ӣ��Ϊ25.4���ס�A4ֽ����Ϊ595��842�㣩 ����* @param
	* pageIndexָ��ҳ��
	**/
	public int print(Graphics gra, PageFormat pf, int pageIndex)
	    throws PrinterException {
//	   System.out.println("pageIndex=" + pageIndex);
	   
	   
	   Component c = null;
	   // print string
//	   String str = "���ܲ���";
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
//		    System.out.println("x=" + x+"  y="+y);
		    // -1- ��Graphics2Dֱ�����
		    // ���ַ��Ļ���(���²�)λ���û��ռ��е� (x, y) λ�ô�
	    // g2.drawLine(10,10,200,300);
	    Image src = Toolkit
	      .getDefaultToolkit()
	      .getImage(
	        "E:\\zyp\\3.jpg");
//	    g2.drawImage(src, (int) x+50, (int)y, c);//xΪ��  yΪ��
	    int img_Height = src.getHeight(c);
	    int img_width = src.getWidth(c);
	    //System.out.println("img_Height="+img_Height+"img_width="+img_width
	    // ) ;
//	    public static String toAddress="hello world!";
//		public static String orderCode="hello world!";
//		public static String orderTime="hello world!";
//		public static int totalPrice=0;
//		public static String buyerTel="hello world!";
//		public static int count=0;
//		public static String shp_id="���˵�";
//		public static String[] gds_name=null;
//		public static int[] gds_price=null;
	    String orderWay="";
	    if(getOrderWay==0){
	    	 orderWay="APP���";
	    }else{
	     orderWay="΢�ŵ��";
	    }
	    g2.drawString("������⽣����˵꣩", (float) 70,(float) y+1* heigth ); 
	    g2.drawString("���ͷ�ʽ��"+orderWay+"       �����ţ�"+orderCode, (float) x, (float) y + 2* heigth); //��һ��
	    g2.drawString("ʱ�䣺"+orderTime, (float) x, (float) y + 3 * heigth); //��һ��
	    g2.drawLine((int) x,
    			(int) (y + 3* heigth  + 10),
    			(int) x + 200, 
    			(int) (y + 3* heigth  + 10));
	    g2.drawString("�͵�", (float) x, (float) y + 4 * heigth ); //�ڶ���
	    g2.drawString("����", (float) x+80, (float) y + 4 * heigth ); //�ڶ��ŵڶ���
	    g2.drawString("����", (float) x+120, (float) y + 4 * heigth ); //�ڶ��ŵ�����
	    g2.drawString("���", (float) x+170, (float) y + 4* heigth ); //�ڶ��ŵ�����
	    System.out.println("����="+goodlist.size());
	    int i=0;
	    for(GoodsBean tmp3:goodlist){
			String gds_name=tmp3.getGds_name();
			int gds_price=tmp3.getGds_price();
			int number=tmp3.getNumber();
			int goodtotal=number*gds_price;
			System.out.println("����="+gds_name);
			System.out.println("����="+gds_price);
			System.out.println("����="+number);
			
			g2.drawString(gds_name, (float) x, (float) y + 5* heigth  + i*heigth); //�ڶ���
		    g2.drawString(String.valueOf(gds_price), (float) x+80, (float) y + 5 * heigth  + i*heigth); //�ڶ��ŵڶ���
		    g2.drawString(String.valueOf(number), (float) x+120, (float) y + 5 * heigth  + i*heigth); //�ڶ��ŵ�����
		    g2.drawString(String.valueOf(goodtotal), (float) x+170, (float) y + 5 * heigth  + i*heigth); //�ڶ��ŵ�����
		    
//			g2.drawString("1", (float) x, (float) y + 6* heigth + img_Height + i*heigth); //�ڶ���
//		    g2.drawString(String.valueOf(gds_price), (float) x+80, (float) y + 6 * heigth + img_Height + i*heigth); //�ڶ��ŵڶ���
//		    g2.drawString(String.valueOf(number), (float) x+120, (float) y + 6 * heigth + img_Height + i*heigth); //�ڶ��ŵ�����
//		    g2.drawString(String.valueOf(goodtotal), (float) x+170, (float) y + 6 * heigth + img_Height + i*heigth); //�ڶ��ŵ�����
		    i++;
	    }
	    g2.drawString("�����ϼƣ�"+totalPrice+"Ԫ", (float) 150, (float) y + 5* heigth  + i*heigth); 
	    g2.drawLine((int) x,
    			(int) (y + 6* heigth  + i*heigth),
    			(int) x + 200, 
    			(int) (y + 6* heigth  + i*heigth));
	    
	    g2.drawString("�˿͵绰��"+buyerTel, (float) 15, (float) y + 7 * heigth  + i*heigth); 
	    g2.drawString("��ַ:"+toAddress, (float) 15, (float) y + 8 * heigth  + i*heigth); 
	    if(remark==""&&remark==null){
	    	remark=" ";
	    }
	    g2.drawString("����:"+remark, (float) 15, (float) y + 9 * heigth  + i*heigth); 
	    g2.drawString("΢�š�APP����   ����ڲ��С�����", (float) 50, (float) y + 11* heigth  + i*heigth); 
	    g2.drawString("���͵绰��(0411)82727867", (float) 50, (float) y + 12* heigth  + i*heigth); 
	    g2.drawString("��ַ����ɽ������·32�Ű���������ú��", (float)15, (float) y + 13* heigth  + i*heigth); 
	    g2.drawString("(�񹦽ֱ�����·�ڣ���֥������)", (float)45, (float) y + 14* heigth  + i*heigth);
	    g2.drawImage(src, (int) x+55, (int) ((float) y + 15* heigth  + i*heigth), c);//xΪ��  yΪ��
	    g2.drawString("ɨһɨ  �о�ϲ������", (float) 70,(float) y + 16* heigth + img_Height + i*heigth);
	    //	    g2.drawImage(src, (int) x,
//	      (int) (y + 1 * heigth + img_Height + 11), c);
	    return PAGE_EXISTS;
	   default:
	    return NO_SUCH_PAGE;
	   }
	}

	public static void test() {
		/*PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		DocFlavor flavor = DocFlavor.URL.GIF;
		if (!service.isDocFlavorSupported(flavor))
		{
		System.err.println("The printer does not support the appropriate DocFlavor");
		}*/
		
		/*AttributeSet attrs = new HashAttributeSet();
		attrs.add(ColorSupported.SUPPORTED);
		attrs.add(OrientationRequested.LANDSCAPE);*/
		
		/*PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
		for (int i = 0; i < services.length; i++)
		{
		System.out.println(services[i].getName());
		}*/
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
		   book.append(new Print(), pf);
		   // ��ȡ��ӡ�������
		   PrinterJob job = PrinterJob.getPrinterJob();
		   // ���ô�ӡ��
	   job.setPageable(book);
	   try {
		// ������printDialog��ʾ��ӡ�Ի������û�ȷ�Ϻ��ӡ��Ҳ����ֱ�Ӵ�ӡ
//	    boolean a=job.printDialog();
//	    if(a)
//	    {
	     job.print();
//	    }
	   } catch (PrinterException e) {
	    e.printStackTrace();
	   }
	}

	

}
