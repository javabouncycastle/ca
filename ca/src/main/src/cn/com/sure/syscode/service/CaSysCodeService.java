package cn.com.sure.syscode.service;

import java.util.List;

import cn.com.sure.ca.CaApplicationexception;
import cn.com.sure.syscode.entry.CaSysCode;

public interface CaSysCodeService {
	
	
	/**
	 * @param sysCode
	 * @param request
	 * @return
	 */
	int insert(CaSysCode sysCode)throws  CaApplicationexception ;


	/**
	 * @param sysCode
	 * @return
	 */
	List<CaSysCode> selectAll();
	
	/**
	 * @param sysCode
	 * @return
	 */
	List<CaSysCode> searchByCondition(CaSysCode sysCode);

	/**
	 * @param string
	 * @return
	 */
	CaSysCode selectById(String string);

	/**
	 * @param sysCode
	 * @return
	 */
	List<CaSysCode> selectByParatype(CaSysCode sysCode);


	/**
	 * @param sysCode
	 * @return
	 */
	int update(CaSysCode sysCode);


	/**
	 * @param id
	 * @return
	 */
	int remove(String id);


	/**
	 * @param id
	 */
	void suspend(String id);


	/**
	 * @param id
	 */
	void activate(String id);



	/**
	 * @param keyPairAlgorithm
	 */
	void deleteByParaType(String keyPairAlgorithm);



}
