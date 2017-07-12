package ru.returnonintelligence.technobus.services.impl;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.returnonintelligence.technobus.Global;
import ru.returnonintelligence.technobus.services.GoogleConnectionService;
import ru.returnonintelligence.technobus.services.GoogleSheetsService;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleSheetsServiceImpl implements GoogleSheetsService {

	@Value("${google.app.name}")
	String appName;
	
	@Value("${google.spreadsheet.id}")
	String spreadsheetId;
	
	@Value("${google.spreadsheet.sheet.name}")
	String sheetName;

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSheetsServiceImpl.class);

	private Sheets sheetsService = null;

	@Override
	public List<List<Object>> readTable(GoogleConnectionService connection)  throws IOException {
		Sheets service = getSheetsService(connection);
		return readTable(service, spreadsheetId, sheetName);
	}
	
	private Sheets getSheetsService(GoogleConnectionService gc) throws IOException {
		if (this.sheetsService == null) {
			return new Sheets.Builder(Global.HTTP_TRANSPORT, Global.JSON_FACTORY, gc.getCredentials())
					.setApplicationName(appName).build();
		} else {
			return this.sheetsService;
		}
	}
	
	private List<List<Object>> readTable(Sheets service, String spreadsheetId, String sheetName)  throws IOException {
		ValueRange table = service.spreadsheets().values().get(spreadsheetId, sheetName)
				.execute();

		List<List<Object>> values = table.getValues();
		printTable(values);
		
		return values;
	}
	
	private void printTable(List<List<Object>> values) {
		if (values == null || values.size() == 0) {
			LOGGER.debug("No data found.");
		}

		else {
			LOGGER.debug("read data");
			for (List<Object> row : values) {
				StringBuilder dbg = new StringBuilder();
				for (int c = 0; c < row.size(); c++) {
					dbg.append(row.get(c));
				}
				LOGGER.debug(dbg.toString());
			}
		}
	}

}
