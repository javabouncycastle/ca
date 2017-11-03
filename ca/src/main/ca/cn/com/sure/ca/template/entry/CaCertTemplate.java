/**
 * 
 */
package cn.com.sure.ca.template.entry;

import cn.com.sure.syscode.entry.CaSysCode;

/**
 * @author Limin
 *
 */
public class CaCertTemplate {
	
	private String id;
	
	/**
	 * 模板名称
	 */
	private String ctmlName;
	
	/**
	 * 密钥对类型，引用数据字典表
	 */
	private CaSysCode kpgAlgorithm;
	
	/**
	 * 有效期天数
	 */
	private CaSysCode validity;
	
	/**
	 * 是否单证书
	 */
	private Integer isSingle;  
	
	/**
	 * 签名证书密钥用法   列表形式（id1:1,id2:1）
	 */
	private String signCertKeyUsage;        
    
	/**
	 * 签名证书密钥用法   列表形式
	 */
	private String signCertExtendedKeyUsage;
	
	/**
	 * 加密证书密钥用法   列表形式
	 */
	private String encCertKeyUsage;        
     
	/**
	 * 加密证书密钥用法   列表形式
	 */
	private String encCertExtendedKeyUsage;
	
	/**
	 * 是否有效
	 */
	private Integer isValid;
	
	/**
	 * baseDN
	 */
	private String baseDn;
	
	/**
	 * 审核类型，自动审核or手动审核
	 */
	private String reviewedType;
	
	
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

	public String getCtmlName() {
		return ctmlName;
	}

	public void setCtmlName(String ctmlName) {
		this.ctmlName = ctmlName;
	}

	public CaSysCode getKpgAlgorithm() {
		return kpgAlgorithm;
	}

	public void setKpgAlgorithm(CaSysCode kpgAlgorithm) {
		this.kpgAlgorithm = kpgAlgorithm;
	}

	public CaSysCode getValidity() {
		return validity;
	}

	public void setValidity(CaSysCode validity) {
		this.validity = validity;
	}

	public Integer getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(Integer isSingle) {
		this.isSingle = isSingle;
	}

	public String getSignCertKeyUsage() {
		return signCertKeyUsage;
	}

	public void setSignCertKeyUsage(String signCertKeyUsage) {
		this.signCertKeyUsage = signCertKeyUsage;
	}

	public String getSignCertExtendedKeyUsage() {
		return signCertExtendedKeyUsage;
	}

	public void setSignCertExtendedKeyUsage(String signCertExtendedKeyUsage) {
		this.signCertExtendedKeyUsage = signCertExtendedKeyUsage;
	}

	public String getEncCertKeyUsage() {
		return encCertKeyUsage;
	}

	public void setEncCertKeyUsage(String encCertKeyUsage) {
		this.encCertKeyUsage = encCertKeyUsage;
	}

	public String getEncCertExtendedKeyUsage() {
		return encCertExtendedKeyUsage;
	}

	public void setEncCertExtendedKeyUsage(String encCertExtendedKeyUsage) {
		this.encCertExtendedKeyUsage = encCertExtendedKeyUsage;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public String getNotes() {
		return notes;
	}

	public String getBaseDn() {
		return baseDn;
	}

	public void setBaseDn(String baseDn) {
		this.baseDn = baseDn;
	}

	public String getReviewedType() {
		return reviewedType;
	}

	public void setReviewedType(String reviewedType) {
		this.reviewedType = reviewedType;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
