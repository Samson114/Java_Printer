package TWO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import print.Print;
import bean.GoodsBean;
import bean.OrderInfo;

public class PrintClass {
	
	public void MMClass(){
//	System.out.println("Printstart");
	
	 SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
     Date startDate;
		try {
			startDate = dateFormatter.parse("2014/02/12 01:06:00");
			 Timer timer = new Timer();  
		        timer.schedule(new TimerTask(){  
		           public void run() {  
		               //周期性的访问数据库start
					   Connection conn =null;
					java.sql.Statement stmt=null;
					ResultSet rs=null;
					ResultSet rs2=null;
					String url="jdbc:mysql://115.28.163.120:3306/dxedb";
					String user="root"; 
					String password="zxtclass502";
//					String buyerTel=null;
					boolean update=false;
					
					try{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						conn=DriverManager.getConnection(url,user,password);
					    stmt= conn.createStatement();//0f8ae06b2356b2397b759d7d7bf3f24c    838c186fe859008d7fc29221daeda30c
					    String sql="select id,toAddress,orderCode,orderTime,totalPrice,buyerTel,count,remark,getOrderWay from t_orders  where shp_id='838c186fe859008d7fc29221daeda30c'  and state='5'";
					    rs=stmt.executeQuery(sql);
					    ArrayList<OrderInfo> list=new ArrayList<OrderInfo>(); 
					    ArrayList<GoodsBean> goodlist=new ArrayList<GoodsBean>(); 
//		           	    	int total=st.getListTotal();
					//	rs=stmt.executeQuery("select * from student order by sno");
						while(rs.next())
					    {  
							OrderInfo st=new OrderInfo();
					    	st.setId(rs.getString("id"));
					    	st.setToAddress(rs.getString("toAddress"));
					    	st.setOrderTime(rs.getString("orderTime"));
					    	st.setOrderCode(rs.getString("orderCode"));
					    	st.setTotalPrice(rs.getInt("totalPrice"));
					    	st.setCount(rs.getInt("count"));
					    	st.setBuyerTel(rs.getString("buyerTel"));
					    	st.setRemark(rs.getString("remark"));
					    	st.setGetOrderWay(rs.getInt("getOrderWay"));
					    	list.add(st);
					    }
						System.out.println("订单数量="+list.size());
							if(list.isEmpty()){
								System.out.println("打印结束");
							}else{
//								System.out.print(list);
								for(OrderInfo tmp:list){
									String id=tmp.getId();
//									System.out.println("OrderInfo="+id);
									String buyerTel=tmp.getBuyerTel();
									String toAddress=tmp.getToAddress();
									String orderCode=tmp.getOrderCode();
									String orderTime=tmp.getOrderTime();
									int totalPrice=tmp.getTotalPrice();
									int count=tmp.getCount();
									String remark=tmp.getRemark();
									int getOrderWay=tmp.getGetOrderWay();
									String sql_order_good="select goods_id,number from t_order_goods where order_id='"+id+"'";
									
									rs=stmt.executeQuery(sql_order_good);
									while(rs.next())
								    {   GoodsBean gb=new GoodsBean();
//								    	gb.setId(rs.getString("id"));
//								    	System.out.println("goods_id====="+rs.getString("goods_id"));
//								    	System.out.println("number====="+rs.getInt("number"));
								    	gb.setGoods_id(rs.getString("goods_id"));
								    	gb.setNumber(rs.getInt("number"));
								    	goodlist.add(gb);
								    }
//									String goods_id=rs.getString("goods_id");
//									int number=rs.getInt("number");
									int size=goodlist.size();
//									System.out.println("-------"+size);
//									String gds_name[]=new String[size];
//									int gds_price[]=new int[size];
									String gds_name=null;
									int gds_price=0;
									for(GoodsBean tmp2:goodlist){
										String goods_id=tmp2.getGoods_id();
//										System.out.println("goods_id@"+rs.getString("goods_id"));
										int number=tmp2.getNumber();
										String sql_good="select gds_name,gds_price from t_goods where gds_id='"+goods_id+"'";
//										System.out.println("sql_good///"+sql_good);
										rs=stmt.executeQuery(sql_good);
										while(rs.next())
									    { 
											gds_name=rs.getString("gds_name");
//											System.out.println("gds_name结果="+gds_name);
											gds_price=rs.getInt("gds_price");
											tmp2.setGds_name(gds_name);
											tmp2.setGds_price(gds_price);
									    }
//										for(int i=0;i<goodlist.size();i++){
//											gds_name[i]=rs.getString("gds_name");
//											gds_price[i]=rs.getInt("gds_price");
//										}
										
//										tmp2.setNumber(number);
									}
//							        System.out.println(tmp.getBuyerTel());
							   //打印新订单start
					           	    Print testPrint=new Print();
									testPrint.setBuyerTel(buyerTel);
									testPrint.setCount(count);
									testPrint.setRemark(remark);
									testPrint.setOrderCode(orderCode);
									testPrint.setOrderTime(orderTime);
									testPrint.setToAddress(toAddress);
									testPrint.setTotalPrice(totalPrice);
									testPrint.setGoodlist(goodlist);
									testPrint.setGetOrderWay(getOrderWay);
									Print.test();
							    	//打印新订单end
									tmp.setState("0");
									String sql_update="update t_orders set state=1 where buyerTel='"+buyerTel+"'";
//									System.out.println("sql_update="+sql_update);
									update=stmt.execute(sql_update);
//									System.out.println("update结果="+update);
								}
								Thread.sleep(3000);  
					    }
						
						 
						  if(rs!=null){rs.close();}
						   if(stmt!=null){stmt.close();}
						   if(conn!=null){
							   conn.close();   }  
					 }catch(Exception e){e.printStackTrace();}
		           }  
		        },startDate, 6* 1000); 
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	}
    
}
