package com.socar.hrsocar.model;

public class Parameters {
	//ursl
	private static String regUrl = "http://192.168.1.192:8585/xml/req1.php";
	private static String dscpUrl="http://192.168.1.192:8585/xml/dscp.php";
	private static String mltrUrl="http://192.168.1.192:8585/xml/mltr.php";
	private static String fmlUrl ="http://192.168.1.192:8585/xml/fml.php";
	private static String prsnlUrl ="http://192.168.1.192:8585/xml/prsnl.php";
	private static String wrkUrl ="http://192.168.1.192:8585/xml/wrk.php";
	
	//Parameters for FamilyActivity
	private static String fmlNameLabel="- Ad: ";
	private static String fmlSurnameLabel="- Soyad: ";
	private static String fmlFatherNameLabel="- Ata adı: ";
	private static String fmlBirthdayLabel="- Doğum tarixi: ";
	
	//Parameters for Disciplinary Activity
	private static String dscpYsubtyLabel= "- Ysubty: ";
	private static String dscpStartDateLabel="- Başlama tarixi: ";
	private static String dscpEndDateLabel="- Bitmə tarixi: ";
	
	//Parameters for Personal Activity
	private static String prsnlSerialNumberLabel= "- Seria nömrəsi: ";
	private static String prsnlIssuanceDateLabel="- Vəsiqənin verilmə tarixi: ";
	private static String prsnlIssuingAuthorityLabel="- Vəsiqəni verən orqan: ";
	private static String prsnlExpirationDateLabel="- Etibarlıdır: ";
	private static String prsnlPinCodeLabel="- Pin kod: ";	
	
	//Parameters for Military Activity
	private static String mltrSeriesLabel= "- Seria: ";
	private static String mltrIdNumberLabel="- Id: ";
	private static String mltrIssueDateLabel="- Verilmə tarixi: ";
	private static String mltrExpiryDateLabel="- Etibarlıdır: ";
	private static String mltrFitLabel="- Fit: ";	
	private static String mltrGroupLabel= "- Qrup: ";
	private static String mltrCategoryLabel="- Kateqoriya: ";
	private static String mltrStaffLabel="- Heyət: ";
	private static String mltrRankLabel="- Rütbə: ";
	public static String getRegUrl() {
		return Parameters.regUrl;
	}

	public static String getDscpUrl() {
		return Parameters.dscpUrl;
	}
	
	public static String getMltrUrl() {
		return Parameters.mltrUrl;
	}

	public static String getFmlUrl() {
		return Parameters.fmlUrl;
	}

	public static String getFmlNameLabel() {
		return Parameters.fmlNameLabel;
	}

	public static String getFmlSurnameLabel() {
		return Parameters.fmlSurnameLabel;
	}

	public static String getFmlFatherNameLabel() {
		return Parameters.fmlFatherNameLabel;
	}
	
	public static String getFmlBirthdayLabel() {
		return Parameters.fmlBirthdayLabel;
	}

	public static String getDscpYsubtyLabel() {
		return Parameters.dscpYsubtyLabel;
	}

	public static String getDscpStartDateLabel() {
		return Parameters.dscpStartDateLabel;
	}

	public static String getDscpEndDateLabel() {
		return Parameters.dscpEndDateLabel;
	}

	public static String getPrsnlUrl() {
		return Parameters.prsnlUrl;
	}
	
	public static String getWrkUrl() {
		return Parameters.wrkUrl;
	}

	public static String getprsnlSerialNumberLabel() {
		return Parameters.prsnlSerialNumberLabel;
	}

	public static String getprsnlIssuanceDateLabel() {
		return Parameters.prsnlIssuanceDateLabel;
	}

	public static String getprsnlIssuingAuthorityLabel() {
		return Parameters.prsnlIssuingAuthorityLabel;
	}

	public static String getprsnlExpirationDateLabel() {
		return Parameters.prsnlExpirationDateLabel;
	}

	public static String getprsnlpinCodeLabel() {
		return Parameters.prsnlPinCodeLabel;
	}

	public static String getMltrSeriesLabel() {
		return Parameters.mltrSeriesLabel;
	}


	public static String getMltrIdNumberLabel() {
		return Parameters.mltrIdNumberLabel;
	}

	public static String getMltrIssueDateLabel() {
		return Parameters.mltrIssueDateLabel;
	}


	public static String getMltrExpiryDateLabel() {
		return Parameters.mltrExpiryDateLabel;
	}

	public static String getMltrFitLabel() {
		return Parameters.mltrFitLabel;
	}

	public static String getMltrGroupLabel() {
		return Parameters.mltrGroupLabel;
	}


	public static String getMltrCategoryLabel() {
		return Parameters.mltrCategoryLabel;
	}

	public static String getMltrStaffLabel() {
		return Parameters.mltrStaffLabel;
	}

	public static String getMltrRankLabel() {
		return Parameters.mltrRankLabel;
	}

	public static void setMltrRankLabel(String mltrRankLabel) {
		Parameters.mltrRankLabel = mltrRankLabel;
	}

}
