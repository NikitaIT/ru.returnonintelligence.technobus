package ru.returnonintelligence.technobus.services;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
/**
 * @author NIKIT on 11.07.2017.
 */
public interface GoogleConnectionService extends IHasUrl {

	GoogleClientSecrets getClientSecrets();

	Credential getCredentials();
	
	boolean exchangeCode(String code);
}
