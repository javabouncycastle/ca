package cn.com.sure.syscode.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sure.ca.CaApplicationexception;
import cn.com.sure.ca.CaErrorMessageConstants;
import cn.com.sure.common.CaConstants;
import cn.com.sure.syscode.dao.CaSysCodeDAO;
import cn.com.sure.syscode.entry.CaSysCode;

@Transactional(propagation = Propagation.REQUIRED)
@Service("SysCodeService")
public class CaSysCodeServiceImpl implements CaSysCodeService{
	
	private static final Log LOG = LogFactory.getLog(CaSysCodeServiceImpl.class);
	
	@Autowired
	private CaSysCodeDAO sysCodeDAO;
	

	@Override
	public int insert(CaSysCode sysCode)
			throws CaApplicationexception {
		LOG.debug("insert - start");
		CaSysCode dbSysCode = sysCodeDAO.findByName(sysCode);
		int i = 0 ;
		if(dbSysCode==null){
			i =sysCodeDAO.insert(sysCode);	
		}if(dbSysCode!=null){
			CaApplicationexception.throwException(CaErrorMessageConstants.paraValueExist, new String[]{sysCode.getParaValue()});
		}
		
		LOG.debug("insert - end");
		return i;
	}

	@Override
	public int update(CaSysCode sysCode) {
		LOG.debug("update - start");
		int i = sysCodeDAO.update(sysCode);
		LOG.debug("update - end");
		return i;
	}

	@Override
	public int remove(String id) {
		LOG.debug("remove - start");
		int i = sysCodeDAO.delete(id);
		LOG.debug("remove - end");
		return i;
	}

	@Override
	public void suspend(String id) {
		LOG.debug("suspend - start");
		CaSysCode sysCode = sysCodeDAO.findById(id);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_NO);
		sysCodeDAO.updateValid(sysCode);
		LOG.debug("suspend - end");
	}

	@Override
	public void activate(String id) {
		LOG.debug("activate - start");
		CaSysCode sysCode = sysCodeDAO.findById(id);
		sysCode.setIsValid(CaConstants.YES_OR_NO_OPTION_YES);
		sysCodeDAO.updateValid(sysCode);
		LOG.debug("activate - start");
	}

	@Override
	public List<CaSysCode> selectAll() {
		LOG.debug("selectAll - start");
		List<CaSysCode> sysCodes = sysCodeDAO.selectAll();
		LOG.debug("selectAll - end");
		return sysCodes;
	}

	@Override
	public List<CaSysCode> searchByCondition(CaSysCode sysCode) {
		LOG.debug("searchByCondition - start");
		List<CaSysCode> sysCodes = sysCodeDAO.serachByContion(sysCode);
		LOG.debug("searchByCondition - end");
		return sysCodes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeService#selectById(java.lang.Long)
	 */
	@Override
	public CaSysCode selectById(String id) {
		LOG.debug("selectById - start");
		CaSysCode sysCodes = sysCodeDAO.findById(id);
		LOG.debug("selectById - end");
		return sysCodes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeService#selectByParatype(cn.com.sure.syscode.entry.SysCode)
	 */
	@Override
	public List<CaSysCode> selectByParatype(CaSysCode sysCode) {
		LOG.debug("selectByParatype - start");
		List<CaSysCode> sysCodes = sysCodeDAO.findByType(sysCode);
		LOG.debug("selectByParatype - end");
		return sysCodes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeService#deleteByParaCode(java.lang.String)
	 */
	@Override
	public void deleteByParaType(String keyPairAlgorithm) {
		LOG.debug("deleteByParaCode - start");
		sysCodeDAO.deleteByParaCode(keyPairAlgorithm);
		LOG.debug("deleteByParaCode - end");
	}



}
