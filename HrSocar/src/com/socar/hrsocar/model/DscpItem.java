package com.socar.hrsocar.model;

public class DscpItem {
	private String startDate;
	private String endDate;
	private String reason;
	private String result;
	public DscpItem() {
		super();
		this.startDate = null;
		this.endDate = null;
		this.reason = null;
		this.result = null;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
