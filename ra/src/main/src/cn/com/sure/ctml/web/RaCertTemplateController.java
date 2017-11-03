/**
 * 
 */
package cn.com.sure.ctml.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.sure.ctml.entry.RaCertTemplate;
import cn.com.sure.ctml.service.RaCertTemplateService;
import cn.com.sure.socket.RaSocketClientThread;

/**
 * @author Limin
 *
 */
@Controller
@RequestMapping(value="certTemplate")
public class RaCertTemplateController {
	
	private static final Log LOG = LogFactory.getLog(RaCertTemplateController.class);
	
	@Autowired
	private RaCertTemplateService certTemplateService;
	
	
	/**
	 * 
	 * @param certTemplate
	 * @param model
	 * @param attr
	 * @param request
	 * @return
	 */
	@RequestMapping(value="selectAll")
	public ModelAndView selectAll(RaCertTemplate certTemplate,
			Model model, RedirectAttributes attr,HttpServletRequest request){
		LOG.debug("selectAll - start");
		List<RaCertTemplate> raCertTemplates = certTemplateService.selectAll();
		LOG.debug("selectAll - end");
		return new ModelAndView("syscode/raCtmlList").addObject("raCertTemplates", raCertTemplates);
		
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="synchronousCtml")
	public String synchronousCtml(){
		LOG.debug("synchronousCtml - start");
		
		//1.删除原来证书模板信息
		certTemplateService.deleteAll();
		
		new Thread(new RaSocketClientThread(certTemplateService)).start();
		
		LOG.debug("synchronousCtml - end");
		return null;
		
	}
	

}
