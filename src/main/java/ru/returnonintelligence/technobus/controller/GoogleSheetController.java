package ru.returnonintelligence.technobus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.returnonintelligence.technobus.services.GoogleConnectionService;
import ru.returnonintelligence.technobus.services.GoogleSheetsService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * @author NIKIT on 11.07.2017.
 */
@RestController
public class GoogleSheetController extends BaseController {

	@Autowired
	private GoogleConnectionService connection;

	@Autowired
	private GoogleSheetsService sheetsService;

	@RequestMapping(value = "/api/sheet", method = RequestMethod.GET)
	public ResponseEntity<List<List<Object>>> read(HttpServletResponse response) throws IOException {
		System.out.println("/api/sheet");

		// read spreadsheet
		List<List<Object>> responseBody = sheetsService.readTable(connection);
		
		return new ResponseEntity<List<List<Object>>>(responseBody, HttpStatus.OK);
	}
}
