package ru.returnonintelligence.technobus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.returnonintelligence.technobus.services.GoogleConnectionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author NIKIT on 11.07.2017.
 */
@RestController
public class GoogleCallbackController extends BaseController {

	@Autowired
	private GoogleConnectionService connection;

	@RequestMapping(value = "/oauth2callback", method = RequestMethod.GET)
	public void callback(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
		if (connection.exchangeCode(code)) {
			response.sendRedirect(connection.getSourceUrl());
		} else {
			response.sendRedirect("/error");
		}
	}
}
