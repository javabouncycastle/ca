/**
 * 
 */
package cn.com.sure.ca.socket;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import cn.com.sure.ca.template.entry.CaCertTemplate;
import cn.com.sure.ca.template.service.CaCertTemplateService;
import cn.com.sure.common.CaConstants;

/**
 * @author Limin
 *
 */
public class CaSocketServiceImpl implements CaSocketService{
	
	private static final Log LOG = LogFactory.getLog(CaSocketServiceImpl.class);
	
	@Autowired
	private CaCertTemplateService caCertTemplateService;

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.socket.CaSocketService#handleSocket(byte[])
	 */
	@Override
	public byte[] handleSocket(byte[] reqinfo) {
		LOG.debug("synchronousCtml - start");
		
		//1.对申请信息进行处理
		String requestInfo=new String(reqinfo);
		
		if(requestInfo.equals(CaConstants.SYNCHRONOUS_CTML)){
			
			//1.1 查询所有在用证书模板,并封装成json返回给ra
			List<CaCertTemplate> caCertTemplates = caCertTemplateService.selectStandby();
			
			String jsonStr=JSON.toJSONString(caCertTemplates);
			
			return jsonStr.getBytes();
			
		}
		
		
		
		//2.
		
		
		LOG.debug("synchronousCtml - end");
		return null;
	}

}
