package kr.co.youiwe.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import kr.co.youiwe.webservice.ServiceSMSSoapProxy;

public class BitSms {
	//from => 01025598279
	public void sendMsg(String from, String to, String msg) {
		
		String smsID= "rola";	
		String smsPW="bit123400";
		
		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try{		
		String senderPhone= from;		
		String receivePhone= to;		
		String smsContent= msg;
		String test1 = (smsID+smsPW+receivePhone);
		CEncrypt encrypt = new CEncrypt("MD5",test1);
		java.lang.String send=sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
 		System.out.println("결과코드:"+send);
		}catch(Exception e){
		System.out.println("Exception in main:" +e);
		}
	}
}
