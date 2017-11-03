package cn.com.sure.syscode.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.sure.ra.RaApplicationexception;
import cn.com.sure.syscode.entry.RaSysCode;

public interface RaSysCodeService {


	/**
	 * @param sysCode
	 * @return 
	 */
	List<RaSysCode> searchByCondition(RaSysCode sysCode);

	/**
	 * @param id
	 * @return
	 */
	RaSysCode selectById(Long id);

	/**
	 * @return 
	 * 
	 */
	List<RaSysCode> selectServicePort();

	/**
	 * @param sysCode
	 * @param request
	 * @return
	 */
	int insert(RaSysCode sysCode, HttpServletRequest request)throws RaApplicationexception;

	/**
	 * @param sysCode
	 * @return
	 */
	List<RaSysCode> selectAll(RaSysCode sysCode);

	/**
	 * @param sysCode
	 * @return
	 */
	int update(RaSysCode sysCode);

	/**
	 * @param id
	 * @return
	 */
	int remove(Long id);

	/**
	 * @param id
	 */
	void suspend(Long id);

	/**
	 * @param id
	 */
	void activate(Long id);


}
