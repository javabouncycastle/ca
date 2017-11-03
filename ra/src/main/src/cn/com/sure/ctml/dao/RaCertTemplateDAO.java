/**
 * 
 */
package cn.com.sure.ctml.dao;

import java.util.List;

import cn.com.sure.ctml.entry.RaCertTemplate;

/**
 * @author Limin
 *
 */
public interface RaCertTemplateDAO {

	/**
	 * @return
	 */
	List<RaCertTemplate> selectAll();

	/**
	 * 
	 */
	void deleteAll();

	/**
	 * @param raCertTemplate
	 */
	void insert(RaCertTemplate raCertTemplate);

}
