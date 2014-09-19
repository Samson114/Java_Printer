package ONE;

import print.Print;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import TWO.PrintClass;
import bean.GoodsBean;
import bean.OrderInfo;

public class MM  extends JFrame implements ActionListener{
		
		 private JLabel lblUsername;
		 private JLabel lblPassword;
		 private JTextField tfUsername;
		 private JPasswordField tfPassword;
		 private JButton btnOK;
		 private JButton btnExit;
		 /*
		  * ���캯��
		  */
		 public MM() {
			 System.out.println("������⽴�ӡ��(���˵�)");
			  JPanel p1 = new JPanel();
			  p1.setLayout(new BorderLayout());
			  lblUsername = new JLabel("�û���:");
			  tfUsername = new JTextField(12);
			  p1.add(lblUsername, BorderLayout.WEST);
			  p1.add(tfUsername, BorderLayout.EAST);
			  
			  JPanel p2 = new JPanel();
			  p2.setLayout(new BorderLayout());
			  lblPassword = new JLabel("����:");
			  tfPassword = new JPasswordField(12);
			  p2.add(lblPassword, BorderLayout.WEST);
			  p2.add(tfPassword, BorderLayout.EAST);
			  
			  JPanel p3 = new JPanel();
			  btnOK = new JButton("����");
			  btnOK.addActionListener(this);
			  btnExit = new JButton("�˳�");
			  btnExit.addActionListener(this);
			  //��ť
			  p3.add(btnOK);
			  p3.add(btnExit);
			  
			  this.add(p1, BorderLayout.NORTH);
			  this.add(p2, BorderLayout.CENTER);
			  this.add(p3, BorderLayout.SOUTH);
			  
			  //Ӧ�ó���Ĵ�С��λ��
			  this.setLocation(400, 300);
			  this.setSize(330, 120);
			  this.setTitle("������⽴�ӡ��(���˵�)");
			  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  this.setVisible(true);
			  
		 }
		 /*
		  * ��ť������
		  * ����
		  * �˳�
		  * (non-Javadoc)
		  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		  */
	 public void actionPerformed(ActionEvent e) {
		 
	  if (e.getActionCommand().equals("����")) {
		  System.out.println("����");
//	   JOptionPane.showMessageDialog(this, "�����û���Ϊ" + tfUsername.getText() + "n" + "�������Ϊ" + String.valueOf(tfPassword.getText()));
		 char[] password= tfPassword.getPassword();
	 	String s1 = new String(password);  
        String s2 = String.valueOf(password); 
		  if(tfUsername.getText().equals("0000")&&s2.equals("0000"))
		  { JOptionPane.showMessageDialog(this, "ȷ���򿪣�");
		    PrintClass pc=new PrintClass();
		    pc.MMClass();
		  }else{
			  JOptionPane.showMessageDialog(this, "�û������������");  
		  }
	   
	  } else if(e.getActionCommand().equals("�˳�")) {
		 System.out.println("�˳�");
	   System.exit(0);
	   
	  }
	  
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 new MM();
		
	}

}
