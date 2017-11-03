/**
 * 
 */
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
import cn.com.sure.syscode.dao.CaSysCodeTypeDAO;
import cn.com.sure.syscode.entry.CaSysCodeType;

/**
 * @author Limin
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service("SysCodeTypeService")
public class CaSysCodeTypeServiceImpl implements CaSysCodeTypeService {
	
	private static final Log LOG = LogFactory.getLog(CaSysCodeTypeServiceImpl.class);
	
	@Autowired
	private CaSysCodeTypeDAO sysCodeTypeDAO;

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#insert(cn.com.sure.syscode.entry.SysCodeType)
	 */
	@Override
	public int insert(CaSysCodeType sysCodeType) throws CaApplicationexception {
		LOG.debug("insert - start");
		CaSysCodeType dbSysCodeType = sysCodeTypeDAO.findByType(sysCodeType.getParaType());
		int i = 0;
		if(dbSysCodeType==null){
			i = sysCodeTypeDAO.insert(sysCodeType);
		}if(dbSysCodeType!=null){
			CaApplicationexception.throwException(CaErrorMessageConstants.paraTypeValueExist, new String[]{sysCodeType.getParaType()});
		}
		LOG.debug("insert - start");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#update(cn.com.sure.syscode.entry.SysCodeType)
	 */
	@Override
	public int update(CaSysCodeType sysCodeType) {
		LOG.debug("update - start");
		int i = sysCodeTypeDAO.update(sysCodeType);
		LOG.debug("update - start");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#delete(java.lang.Long)
	 */
	@Override
	public int delete(String id) {
		LOG.debug("delete - start");
		int i = sysCodeTypeDAO.delete(id);
		LOG.debug("delete - start");
		return i;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#selectAll(cn.com.sure.syscode.entry.SysCodeType)
	 */
	@Override
	public List<CaSysCodeType> selectAll(CaSysCodeType sysCodeType) {
		LOG.debug("selectAll - start");
		List<CaSysCodeType> sysCodeTypes = sysCodeTypeDAO.selectAll(sysCodeType);
		LOG.debug("selectAll - end");
		return sysCodeTypes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#searchByCondition(cn.com.sure.syscode.entry.SysCodeType)
	 */
	@Override
	public List<CaSysCodeType> searchByCondition(CaSysCodeType sysCodeType) {
		LOG.debug("searchByCondition - start");
		List<CaSysCodeType> sysCodeTypes = sysCodeTypeDAO.searchByCondition(sysCodeType);
		LOG.debug("searchByCondition - end");
		return sysCodeTypes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#selectById(java.lang.Long)
	 */
	@Override
	public CaSysCodeType selectById(String id) {
		LOG.debug("selectById - start");
		CaSysCodeType sysCodeTypes = sysCodeTypeDAO.selectById(id);
		LOG.debug("selectById - end");
		return sysCodeTypes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeTypeService#findIdByParaType(java.lang.String)
	 */
	@Override
	public CaSysCodeType findIdByParaType(String keyPairAlgorithm) {
		LOG.debug("findIdByParaType - start");
		CaSysCodeType sysCodeType = sysCodeTypeDAO.findIdByParaType(keyPairAlgorithm);
		LOG.debug("findIdByParaType - start");
		return sysCodeType;
	}

}
