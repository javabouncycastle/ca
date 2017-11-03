package cn.com.sure.syscode.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.sure.common.RaConstants;
import cn.com.sure.ra.CaErrorMessageConstants;
import cn.com.sure.ra.RaApplicationexception;
import cn.com.sure.syscode.dao.RaSysCodeDAO;
import cn.com.sure.syscode.entry.RaSysCode;

@Transactional(propagation = Propagation.REQUIRED)
@Service("SysCodeService")
public class RaSysCodeServiceImpl implements RaSysCodeService{
	
	private static final Log LOG = LogFactory.getLog(RaSysCodeServiceImpl.class);
	
	@Autowired
	private RaSysCodeDAO sysCodeDAO;
	

	@Override
	public int insert(RaSysCode sysCode, HttpServletRequest request)
			throws RaApplicationexception {
		LOG.debug("insert - start");
		RaSysCode dbSysCode = sysCodeDAO.findByName(sysCode);
		int i = 0 ;
		if(dbSysCode==null){
			i =sysCodeDAO.insert(sysCode);
		}if(dbSysCode!=null){
			RaApplicationexception.throwException(CaErrorMessageConstants.paraValueExist, new String[]{sysCode.getParaValue()});
		}
		
		LOG.debug("insert - end");
		return i;
	}

	@Override
	public int update(RaSysCode sysCode) {
		LOG.debug("update - start");
		int i = sysCodeDAO.update(sysCode);
		LOG.debug("update - end");
		return i;
	}

	@Override
	public int remove(Long id) {
		LOG.debug("remove - start");
		int i = sysCodeDAO.delete(id);
		LOG.debug("remove - end");
		return i;
	}

	@Override
	public void suspend(Long id) {
		LOG.debug("suspend - start");
		RaSysCode sysCode = sysCodeDAO.findById(id);
		sysCode.setIsValid(RaConstants.YES_OR_NO_OPTION_NO);
		sysCodeDAO.updateValid(sysCode);
		LOG.debug("suspend - end");
	}

	@Override
	public void activate(Long id) {
		LOG.debug("activate - start");
		RaSysCode sysCode = sysCodeDAO.findById(id);
		sysCode.setIsValid(RaConstants.YES_OR_NO_OPTION_YES);
		sysCodeDAO.updateValid(sysCode);
		LOG.debug("activate - start");
	}

	@Override
	public List<RaSysCode> selectAll(RaSysCode sysCode) {
		LOG.debug("selectAll - start");
		List<RaSysCode> sysCodes = sysCodeDAO.selectAll(sysCode);
		LOG.debug("selectAll - end");
		return sysCodes;
	}


	@Override
	public List<RaSysCode> searchByCondition(RaSysCode sysCode) {
		LOG.debug("searchByCondition - start");
		List<RaSysCode> sysCodes = sysCodeDAO.serachByContion(sysCode);
		LOG.debug("searchByCondition - end");
		return sysCodes;
	}

	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeService#selectById(java.lang.Long)
	 */
	@Override
	public RaSysCode selectById(Long id) {
		LOG.debug("selectById - start");
		RaSysCode sysCodes = sysCodeDAO.findById(id);
		LOG.debug("selectById - end");
		return sysCodes;
	}


	/* (non-Javadoc)
	 * @see cn.com.sure.syscode.service.SysCodeService#getServicePort()
	 */
	@Override
	public List<RaSysCode> selectServicePort() {
		LOG.debug("getServicePort - start");
		/*RaSysCodeType sysCodeType = new RaSysCodeType();
		sysCodeType.setParaType(RaConstants.TYPE_ID_TASK_STATUS);
		RaSysCode sysCode = new RaSysCode();
		sysCode.setParaType(sysCodeType);
		sysCode.setIsValid(RaConstants.YES_OR_NO_OPTION_YES);
		List<RaSysCode> sysCodes = this.sysCodeDAO.findByType(sysCode);*/
		LOG.debug("getServicePort - start");
		return null;
	}


}
