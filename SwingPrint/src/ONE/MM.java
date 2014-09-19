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
		  * 构造函数
		  */
		 public MM() {
			 System.out.println("吉祥馄饨打印机(三八店)");
			  JPanel p1 = new JPanel();
			  p1.setLayout(new BorderLayout());
			  lblUsername = new JLabel("用户名:");
			  tfUsername = new JTextField(12);
			  p1.add(lblUsername, BorderLayout.WEST);
			  p1.add(tfUsername, BorderLayout.EAST);
			  
			  JPanel p2 = new JPanel();
			  p2.setLayout(new BorderLayout());
			  lblPassword = new JLabel("密码:");
			  tfPassword = new JPasswordField(12);
			  p2.add(lblPassword, BorderLayout.WEST);
			  p2.add(tfPassword, BorderLayout.EAST);
			  
			  JPanel p3 = new JPanel();
			  btnOK = new JButton("开启");
			  btnOK.addActionListener(this);
			  btnExit = new JButton("退出");
			  btnExit.addActionListener(this);
			  //按钮
			  p3.add(btnOK);
			  p3.add(btnExit);
			  
			  this.add(p1, BorderLayout.NORTH);
			  this.add(p2, BorderLayout.CENTER);
			  this.add(p3, BorderLayout.SOUTH);
			  
			  //应用程序的大小、位置
			  this.setLocation(400, 300);
			  this.setSize(330, 120);
			  this.setTitle("吉祥馄饨打印机(三八店)");
			  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  this.setVisible(true);
			  
		 }
		 /*
		  * 按钮监听器
		  * 开启
		  * 退出
		  * (non-Javadoc)
		  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		  */
	 public void actionPerformed(ActionEvent e) {
		 
	  if (e.getActionCommand().equals("开启")) {
		  System.out.println("开启");
//	   JOptionPane.showMessageDialog(this, "您的用户名为" + tfUsername.getText() + "n" + "你的密码为" + String.valueOf(tfPassword.getText()));
		 char[] password= tfPassword.getPassword();
	 	String s1 = new String(password);  
        String s2 = String.valueOf(password); 
		  if(tfUsername.getText().equals("0000")&&s2.equals("0000"))
		  { JOptionPane.showMessageDialog(this, "确定打开？");
		    PrintClass pc=new PrintClass();
		    pc.MMClass();
		  }else{
			  JOptionPane.showMessageDialog(this, "用户名或密码错误");  
		  }
	   
	  } else if(e.getActionCommand().equals("退出")) {
		 System.out.println("退出");
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
