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
			//首先要给网口打印机赋一个 IP 地址，例如叫做 192.168.0.18 。
			client.connect(new InetSocketAddress("192.168.123.99" , 9100),1000);
			// 创建输入输出数据流
			socketWriter = new PrintWriter(client.getOutputStream());
			//连接建立完毕，写入内容就非常容易，只要使用 write 或者 println 方法写入即可，
			//其中 write 方法是写入数字或字符，println 写入一行字符串。
			socketWriter.write(0); 
			//写入一行字符串
			socketWriter.println("巧富餐饮软件后厨单据");
			//再入一行字符串 
			socketWriter.println("桌位 14 桌，人数 3");
			//放大字体需要用到爱普生的 0x1c 指令，使用爱普生指令的方法很简单，只要向端口写入指令即可，例如
			socketWriter.write(0x1c);
			/*注意 0x1c，是 16 进制的数字，当然也可以转换成 10 进制来写。
			 * 需要说明的是，使用爱普生指令放大字体不能随意放大，因为它不是图形化打印，而是文本化打印，
			 * 所以纵向或者横向只能按照倍数放大，不能矢量放大。例如在 POS58 打印机上将“巧富餐饮软件”几个字放大打印，
			 * 可以有如下放大方法。
			 * 一般情况下，我们倾向采用纵向放大一倍的方法，放大后的字体看起来有点像仿宋体，视觉效果还不错。
			 */
			/* 横向放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			/* 纵向放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			/* 横向纵向都放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(12);
			
			
			/*
			 * 现在知道了使用爱普生指令的方法，所以只要有一本爱普生指令手册在手里，
			 * 就可以用 Java 控制打印机进行无驱打印。但是现在问题是，同样是爱普生指令，
			 * 不同的 pos 打印机可能不一样，就拿放大字体来说，pos58 打印机和 pos80 打印机指令就不尽相同。
			 * 这时候怎么办呢？如何兼容多种类型打印机？
			 * 比如说，有的打印机并不是使用 0x1c 作为放大指令，而是使用 0x1b 作为放大指令，怎么办？容易。
			 * 
			 * 看明白了吗？就是写两遍就行，因为如果 0x1b 指令若不存在，打印机自动将其抛弃。
			 */
			/* 横向放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(4); 
			/* 纵向放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(8); 
			/* 横向纵向都放大一倍 */ 
			socketWriter.write(0x1c); 
			socketWriter.write(0x21); 
			socketWriter.write(12); 
			socketWriter.write(0x1b); 
			socketWriter.write(0x21); 
			socketWriter.write(12);
			
			
			
			/*
			 * 条形码在各个行业中现在有广泛的应用，所以让打印机打印条形码是非常重要的功能，
			 * 不过你不需要费好多精力去研究条形码知识，因为爱普生指令中有一个打印条形码指令
			 * ，例如我们要打印条形码“ 091955826335 ”，只要使用如下命令即可。
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
			 * POS 打印机因为出纸口有一些深度，打印完毕为了避免撕裂文字内容，
			 * 一般需要适当走纸才行，当然可以使用爱普生指令来走纸，但是这样并不稳妥，为什么呢 ?
			 *  因为要考虑 POS 机的兼容性，所以一般采用打印空行的方式实现走纸。
			 */
			for(int i=0;i<10;i++){ 
			    socketWriter.println(" ");// 打印完毕自动走纸
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 创建一个 socket 
		
		
	}

}
