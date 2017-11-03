/**
 * 
 */
package cn.com.sure.ca.template.dao;

import java.util.List;

import cn.com.sure.ca.template.entry.CaCertTemplate;

/**
 * @author Limin
 *
 */
public interface CaCertTemplateDAO {

	/**
	 * @return 
	 * 
	 */
	public List<CaCertTemplate> selectAll();

	/**
	 * @param certTemplate
	 * @return
	 */
	public int insert(CaCertTemplate certTemplate);

	/**
	 * @param certTemplate
	 * @return
	 */
	public int update(CaCertTemplate certTemplate);


	/**
	 * @param id
	 * @return
	 */
	public int remove(String id);

	/**
	 * @param id
	 * @return
	 */
	public CaCertTemplate findById(String id);

	/**
	 * @param certTemplate
	 * @return
	 */
	public int updateValid(CaCertTemplate certTemplate);

	/**
	 * @param caCertTemplate 
	 * @return
	 */
	public List<CaCertTemplate> selectStandby(CaCertTemplate caCertTemplate);


}
