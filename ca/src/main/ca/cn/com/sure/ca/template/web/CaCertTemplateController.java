/**
 * 
 */
package cn.com.sure.ca.template.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.sure.ca.template.entry.CaCertTemplate;
import cn.com.sure.ca.template.service.CaCertTemplateService;
import cn.com.sure.common.CaConstants;
import cn.com.sure.syscode.entry.CaSysCode;
import cn.com.sure.syscode.entry.CaSysCodeType;
import cn.com.sure.syscode.service.CaSysCodeService;

/**
 * @author Limin
 *
 */
@Controller
@RequestMapping(value="certTemplate")
public class CaCertTemplateController {
	
	
	@Autowired
	private CaCertTemplateService certTemplateService;
	
	@Autowired
	private CaSysCodeService sysCodeService;
	
	private static final Log LOG = LogFactory.getLog(CaCertTemplateController.class);
	
	/**
	 * UC-SYS04-01查询全部证书模板
	 */
	@RequestMapping(value = "selectAll")
	public ModelAndView selectAll(){
		LOG.debug("selectAll - start");
		List<CaCertTemplate> certTemplates=certTemplateService.selectAll();
		List<CaSysCode> sysCodes = sysCodeService.selectAll();
		LOG.debug("selectAll - end");
		return new ModelAndView("ctml/ctmlList").addObject("certTemplates", certTemplates).addObject("sysCodes",sysCodes);
		
	}
	
	/**
	 * UC-SYS04-02新增证书模板
	 */
	@RequestMapping(value = "insert")
	public String insert(CaCertTemplate certTemplate,
			Model model, RedirectAttributes attr,HttpServletRequest request){
		LOG.debug("insert - start");
		int i = certTemplateService.insert(certTemplate);
		LOG.debug("insert - end");
		return "redirect:/certTemplate/selectAll.do";
		
	}
	
	/**
	 * UC-SYS04-03修改证书模板
	 */
	@RequestMapping(value="update")
	public String update(CaCertTemplate certTemplate,
			Model model, RedirectAttributes attr,HttpServletRequest request){
		LOG.debug("update - start");
		int i = certTemplateService.update(certTemplate);
		LOG.debug("update - end");
		return "redirect:/certTemplate/selectAll.do";
		
	}
	
	/**
	 * UC-SYS04-04删除证书模板
	 */
	@RequestMapping(value = "remove")
	public String remove(
	@RequestParam(value = "id", required = false)String id,
	Model model,RedirectAttributes attr,HttpServletRequest request){
		LOG.debug("remove - start!");
		int i = certTemplateService.remove(id);
		LOG.debug("remove - end");
		return "redirect:/certTemplate/selectAll.do";
	}
	
	/**
	 * UC-SYS04-05启用证书模板
	 */
	@RequestMapping(value="activate")
	public String activate(@RequestParam(value = "id", required = false)String id,
			Model model,RedirectAttributes attr){
		LOG.debug("activate - start");
		int i = certTemplateService.activite(id);
		LOG.debug("activate - end");
		return "redirect:/certTemplate/selectAll.do";
		
	}
	
	/**
	 * UC-SYS04-06停用证书模板
	 */
	@RequestMapping(value="suspend")
	public String suspend(@RequestParam(value = "id", required = false)String id,
			Model model,RedirectAttributes attr){
		LOG.debug("suspend - start");
		int i = certTemplateService.suspend(id);
		LOG.debug("suspend - end");
		return "redirect:/certTemplate/selectAll.do";
		
	}
	
	/**
	 * UC-SYS04-07转向新增
	 */
	@RequestMapping(value="forWardInsert")
	public ModelAndView forWardInsert(){
		LOG.debug("forWardInsert - start");
		CaSysCode sysCode = new CaSysCode();
		CaSysCodeType codeType = new CaSysCodeType();
		
		//1.在数据字典中查询证书的所有有效期限值，放到code中
		codeType.setParaType(CaConstants.VALIDITY);
		sysCode.setParaType(codeType);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> code = sysCodeService.selectByParatype(sysCode);
		
		//2.密钥类型
		codeType.setParaType(CaConstants.KPG_ALGORITHM);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> sysCodes = sysCodeService.selectByParatype(sysCode);
		
		//3.签名证书用法
		codeType.setParaType(CaConstants.SIGN_CERT_KEY_USAGE);
			//是否有效
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> sysCodeSignUse = sysCodeService.selectByParatype(sysCode);
		
		//4.签名证书用法拓展
		codeType.setParaType(CaConstants.SIGN_CERT_EXTENDED_KEY_USAGE);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> sysCodeSignExtUse = sysCodeService.selectByParatype(sysCode);
		
		//5.加密证书用法
		codeType.setParaType(CaConstants.ENC_CERT_KEY_USAGE);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> sysCodeEncUse = sysCodeService.selectByParatype(sysCode);
		
		//6.加密证书用法拓展
		codeType.setParaType(CaConstants.ENC_CERT_EXTENDED_KEY_USAGE);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaSysCode> sysCodeEncExtUse = sysCodeService.selectByParatype(sysCode);
		
		LOG.debug("forWardInsert - end");
		return new ModelAndView("ctml/ctmlAdd").addObject("code", code).addObject("sysCodes",sysCodes).addObject("sysCodeSignUse",
				sysCodeSignUse).addObject("sysCodeSignExtUse", sysCodeSignExtUse).addObject("sysCodeEncUse", sysCodeEncUse).addObject("sysCodeEncExtUse", sysCodeEncExtUse);
		
	}
}
