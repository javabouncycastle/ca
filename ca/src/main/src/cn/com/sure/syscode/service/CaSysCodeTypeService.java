/**
 * 
 */
package cn.com.sure.syscode.service;

import java.util.List;

import cn.com.sure.ca.CaApplicationexception;
import cn.com.sure.syscode.entry.CaSysCodeType;

/**
 * @author Limin
 *
 */
public interface CaSysCodeTypeService {

	/**
	 * @param sysCodeType
	 * @return 
	 */
	int insert(CaSysCodeType sysCodeType)throws CaApplicationexception;

	/**
	 * @param sysCodeType
	 * @return 
	 */
	int update(CaSysCodeType sysCodeType);

	/**
	 * @param id
	 * @return 
	 */
	int delete(String id);

	/**
	 * @param sysCodeType
	 * @return
	 */
	List<CaSysCodeType> selectAll(CaSysCodeType sysCodeType);

	/**
	 * @param sysCodeType
	 * @return
	 */
	List<CaSysCodeType> searchByCondition(CaSysCodeType sysCodeType);

	/**
	 * @param string
	 * @return
	 */
	CaSysCodeType selectById(String string);

	/**
	 * @param keyPairAlgorithm
	 * @return 
	 */
	CaSysCodeType findIdByParaType(String keyPairAlgorithm);
	
}
