/**
 * 
 */
package cn.com.sure.syscode.dao;

import java.util.List;

import cn.com.sure.syscode.entry.CaSysCodeType;

/**
 * @author Limin
 *
 */
public interface CaSysCodeTypeDAO {

	/**
	 * @param paraType
	 * @return 
	 */
	public CaSysCodeType findByType(String paraType);

	/**
	 * @param sysCodeType
	 * @return 
	 */
	public int insert(CaSysCodeType sysCodeType);

	/**
	 * @param sysCodeType
	 * @return 
	 */
	public int update(CaSysCodeType sysCodeType);

	/**
	 * @param sysCodeType
	 */
	public List<CaSysCodeType> selectAll(CaSysCodeType sysCodeType);

	/**
	 * @param id
	 * @return 
	 */
	public int delete(String id);

	/**
	 * @param sysCodeType
	 * @return
	 */
	public List<CaSysCodeType> searchByCondition(CaSysCodeType sysCodeType);

	/**
	 * @param id
	 * @return
	 */
	public CaSysCodeType selectById(String id);

	/**
	 * @param keyPairAlgorithm
	 * @return
	 */
	public CaSysCodeType findIdByParaType(String keyPairAlgorithm);
}
