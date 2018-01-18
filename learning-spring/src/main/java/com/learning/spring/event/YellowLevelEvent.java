package com.learning.spring.event;

import org.springframework.context.ApplicationEvent;

public class YellowLevelEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private String reportName;

	private String level;

	public YellowLevelEvent(Object source, String reportName, String level) {
		super(source);
		this.reportName = reportName;
		this.level = level;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "YellowLevelEvent [reportName=" + reportName + ", level=" + level + "]";
	}
}
