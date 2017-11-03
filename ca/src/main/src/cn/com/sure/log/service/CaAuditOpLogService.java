package cn.com.sure.log.service;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.com.sure.log.entry.CaAuditOpLog;

public interface CaAuditOpLogService {
	
	
	/**
	 * 
	 * @param auditOpLog
	 */
	void insert(long type,String action,String actionExt1,String actionExt2,String actionExt3,String actionExt4,
			String  message,Date timestamp,String ip,String  operator,Integer isOpSucc);
	

	/**
	 * @return
	 */
	List<CaAuditOpLog> selectAll();


	/**
	 * @param auditOpLog
	 * @return
	 */
	List<CaAuditOpLog> searchByCondition(CaAuditOpLog auditOpLog);


	/**
	 * @param out 
	 * @param titles 
	 * 
	 */
	void exportExcel(String[] titles, ServletOutputStream out,CaAuditOpLog auditOpLog)throws Exception;
	
}
