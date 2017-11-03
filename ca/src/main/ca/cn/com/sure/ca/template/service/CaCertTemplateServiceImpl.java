/**
 * 
 */
package cn.com.sure.ca.template.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sure.ca.template.dao.CaCertTemplateDAO;
import cn.com.sure.ca.template.entry.CaCertTemplate;
import cn.com.sure.common.CaConstants;

/**
 * @author Limin
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service("CertTemplateService")
public class CaCertTemplateServiceImpl implements CaCertTemplateService{
	
	
	private static final Log LOG = LogFactory.getLog(CaCertTemplateServiceImpl.class);
	
	@Autowired
	private CaCertTemplateDAO certTemplateDAO;

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#selectAll()
	 */
	@Override
	public List<CaCertTemplate> selectAll() {
		LOG.debug("selectAll - start");
		List<CaCertTemplate> certTemplates = certTemplateDAO.selectAll();
		LOG.debug("selectAll - end");
		return certTemplates;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#insert(cn.com.sure.ca.template.entry.CertTemplate)
	 */
	@Override
	public int insert(CaCertTemplate certTemplate) {
		LOG.debug("insert - start");
		int i = certTemplateDAO.insert(certTemplate);
		LOG.debug("insert - end");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#update(cn.com.sure.ca.template.entry.CertTemplate)
	 */
	@Override
	public int update(CaCertTemplate certTemplate) {
		LOG.debug("update - start");
		int i = certTemplateDAO.update(certTemplate);
		LOG.debug("update - end");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#remove(java.lang.Long)
	 */
	@Override
	public int remove(String id) {
		LOG.debug("remove - start");
		int i = certTemplateDAO.remove(id);
		LOG.debug("remove - end");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#activite(java.lang.String)
	 */
	@Override
	public int activite(String id) {
		LOG.debug("activite - start");
		CaCertTemplate certTemplate = certTemplateDAO.findById(id);
		certTemplate.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		int i = certTemplateDAO.updateValid(certTemplate);
		LOG.debug("activite - end");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CertTemplateService#suspend(java.lang.String)
	 */
	@Override
	public int suspend(String id) {
		LOG.debug("suspend - start");
		CaCertTemplate certTemplate = certTemplateDAO.findById(id);
		certTemplate.setIsValid(CaConstants.YES_OR_NO_OPTION_NO);
		int i = certTemplateDAO.updateValid(certTemplate);
		LOG.debug("suspend - end");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ca.template.service.CaCertTemplateService#selectStandby()
	 */
	@Override
	public List<CaCertTemplate> selectStandby() {
		LOG.debug("selectStandby - start");
		CaCertTemplate caCertTemplate = new CaCertTemplate();
		caCertTemplate.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		List<CaCertTemplate> caCertTemplates = certTemplateDAO.selectStandby(caCertTemplate);
		LOG.debug("selectStandby - end");
		return caCertTemplates;
	}

}
