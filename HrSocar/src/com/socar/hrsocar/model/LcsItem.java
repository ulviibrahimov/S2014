package com.socar.hrsocar.model;


public class LcsItem {
	private String serialNumber;
	private String series;
	private String issuanceDate;
	private String issuingAuthority;
	private String expirationDate;
	private String category;
	public LcsItem() {
		super();
		this.serialNumber = null;
		this.issuanceDate = null;
		this.issuingAuthority = null;
		this.expirationDate = null;
		this.category = null;
		this.issuanceDate=null;
		this.series=null;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public String getSeries() {
		return series;
	}
	public String getIssuanceDate() {
		return issuanceDate;
	}
	public String getIssuingAuthority() {
		return issuingAuthority;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public String getCategory() {
		return category;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}