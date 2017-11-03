/**
 * 
 */
package cn.com.sure.ctml.service;

import java.util.List;

import cn.com.sure.ctml.entry.RaCertTemplate;

/**
 * @author Limin
 *
 */
public interface RaCertTemplateService {

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
