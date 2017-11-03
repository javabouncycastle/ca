/**
 * 
 */
package cn.com.sure.ca.template.service;

import java.util.List;

import cn.com.sure.ca.template.entry.CaCertTemplate;

/**
 * @author Limin
 *
 */
public interface CaCertTemplateService {

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
	public int activite(String id);

	/**
	 * @param id
	 * @return
	 */
	public int suspend(String id);

	/**
	 * @return
	 */
	public List<CaCertTemplate> selectStandby();
}
