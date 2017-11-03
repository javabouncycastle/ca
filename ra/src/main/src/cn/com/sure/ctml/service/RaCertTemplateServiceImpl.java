/**
 * 
 */
package cn.com.sure.ctml.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sure.ctml.dao.RaCertTemplateDAO;
import cn.com.sure.ctml.entry.RaCertTemplate;

/**
 * @author Limin
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service("raCertTemplateService")
public class RaCertTemplateServiceImpl implements RaCertTemplateService{
	

	private static final Log LOG = LogFactory.getLog(RaCertTemplateServiceImpl.class);
	
	@Autowired
	private RaCertTemplateDAO raCertTemplateDAO;
	
	/* (non-Javadoc)
	 * @see cn.com.sure.ctml.service.RaCertTemplateService#selectAll()
	 */
	@Override
	public List<RaCertTemplate> selectAll() {
		LOG.debug("selectAll - start");
		List<RaCertTemplate> raCertTemplates = raCertTemplateDAO.selectAll();
		LOG.debug("selectAll - end");
		return raCertTemplates;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ctml.service.RaCertTemplateService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		LOG.debug("deleteAll - start");
		raCertTemplateDAO.deleteAll();
		LOG.debug("deleteAll - start");
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.ctml.service.RaCertTemplateService#insert(cn.com.sure.ctml.entry.RaCertTemplate)
	 */
	@Override
	public void insert(RaCertTemplate raCertTemplate){
		LOG.debug("insert - start");
		raCertTemplateDAO.insert(raCertTemplate);
		LOG.debug("insert - end");
	}

}
