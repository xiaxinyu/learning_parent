package org.learning.spring.mvc.vo;

public class Response {
	private String code;
	private String desc;

	public Response(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static enum Type {
		OK, INVOLID_PARAMETER, INTERNEL_ERROR
	}
}
