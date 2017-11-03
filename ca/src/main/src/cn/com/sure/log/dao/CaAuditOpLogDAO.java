package cn.com.sure.log.dao;

import java.util.List;

import cn.com.sure.log.entry.CaAuditOpLog;

public interface CaAuditOpLogDAO {

	void insert(CaAuditOpLog auditOpLog);

	/**
	 * @return
	 */
	List<CaAuditOpLog> selectAll();

	/**
	 * @param auditOpLog
	 * @return
	 */
	List<CaAuditOpLog> searchByCondition(CaAuditOpLog auditOpLog);
	
	

}
