<?php

 
	 function xml($pernr)
    {

	$str='<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:sap-com:document:sap:soap:functions:mc-style">
	   <soapenv:Header/>
	   <soapenv:Body>
		  <urn:RegistrationR>
		     <IEmail>?</IEmail>
		     <IInsuirance>?</IInsuirance>
		     <IPernr>?</IPernr>
		     <IPin>?</IPin>
		  </urn:RegistrationR>
	   </soapenv:Body>
	</soapenv:Envelope>';
		

		$server='http://socdev00.socar.local:8000/sap/bc/srt/rfc/sap/yws_registration_r/430/yws_registration_r/yws_registration_r';
	
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




		return '<?xml version="1.0" encoding="UTF-8"?>'.$xml;

 }
echo xml('820041');

