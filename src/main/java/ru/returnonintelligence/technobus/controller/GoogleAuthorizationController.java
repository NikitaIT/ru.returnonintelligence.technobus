package ru.returnonintelligence.technobus.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.returnonintelligence.technobus.Global;
import ru.returnonintelligence.technobus.services.GoogleConnectionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author NIKIT on 11.07.2017.
 */
@RestController
public class GoogleAuthorizationController extends BaseController {

	@Autowired
	private GoogleConnectionService connection;
	
	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public void ask(HttpServletResponse response) throws IOException {
		
		// Step 1: Authorize --> ask for auth code
		String url = new GoogleAuthorizationCodeRequestUrl(connection.getClientSecrets(), 
				connection.getRedirectUrl(), Global.SCOPES)
//				.setApprovalPrompt("auto")
				.setApprovalPrompt("force")
				.build();

		LOGGER.debug("Go to the following link in your browser: ");
		LOGGER.debug(url);
		
		response.sendRedirect(url);
	}
}
