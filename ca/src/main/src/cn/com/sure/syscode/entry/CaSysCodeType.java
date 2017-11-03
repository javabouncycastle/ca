/**
 * 
 */
package cn.com.sure.syscode.entry;


/**
 * @author Limin
 *  系统代码类别描述 - 标识类别 比如性别，职称等
 *  
 */
public class CaSysCodeType {
	
    private String id;
   
	/**
	 * 参数值(显示值)
	 */
    private String paraType;
    
    
	/**
	 * 备注
	 */
    private String notes;



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getParaType() {
		return paraType;
	}


	public void setParaType(String paraType) {
		this.paraType = paraType;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

}
