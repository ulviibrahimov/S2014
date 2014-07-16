package com.socar.hrsocar.model;

import java.net.URL;

public class Reg {
	private String regUrl;
	private String regEmail;
	private String regInsuirance;
	private String 	regPernr;
	private String regPin;
	
	public Reg(String url, String regEmail, String regInsuirance,
			String regPernr, String regPin) {
		super();
		this.regUrl = url;
		this.regEmail = regEmail;
		this.regInsuirance = regInsuirance;
		this.regPernr = regPernr;
		this.regPin = regPin;
	}

	public String getRegUrl() {
		return regUrl;
	}

	public void setRegUrl(String url) {
		this.regUrl = url;
	}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getRegInsuirance() {
		return regInsuirance;
	}

	public void setRegInsuirance(String regInsuirance) {
		this.regInsuirance = regInsuirance;
	}

	public String getRegPernr() {
		return regPernr;
	}

	public void setRegPernr(String regPernr) {
		this.regPernr = regPernr;
	}

	public String getRegPin() {
		return regPin;
	}

	public void setRegPin(String regPin) {
		this.regPin = regPin;
	}

}
