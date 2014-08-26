<?php
	$str=' 	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:sap-com:document:sap:soap:functions:mc-style">
			   <soapenv:Header/>
			   <soapenv:Body>
				  <urn:DriversLicenseR>
					 <Pernr>'.$_GET["lcs_pernr"].'</Pernr>
				  </urn:DriversLicenseR>
			   </soapenv:Body>
			</soapenv:Envelope>';


		$server='http://socdev00.socar.local:8000/sap/bc/srt/rfc/sap/yws_drivers_license_r/430/yws_drivers_license_r/yws_drivers_license_r';
	
		$postfields = $str; 
	

	
		$curl_handle=curl_init();
		curl_setopt($curl_handle, CURLOPT_URL,$server);
		curl_setopt($curl_handle, CURLOPT_HTTPHEADER, array('Content-Type: text/xml'));
		curl_setopt($curl_handle, CURLOPT_POSTFIELDS, $postfields);
		curl_setopt($curl_handle, CURLOPT_CONNECTTIMEOUT, 2);
		curl_setopt($curl_handle, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($curl_handle, CURLOPT_USERAGENT, 'Your application name');
		$xml = curl_exec($curl_handle);
		curl_close($curl_handle);




		echo '<?xml version="1.0" encoding="UTF-8"?>'.$xml;



