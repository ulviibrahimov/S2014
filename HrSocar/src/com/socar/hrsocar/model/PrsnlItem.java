package com.socar.hrsocar.model;


public class PrsnlItem {
	private String serialNumber;
	private String issuanceDate;
	private String issuingAuthority;
	private String expirationDate;
	private String pinCode;
	public PrsnlItem() {
		super();
		this.serialNumber = null;
		this.issuanceDate = null;
		this.issuingAuthority = null;
		this.expirationDate = null;
		this.pinCode = null;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(String issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public String getIssuingAuthority() {
		return issuingAuthority;
	}
	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
