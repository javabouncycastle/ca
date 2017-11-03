/**
 * 
 */
package cn.com.sure.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.sure.common.RaConstants;
import cn.com.sure.ctml.entry.RaCertTemplate;
import cn.com.sure.ctml.service.RaCertTemplateService;
import cn.com.sure.ra.ResourceBundleSocketMessage;

import com.alibaba.fastjson.JSONArray;

/**
 * @author Limin
 *
 */
public class RaSocketClientThread extends Thread {
	
	private static final Log LOG = LogFactory.getLog(RaSocketClientThread.class);
	
	private RaCertTemplateService raCertTemplateService;

	public RaSocketClientThread(RaCertTemplateService raCertTemplateService) {
		this.raCertTemplateService = raCertTemplateService;
	}

	public void run(){
		
		//1.读取properties文件，获取配置信息，km端口号与ip
		 ResourceBundleSocketMessage rbem = ResourceBundleSocketMessage.getInstance();
		 
		 try {
	        	
	        	LOG.debug("创建一个新的socket开始");
				Socket socket = new Socket(rbem.getMessage("caIp",  new Object[]{ "",""}),Integer.parseInt(rbem.getMessage("caPort",  new Object[]{ "",""})));
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream()) ;
				
				
				//1.发送信息去km端获取密钥算法
				LOG.debug("发送信息到ca端---start");
				byte[] synchronousKpg = RaConstants.SYNCHRONOUS_CTML.getBytes();
				byte[] synLen = intToByte(synchronousKpg.length);
				
				dos.write(synLen);
				dos.flush();
				dos.write(synchronousKpg);
				dos.flush();
				LOG.debug("发送信息到ca端---end");
				
				
				LOG.debug("接收返回来的信息 --- start");
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				byte[] buffer = new byte[1024];//缓存数据，每次读取byte的一部分
				int nActiveLength = 0;
				
				byte[] reqlenbyte = new byte[4];//请求的byte的长度
				int reqlen = 0;
				
				int bufferlength = dis.read(reqlenbyte);
				
				if(bufferlength == 4){
					reqlen = byteToInt(reqlenbyte);
				}
				
				
				//leftLen表示数据内容的长度
				byte[] reqinfo = new byte[reqlen];				
				System.out.println("begin receive need:" + reqlen);								
				
				while(reqlen > 0){
					bufferlength = dis.read(buffer);
					if(bufferlength > 0){						
						//源数组,源数组要复制的起始位置,目的数组,目的数组放置的起始位置,复制的长度
						System.arraycopy(buffer, 0, reqinfo, nActiveLength, bufferlength);
						nActiveLength = nActiveLength + bufferlength;
						reqlen = reqlen - bufferlength;							
					}
				}
				String reStr=new String(reqinfo);
				
				List<RaCertTemplate> raCertTemplates = new ArrayList<RaCertTemplate>();
				raCertTemplates = JSONArray.parseArray(reStr,RaCertTemplate.class);
				
				for(int i = 0; i<raCertTemplates.size();i++){
					
					raCertTemplateService.insert(raCertTemplates.get(i));
					
				}
				

				LOG.debug("接收返回来的信息 --- end");
				dos.close();
				socket.close();
	         
				
				
		 }catch (IOException e) {
				e.printStackTrace();
			} 
		 
		 
		
	}
	
	public static byte[] intToByte(int nValue) {         
		byte[] byaValue = new byte[4];         
		for (int i = 0; i < 4; i++) {             
			byaValue[i] = (byte) (nValue >> 8 * (3 - i) & 0xFF);
		}
		return byaValue;
	}
	
	
	public static int byteToInt(byte[] byaValue) {
		int nValue = 0; 
		for (int i = 0; i < byaValue.length; i++){
			nValue += (byaValue[i] & 0xFF) << (8 * (3 - i));
		}
		return nValue;
	}

}
