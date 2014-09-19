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
	public static String shp_id="三八店";
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

	//	测试成功 能够打印    打印格式可以参考 TicketTest。java
	//	这里只是写一个java实现打印小票最基本的功能：（记住：每一行不能有太长的数据,否则要超出边界）
	/**
	* 　　* @param Graphic指明打印的图形环境 　　* @param
	* PageFormat指明打印页格式（页面大小以点为计量单位，1点为1英寸的1/72，1英寸为25.4毫米。A4纸大致为595×842点） 　　* @param
	* pageIndex指明页号
	**/
	public int print(Graphics gra, PageFormat pf, int pageIndex)
	    throws PrinterException {
//	   System.out.println("pageIndex=" + pageIndex);
	   
	   
	   Component c = null;
	   // print string
//	   String str = "功能测试";
	// 转换成Graphics2D
	   Graphics2D g2 = (Graphics2D) gra;
	// 设置打印颜色为黑色
	   g2.setColor(Color.red);
	   // 打印起点坐标
	   double x = pf.getImageableX();
	   double y = pf.getImageableY();
	   switch (pageIndex) {
	   case 0:
		// 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
		    // Java平台所定义的五种字体系列：Serif、SansSerif、Monospaced、Dialog 和 DialogInput
		    Font font = new Font("新宋体", Font.PLAIN, 9);
		    g2.setFont(font); // 设置字体
		    // BasicStroke bs_3=new BasicStroke(0.5f);
		    float[] dash1 = { 2.0f };
		    // 设置打印线的属性。
		    // 1.线宽 2、3、不知道，4、空白的宽度，5、虚线的宽度，6、偏移量
		    g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
		      BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
		    // g2.setStroke(bs_3);//设置线宽
		    float heigth = font.getSize2D(); // 字体高度
//		    System.out.println("x=" + x+"  y="+y);
		    // -1- 用Graphics2D直接输出
		    // 首字符的基线(右下部)位于用户空间中的 (x, y) 位置处
	    // g2.drawLine(10,10,200,300);
	    Image src = Toolkit
	      .getDefaultToolkit()
	      .getImage(
	        "E:\\zyp\\3.jpg");
//	    g2.drawImage(src, (int) x+50, (int)y, c);//x为横  y为竖
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
//		public static String shp_id="三八店";
//		public static String[] gds_name=null;
//		public static int[] gds_price=null;
	    String orderWay="";
	    if(getOrderWay==0){
	    	 orderWay="APP点餐";
	    }else{
	     orderWay="微信点餐";
	    }
	    g2.drawString("吉祥馄饨（三八店）", (float) 70,(float) y+1* heigth ); 
	    g2.drawString("订餐方式："+orderWay+"       订单号："+orderCode, (float) x, (float) y + 2* heigth); //第一排
	    g2.drawString("时间："+orderTime, (float) x, (float) y + 3 * heigth); //第一排
	    g2.drawLine((int) x,
    			(int) (y + 3* heigth  + 10),
    			(int) x + 200, 
    			(int) (y + 3* heigth  + 10));
	    g2.drawString("餐单", (float) x, (float) y + 4 * heigth ); //第二排
	    g2.drawString("单价", (float) x+80, (float) y + 4 * heigth ); //第二排第二列
	    g2.drawString("数量", (float) x+120, (float) y + 4 * heigth ); //第二排第三列
	    g2.drawString("金额", (float) x+170, (float) y + 4* heigth ); //第二排第四列
	    System.out.println("种类="+goodlist.size());
	    int i=0;
	    for(GoodsBean tmp3:goodlist){
			String gds_name=tmp3.getGds_name();
			int gds_price=tmp3.getGds_price();
			int number=tmp3.getNumber();
			int goodtotal=number*gds_price;
			System.out.println("名称="+gds_name);
			System.out.println("单价="+gds_price);
			System.out.println("份数="+number);
			
			g2.drawString(gds_name, (float) x, (float) y + 5* heigth  + i*heigth); //第二排
		    g2.drawString(String.valueOf(gds_price), (float) x+80, (float) y + 5 * heigth  + i*heigth); //第二排第二列
		    g2.drawString(String.valueOf(number), (float) x+120, (float) y + 5 * heigth  + i*heigth); //第二排第三列
		    g2.drawString(String.valueOf(goodtotal), (float) x+170, (float) y + 5 * heigth  + i*heigth); //第二排第四列
		    
//			g2.drawString("1", (float) x, (float) y + 6* heigth + img_Height + i*heigth); //第二排
//		    g2.drawString(String.valueOf(gds_price), (float) x+80, (float) y + 6 * heigth + img_Height + i*heigth); //第二排第二列
//		    g2.drawString(String.valueOf(number), (float) x+120, (float) y + 6 * heigth + img_Height + i*heigth); //第二排第三列
//		    g2.drawString(String.valueOf(goodtotal), (float) x+170, (float) y + 6 * heigth + img_Height + i*heigth); //第二排第四列
		    i++;
	    }
	    g2.drawString("数量合计："+totalPrice+"元", (float) 150, (float) y + 5* heigth  + i*heigth); 
	    g2.drawLine((int) x,
    			(int) (y + 6* heigth  + i*heigth),
    			(int) x + 200, 
    			(int) (y + 6* heigth  + i*heigth));
	    
	    g2.drawString("顾客电话："+buyerTel, (float) 15, (float) y + 7 * heigth  + i*heigth); 
	    g2.drawString("地址:"+toAddress, (float) 15, (float) y + 8 * heigth  + i*heigth); 
	    if(remark==""&&remark==null){
	    	remark=" ";
	    }
	    g2.drawString("留言:"+remark, (float) 15, (float) y + 9 * heigth  + i*heigth); 
	    g2.drawString("微信、APP订餐   疯狂内测中。。。", (float) 50, (float) y + 11* heigth  + i*heigth); 
	    g2.drawString("外送电话：(0411)82727867", (float) 50, (float) y + 12* heigth  + i*heigth); 
	    g2.drawString("地址：中山区五五路32号安达商务大厦后侧", (float)15, (float) y + 13* heigth  + i*heigth); 
	    g2.drawString("(民功街北斗街路口，灵芝妹子旁)", (float)45, (float) y + 14* heigth  + i*heigth);
	    g2.drawImage(src, (int) x+55, (int) ((float) y + 15* heigth  + i*heigth), c);//x为横  y为竖
	    g2.drawString("扫一扫  有惊喜！！！", (float) 70,(float) y + 16* heigth + img_Height + i*heigth);
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
		   // 通俗理解就是书、文档
		   Book book = new Book();
		   // 设置成竖打
		   PageFormat pf = new PageFormat();
		   pf.setOrientation(PageFormat.PORTRAIT); // LANDSCAPE表示竖打;PORTRAIT表示横打;REVERSE_LANDSCAPE表示打印空白
		   // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
		   Paper p = new Paper();
		   p.setSize(590, 840); // 纸张大小(590, 840)表示A4纸
		   p.setImageableArea(10, 10, 260, 343); // A4(595 X
		   // 842)设置打印区域，其实0，0应该是72，72
		   // ，因为A4纸的默认X,Y边距是72
		  
		   pf.setPaper(p);
		   // 把 PageFormat 和 Printable 添加到书中，组成一个页面
		   book.append(new Print(), pf);
		   // 获取打印服务对象
		   PrinterJob job = PrinterJob.getPrinterJob();
		   // 设置打印类
	   job.setPageable(book);
	   try {
		// 可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
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
