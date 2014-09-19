package printer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TicketTest extends JFrame implements ActionListener {
//δ���Գɹ�  
	private static final long serialVersionUID = 1L;
	int PAGES = 1;
	private String printStr = null;
	private int printFlag = -1;
	public JFrame mainFrame = new JFrame();
	public JTextArea area = null;
	private JButton print = new JButton();
	private JScrollPane scrollPane;
	private JPanel btnPanel = new JPanel();

	public TicketTest() {
		Container contentPane = mainFrame.getContentPane();
		mainFrame.setSize(new Dimension(400, 300));
		mainFrame.setTitle("Print   example ");
		area = new JTextArea(30, 30);
		String str = getStr();
		area.setText(str);
		scrollPane = new JScrollPane(area);
		print = new JButton("Print");
		print.addActionListener(this);
		btnPanel.add(print);
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		contentPane.add(area, BorderLayout.CENTER);
		mainFrame.pack();
		mainFrame.show();
	}

	public String getStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ�´ι���");
		sb.append("\r\n--------------------------------\r\n");
		sb.append("����:" + new Date());
		sb.append("\r\n��Ʒ����    ����  ����   ��С��");
		sb.append("\r\n--------------------------------\r\n");
		return sb.toString();
	}

	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {

		Graphics2D g2 = (Graphics2D) g;
		System.out.print("a");
		g2.setPaint(Color.red); // ���ô�ӡ��ɫΪ��ɫ
		if (page >= PAGES) // ����ӡҳ�Ŵ�����Ҫ��ӡ����ҳ��ʱ����ӡ��������
			return Printable.NO_SUCH_PAGE;
		g2.translate(pf.getImageableX(), pf.getImageableY());// ת�����꣬ȷ����ӡ�߽�
		drawCurrentPageText(g2, pf, page); // ��ӡ��ǰҳ�ı�
		return Printable.PAGE_EXISTS; // ���ڴ�ӡҳʱ��������ӡ����
		// return 1 ;
	}

	// ��ȡ��ǰҳ�Ĵ���ӡ�ı�����
	private void drawCurrentPageText(Graphics2D g2, PageFormat pf, int page) {
		String s = getDrawText(printStr)[page];// ��ȡ��ǰҳ�Ĵ���ӡ�ı�����
		FontRenderContext context = g2.getFontRenderContext();// ��ȡĬ�����弰��Ӧ�ĳߴ�
		Font f = area.getFont();
		String drawText;
		float ascent = 16; // �����ַ�����
		int k, i = f.getSize(), lines = 0;
		while (s.length() > 0 && lines < 30) // ÿҳ�޶���54������
		{
			k = s.indexOf('\n'); // ��ȡÿһ���س�����λ��
			if (k != -1) // ���ڻس���
			{
				lines += 1; // ��������
				drawText = s.substring(0, k); // ��ȡÿһ���ı�
				g2.drawString(drawText, 0, ascent); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
				if (s.substring(k + 1).length() > 0) {
					s = s.substring(k + 1); // ��ȡ��δ��ӡ���ı�
					ascent += i;
				}
			} else // �����ڻس���
			{
				lines += 1; // ��������
				drawText = s; // ��ȡÿһ���ı�
				g2.drawString(drawText, 0, ascent); // �����ӡÿһ���ı���ͬʱ��ֽ��λ
				s = ""; // �ı��ѽ���
			}
		}
	}

	/* ����ӡĿ���ı���ҳ���Ϊ�ַ������� */
	public String[] getDrawText(String s) {
		String[] drawText = new String[PAGES];// ����ҳ����ʼ������
		for (int i = 0; i < PAGES; i++)
			drawText[i] = ""; // ����Ԫ�س�ʼ��Ϊ���ַ���

		int k, suffix = 0, lines = 0;
		while (s.length() > 0) {
			if (lines < 30) // ����һҳʱ
			{
				k = s.indexOf('\n');
				if (k != -1) // ���ڻس���
				{
					lines += 1; // �����ۼ�
					// �����ҳ�ľ����ı����ݣ���ŵ���Ӧ�±������Ԫ��
					drawText[suffix] = drawText[suffix] + s.substring(0, k + 1);
					if (s.substring(k + 1).length() > 0)
						s = s.substring(k + 1);
				} else {
					lines += 1; // �����ۼ�
					drawText[suffix] = drawText[suffix] + s; // ���ı����ݴ�ŵ���Ӧ������Ԫ��
					s = "";
				}
			} else// ����һҳʱ
			{
				lines = 0; // ����ͳ������
				suffix++; // �����±��1
			}
		}
		return drawText;
	}

	// ������Ҫ��ӡ����ҳ��
	public int getPagesCount(String curStr) {
		int page = 0;
		int position, count = 0;
		String str = curStr;
		System.out.println("1");
		while (str.length() > 0) // �ı���δ�������
		{
			System.out.println("2");
			position = str.indexOf('\n'); // ����س�����λ��
			count += 1; // ͳ������
			if (position != -1)
				str = str.substring(position + 1); // ��ȡ��δ������ı�
			else
				str = ""; // �ı��Ѽ������
		}
		if (count > 0)
			page = count / 54 + 1; // ������������54��ȡ��ҳ��
		System.out.print(page + "page");
		return page; // �������ӡ����ҳ��
	}

	public void actionPerformed(ActionEvent evt) {
		printText2Action();
	}
	
	   private void printTextAction()
	    {
	        printStr = area.getText().trim(); //��ȡ��Ҫ��ӡ��Ŀ���ı�
	        if (printStr != null && printStr.length() > 0) //����ӡ���ݲ�Ϊ��ʱ
	        {
	            PAGES = getPagesCount(printStr); //��ȡ��ӡ��ҳ��
	            PrinterJob myPrtJob = PrinterJob.getPrinterJob(); //��ȡĬ�ϴ�ӡ��ҵ
	            PageFormat pageFormat = myPrtJob.defaultPage(); //��ȡĬ�ϴ�ӡҳ���ʽ
	            myPrtJob.setPrintable((Printable) this, pageFormat); //���ô�ӡ����
	            if (myPrtJob.printDialog()) //��ʾ��ӡ�Ի���
	            {
	                try
	                {
	                    myPrtJob.print(); //����ÿһҳ�ľ����ӡ����
	                }
	                catch(PrinterException pe)
	                {
	                    pe.printStackTrace();
	                }
	            }
	        }
	        else
	        {
	            //�����ӡ����Ϊ��ʱ����ʾ�û���ӡ��ȡ��
	            JOptionPane.showConfirmDialog(null, 
	              "Sorry, Printer Job is Empty, Print Cancelled!", "Empty", 
	         JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
	        }
	    }
	// ��jdk1.4�°汾�ṩ��APIʵ�ִ�ӡ������ť����������ɾ���Ĵ�ӡ����
	private void printText2Action() {
		printFlag = 0; // ��ӡ��־����
		printStr = area.getText().trim();// ��ȡ��Ҫ��ӡ��Ŀ���ı�
		
		System.out.println("the   content   are   ::: ");
		System.out.println(printStr);

		 if (printStr != null && printStr.length() > 0) //����ӡ���ݲ�Ϊ��ʱ
		  {
		    PAGES = getPagesCount(printStr); //��ȡ��ӡ��ҳ��
		    //ָ����ӡ�����ʽ
		    DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		    //��λĬ�ϵĴ�ӡ����
		    PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
		    System.out.println("11"+printService+"----------");
		    
		    //������ӡ��ҵ
		    DocPrintJob job = printService.createPrintJob();
		    //���ô�ӡ����
		    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		    DocAttributeSet das = new HashDocAttributeSet();
		    //ָ����ӡ����
		    Doc doc = new SimpleDoc(this, flavor, das);
		    //����ʾ��ӡ�Ի���ֱ�ӽ��д�ӡ����
			try {
				job.print(doc, pras); // ����ÿһҳ�ľ����ӡ����
			} catch (PrintException pe) {
				pe.printStackTrace();
			}
		} else {
			JOptionPane
					.showConfirmDialog(
							null,
							"Sorry,   Printer   Job   is   Empty,   Print   Cancelled! ",
							"Empty ", JOptionPane.DEFAULT_OPTION,
							JOptionPane.WARNING_MESSAGE);
		}
	}

	// test
	public static void main(String[] args) {
		TicketTest test = new TicketTest();
	}

}