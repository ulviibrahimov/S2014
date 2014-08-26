package com.socar.hrsocar.model;

public class Parameters {
	//ursl
	private static String regUrl = "http://192.168.1.192:8585/xml/req1.php";
	private static String dscpUrl="http://192.168.1.192:8585/xml/dscp.php";
	private static String mltrUrl="http://192.168.1.192:8585/xml/mltr.php";
	private static String fmlUrl ="http://192.168.1.192:8585/xml/fml.php";
	private static String prsnlUrl ="http://192.168.1.192:8585/xml/prsnl.php";
	private static String wrkUrl ="http://192.168.1.192:8585/xml/wrk.php";
	private static String edUrl="http://192.168.1.192:8585/xml/ed.php";
	private static String absUrl="http://192.168.1.192:8585/xml/abs.php";
	private static String lbcUrl="http://192.168.1.192:8585/xml/lbc.php";
	private static String pyrlUrl="http://192.168.1.192:8585/xml/pyrl.php";
	private static String lcsUrl="http://192.168.1.192:8585/xml/lcs.php";
	//Parameters for FamilyActivity
	private static String fmlNameLabel="\t\tAd: ";
	private static String fmlSurnameLabel="\t\tSoyad: ";
	private static String fmlFatherNameLabel="\t\tAta adı: ";
	private static String fmlBirthdayLabel="\t\tDoğum tarixi: ";
	
	//Parameters for Disciplinary Activity
	private static String dscpYsubtyLabel= "Ysubty: ";
	private static String dscpStartDateLabel="\t\tBaşlama tarixi: ";
	private static String dscpEndDateLabel="\t\tBitmə tarixi: ";
	
	//Parameters for Personal Activity
	private static String prsnlSerialNumberLabel= "\t\tVəsiqənin nömrəsi: ";
	private static String prsnlIssuanceDateLabel="\t\tVerilmə tarixi: ";
	private static String prsnlIssuingAuthorityLabel="\t\tVəsiqəni verən orqanın adı: ";
	private static String prsnlExpirationDateLabel="\t\tEtibarlılıq müddəti: ";
	private static String prsnlPinCodeLabel="\t\tVəsiqənin pinkodu: ";	
	
	//Parameters for Military Activity
	private static String mltrSeriesLabel= "\t\tSeriyası: ";
	private static String mltrIdNumberLabel="\t\tNömrəsi: ";
	private static String mltrIssueDateLabel="\t\tBaşlama tarixi: ";
	private static String mltrExpiryDateLabel="\t\tBitmə tarixi: ";
	private static String mltrFitLabel="\t\tYararlılıq: ";	
	private static String mltrGroupLabel= "\t\tUçot qrupu: ";
	private static String mltrCategoryLabel="\t\tKateqoriya: ";
	private static String mltrStaffLabel="\t\tHeyəti: ";
	private static String mltrRankLabel="\t\tHərbi Rütbə: ";
	
	//Parameters for Education activity
	private static String edBegdaLabel ="\t\tBaşlama tarixi: ";
	private static String edEnddaLabel="\t\tBitmə tarixi: ";
	private static String edCountryLabel="\t\tÖlkə: ";
	private static String edScientificDegreeLabel="\t\tElmi dərəcə: ";
	private static String edEduDegreeLabel="\t\tTəhsil: ";
	private static String edDocumentTypeLabel="\t\tSənəd: ";
	private static String edFinalGradeLabel="\t\tQiymət: ";
	private static String edEduInstitutionLabel="\t\tTəhsil müəssisəsi: ";
	private static String edIstigametLabel="\t\tİstiqamət: ";
	private static String edMajorLabel="\t\tİxtisas: ";
	private static String edEduTypeLabel="\t\tTəhsil forması: ";
	private static String edDipNumLabel="\t\tDiplom nömrəsi: ";
	
