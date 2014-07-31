package com.socar.hrsocar.model;

public class Parameters {
	private static String regUrl = "http://192.168.1.192:8585/xml/req1.php";
	private static String dscpUrl="http://192.168.1.192:8585/xml/dscp.php";
	public static String getRegUrl() {
		return Parameters.regUrl;
	}

	public static String getDscpUrl() {
		return Parameters.dscpUrl;
	}
}
