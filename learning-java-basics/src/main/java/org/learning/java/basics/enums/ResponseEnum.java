package org.learning.java.basics.enums;

public enum ResponseEnum {
	SUCCESS(0, "success"), FAIL(1, "fail"), EXCEPTION(2, "exception"), ERROR(3, "exception"), INVALID_PARAMETERS(4,
			"invalid parameters"), NO_AUTHORITY(5, "no authority");
	private int code;
	private String description;

	/**
	 * Illegal modifier for the enum constructor; only private is permitted.
	 */
	private ResponseEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
