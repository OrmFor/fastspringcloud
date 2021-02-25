package com.springcloud.fast.fastspringcloud;

public enum StatusCode {

	/** 返回正确 **/
	SUCCESS(0, "success"),

	/** 返回异常 **/
	ERROR(-1, "服务器内部错误"),

	/** 请求相关错误 **/
	ERROR_403(403, "禁止访问"),
	ERROR_404(404, "资源不存在"),
	ERROR_405(405, "请求方法不支持"),
	ERROR_406(406, "您无权进行该操作"),
	ERROR_407(407, "未登录，无法授权信息"),
	ERROR_408(408, "登录过期，无法授权信息"),
	ERROR_409(409, "超级管理员不能进行APP操作"),
	ERROR_410(410, "您无权进行APP登录"),
	ERROR_411(411,"未认证用户无法访问"),
	ERROR_412(412,"未提交资料"),
	ERROR_413(413,"账户审核中"),
	ERROR_414(414,"账户审核不通过"),

	/** 程序相关错误 **/
	ERROR_500(500, "程序错误"),

	/** 请求头相关错误 **/
	ERROR_TOKEN_EMPTY(600, "缺少token"),
	ERROR_LACK_PARAM(601, "缺少参数"),
	ERROR_PARAM_DECIPHERING(602, "参数解密失败"),
	ERROR_PARAM(603, "参数错误"),
	ERROR_COOKIE(607, "cookie不存在"),

	;

	private Integer code;
	private String msg;

	StatusCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
