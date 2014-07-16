package com.socar.hrsocar.model;

import java.net.URL;

public class Abs {
	private URL absUrl;
	private String 	absPernr;
	
	private Abs(URL absUrl, String absEmail, String absInsuirance,
			String absPernr, String absPin) {
		super();
		this.absUrl = absUrl;
		this.absPernr = absPernr;
	}

	public URL getAbsUrl() {
		return absUrl;
	}
	public void setAbsUrl(URL absUrl) {
		this.absUrl = absUrl;
	}
	public String getAbsPernr() {
		return absPernr;
	}
	public void setAbsPernr(String absPernr) {
		this.absPernr = absPernr;
	}
}
