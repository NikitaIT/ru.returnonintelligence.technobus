package ru.returnonintelligence.technobus.services;

import java.io.IOException;
import java.util.List;
/**
 * @author NIKIT on 11.07.2017.
 */
public interface GoogleSheetsService {

	List<List<Object>> readTable(GoogleConnectionService gc)  throws IOException;
}