	//Parameters for Labor Activity
	private static String lbcBegdaLabel ="\t\tİşə qəbul tarixi: ";
	private static String lbcEnddaLabel="\t\tİşdən azad olma tarixi: ";
	private static String lbcSubtyLabel="\t\tİşdən azad : ";
	private static String lbcCvtypLabel="\t\tElmi dərəcə: ";
	private static String lbcCvtxtLabel="\t\tTəhsil: ";
	private static String lbcDuryyLabel="\t\tIllər: ";
	private static String lbcDurmmLabel="\t\tAylar: ";
	private static String lbcDurddLabel="\t\tGünlər: ";
	private static String lbcwrkboLabel="\t\tİstiqamət: ";
	private static String lbcwrkopLabel="\t\tİxtisas: ";
	private static String lbcPositLabel="\t\tTəhsil forması: ";
	private static String lbcSpheres1Label="\t\tDiplom nömrəsi: ";
	private static String lbcPtextLabel="\t\tQiymət: ";
	private static String lbcPerskLabel="\t\tTəhsil müəssisəsi: ";
	private static String lbcTrfs1Label="\t\tİstiqamət: ";
	private static String lbcDeparLabel="\t\tİxtisas: ";
	public static String getRegUrl() {
		return Parameters.regUrl;
	}

	public static String getDscpUrl() {
		return Parameters.dscpUrl;
	}
	public static String getLcsUrl() {
		return Parameters.lcsUrl;
	}
	public static String getPyrlUrl() {
		return Parameters.pyrlUrl;
	}
	public static String getLbcUrl() {
		return Parameters.lbcUrl;
	}
	public static String getAbsUrl() {
		return Parameters.absUrl;
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
	public static String getEdUrl() {
		return Parameters.edUrl;
	}

	public static String getEdBegdaLabel() {
		return edBegdaLabel;
	}

	public static String getEdEnddaLabel() {
		return edEnddaLabel;
	}

	public static String getEdCountryLabel() {
		return edCountryLabel;
	}
	public static String getEdScientificDegreeLabel() {
		return edScientificDegreeLabel;
	}

	public static String getEdEduDegreeLabel() {
		return edEduDegreeLabel;
	}

	public static String getEdDocumentTypeLabel() {
		return edDocumentTypeLabel;
	}
	public static String getEdFinalGradeLabel() {
		return edFinalGradeLabel;
	}

	public static String getEdEduInstitutionLabel() {
		return edEduInstitutionLabel;
	}

	public static String getEdIstigametLabel() {
		return edIstigametLabel;
	}


	public static String getEdMajorLabel() {
		return edMajorLabel;
	}

	public static String getEdEduTypeLabel() {
		return edEduTypeLabel;
	}

	public static String getEdDipNumLabel() {
		return edDipNumLabel;
	}

	public static String getLbcBegdaLabel() {
		return lbcBegdaLabel;
	}

	public static String getLbcEnddaLabel() {
		return lbcEnddaLabel;
	}

	public static String getLbcSubtyLabel() {
		return lbcSubtyLabel;
	}

	public static String getLbcCvtypLabel() {
		return lbcCvtypLabel;
	}

	public static String getLbcCvtxtLabel() {
		return lbcCvtxtLabel;
	}

	public static String getLbcDuryyLabel() {
		return lbcDuryyLabel;
	}

	public static String getLbcDurmmLabel() {
		return lbcDurmmLabel;
	}

	public static String getLbcDurddLabel() {
		return lbcDurddLabel;
	}

	public static String getLbcwrkboLabel() {
		return lbcwrkboLabel;
	}

	public static String getLbcwrkopLabel() {
		return lbcwrkopLabel;
	}

	public static String getLbcPositLabel() {
		return lbcPositLabel;
	}

	public static String getLbcSpheres1Label() {
		return lbcSpheres1Label;
	}

	public static String getLbcPtextLabel() {
		return lbcPtextLabel;
	}

	public static String getLbcPerskLabel() {
		return lbcPerskLabel;
	}

	public static String getLbcTrfs1Label() {
		return lbcTrfs1Label;
	}

	public static String getLbcDeparLabel() {
		return lbcDeparLabel;
	}


}
