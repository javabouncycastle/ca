package cn.com.sure.syscode.dao;

import java.util.List;

import cn.com.sure.syscode.entry.CaSysCode;

public interface CaSysCodeDAO {


	/**
	 * @param sysCode
	 * @return 
	 */
	public List<CaSysCode> serachByContion(CaSysCode sysCode);

	/**
	 * @param sysCode
	 * @return
	 */
	public CaSysCode findByName(CaSysCode sysCode);

	/**
	 * @param sysCode
	 * @return
	 */
	public int insert(CaSysCode sysCode);

	/**
	 * @param sysCode
	 * @return
	 */
	public int update(CaSysCode sysCode);

	/**
	 * @param id
	 * @return
	 */
	public int delete(String id);

	/**
	 * @param id
	 * @return
	 */
	public CaSysCode findById(String id);

	/**
	 * @param sysCode
	 */
	public void updateValid(CaSysCode sysCode);

	/**
	 * @return
	 */
	public List<CaSysCode> selectAll();

	/**
	 * @param sysCode
	 * @return
	 */
	public List<CaSysCode> findByType(CaSysCode sysCode);

	/**
	 * @param keyPairAlgorithm
	 */
	public void deleteByParaCode(String keyPairAlgorithm);


}
