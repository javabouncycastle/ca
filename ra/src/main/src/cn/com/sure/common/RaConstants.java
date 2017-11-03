package cn.com.sure.common;


public class RaConstants {
	
	public static final int YES_OR_NO_OPTION_YES = 1;//停用启用-启用
	public static final int YES_OR_NO_OPTION_NO = 0;//停用启用-停用
	
	public static final long OPERATION_TYPE_INSERT=11;//增加
	public static final long OPERATION_TYPE_DELETE=12;//删除
	public static final long OPERATION_TYPE_UPDATE=13;//更新
	public static final long OPERATION_TYPE_SELECT=14;//查询
	
	public static final int SUCCESS_OR_FAILD_OPTION_SUCCESS=1;//操作成功
	public static final int SUCCESS_OR_FAILD_OPTION_FAILD=0;//操作失败	
	
	//Session存放的管理员信息
	public static final String SESSION_ADMIN_ID       = "OLTAX_ADMIN_ID";
	public static final String SESSION_ADMIN_NAME     = "OLTAX_ADMIN_NAME";
	public static final String SESSION_ADMIN_REF      = "OLTAX_ADMIN_REF";
	public static final String SESSION_ADMIN_TERM_ID  = "OLTAX_ADMIN_TERM_ID";
	public static final String SESSION_ADMIN_DN       = "OLTAX_ADMIN_DN";
	
	public static final int ADMIN_AUTH_NUM = 10000;
	
	
	public static final String SYNCHRONOUS_CTML= "synchronousCtml";
	
	
	// 证书状态
	public static final long TYPE_ID_CERT_STATUS = 38L;

	public static final long CODE_ID_CERT_STATUS_GET_AUTHCODE         = 3801L; //证书状态  - 获取两码成功（23）证书未下载
	public static final long CODE_ID_CERT_STATUS_IN_USE               = 3802L; //证书状态  - 证书使用中
	
	
	// 证书新申请状态
	public static final int TYPE_ID_CERT_NEW_OR_UPDATE_STATUS = 39;    // 
	
	public static final long CODE_ID_CERT_STATUS_NEW_REQ              = 3901L; //证书状态 - 新申请1
	public static final long CODE_ID_CERT_STATUS_NEW_REQ_APPROVED     = 3902L; //证书状态  - 新申请审核通过
	public static final long CODE_ID_CERT_STATUS_NEW_REQ_DENIED       = 3903L; //证书状态  - 新申请审核拒绝
	public static final long CODE_ID_CERT_STATUS_REVOKED              = 3906L; //证书状态  - 证书已注销
	
	// 证书新更新状态
	//public static final int TYPE_ID_CERT_UPDATE_STATUS = 40;    // 
	public static final long CODE_ID_CERT_STATUS_UPDATE_REQ              = 4001L; //证书状态 - 提交更新申请
	public static final long CODE_ID_CERT_STATUS_UPDATE_REQ_APPROVED     = 4002L; //证书状态  - 更新审核通过
	public static final long CODE_ID_CERT_STATUS_UPDATE_REQ_DENIED       = 4003L; //证书状态  - 更新审核拒绝
	
	// 证书新注销状态
	public static final int TYPE_ID_CERT_REVOKE_STATUS = 41;    // 
	public static final long CODE_ID_CERT_STATUS_REVOKE_REQ              = 4101L; //证书状态 - 提交注销申请
	public static final long CODE_ID_CERT_STATUS_REVOKE_REQ_APPROVED     = 4102L; //证书状态  - 更新注销通过
	public static final long CODE_ID_CERT_STATUS_REVOKE_REQ_DENIED       = 4103L; //证书状态  - 更新注销拒绝
	
	//密钥恢复
	public static final int TYPE_ID_CERT_RECOVER_STATUS = 42; 
	

}
